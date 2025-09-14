package com.sysnote8.moremobility.mixin;

import com.sysnote8.moremobility.MMConfig;
import com.sysnote8.moremobility.tag.MMTags;
import io.github.foundationgames.automobility.automobile.AutomobileWheel;
import io.github.foundationgames.automobility.entity.AutomobileEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AutomobileEntity.class, remap = false)
public abstract class MixinAutomobileEntity extends Entity {
    @Shadow
    private float hSpeed;

    @Shadow
    private AutomobileWheel wheels;

    public MixinAutomobileEntity(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Inject(
            method = "movementTick",
            at = @At(value = "FIELD", target = "Lio/github/foundationgames/automobility/entity/AutomobileEntity;hSpeed:F", opcode = Opcodes.PUTFIELD, shift = At.Shift.AFTER)
    )
    private void applyOffroadSlowness(CallbackInfo ci) {
        // If disabled, early-return
        if (!MMConfig.offroadSlowness) return;

        // If non-tagged block (=non-paved), apply slowness
        if (!getBlockStateOn().is(MMTags.AUTOMOBILITY_ON_ROAD)) {
            if (wheels == AutomobileWheel.OFF_ROAD) {
                hSpeed *= 0.8F;
            } else {
                hSpeed *= 0.5F;
            }
        }
    }
}
