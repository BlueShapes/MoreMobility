package com.sysnote8.moremobility.mixin;

import com.mojang.logging.LogUtils;
import com.sysnote8.moremobility.MMTags;
import io.github.foundationgames.automobility.entity.AutomobileEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AutomobileEntity.class, remap = false)
public abstract class MixinAutomobileEntity extends Entity {
    @Shadow private float hSpeed;

    public MixinAutomobileEntity(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Inject(
            method = "movementTick",
            at = @At(value = "FIELD", target = "Lio/github/foundationgames/automobility/entity/AutomobileEntity;hSpeed:F", opcode = Opcodes.PUTFIELD, shift = At.Shift.AFTER)
    )
    private void afterPutHSpeed(CallbackInfo ci) {
        if(!getBlockStateOn().is(MMTags.AUTOMOBILITY_ON_ROAD)) {
            hSpeed *= 0.5F;
        }
    }
}
