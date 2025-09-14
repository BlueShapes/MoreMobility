package com.sysnote8.moremobility.attachment;

import io.github.foundationgames.automobility.automobile.attachment.FrontAttachmentType;
import io.github.foundationgames.automobility.automobile.attachment.front.CropHarvesterFrontAttachment;
import io.github.foundationgames.automobility.entity.AutomobileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;

public class AdvancedCropHarvesterAttachment extends CropHarvesterFrontAttachment {
    private static final float additionalRange = 2.0f;

    public AdvancedCropHarvesterAttachment(FrontAttachmentType<?> type, AutomobileEntity automobile) {
        super(type, automobile);
    }

    @Override
    public void harvest(Vec3 pos, ServerLevel world) {
        float rangeModifier = additionalRange + 0.5f;
        int minX = (int) Math.floor(pos.x - rangeModifier);
        int maxX = (int) Math.floor(pos.x + rangeModifier);
        int minZ = (int) Math.floor(pos.z - rangeModifier);
        int maxZ = (int) Math.floor(pos.z + rangeModifier);

        int y = (int) Math.floor(pos.y + 0.25);

        Entity entity = this.automobile;
        if (this.automobile.isVehicle()) {
            entity = this.automobile.getFirstPassenger();
        }

        var currentBlockPos = new BlockPos.MutableBlockPos();
        for (int x = minX; x <= maxX; x++) {
            for (int z = minZ; z <= maxZ; z++) {
                currentBlockPos.set(x, y, z);
                var state = world.getBlockState(currentBlockPos);
                if (canHarvest(state)) {
                    var stacks = Block.getDrops(state, world, currentBlockPos, null, entity, ItemStack.EMPTY);
                    world.destroyBlock(currentBlockPos, false);
                    this.onBlockHarvested(state, currentBlockPos, stacks);
                }
            }
        }
    }
}
