package com.carsonkasper.skylands;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;

public final class SimpleFaceAttachedBlock extends FaceAttachedHorizontalDirectionalBlock {
    public static final MapCodec<SimpleFaceAttachedBlock> CODEC = simpleCodec(SimpleFaceAttachedBlock::new);

    public SimpleFaceAttachedBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACE, AttachFace.WALL).setValue(FACING, Direction.NORTH));
    }

    @Override
    public MapCodec<SimpleFaceAttachedBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(FACE, FACING);
    }
}
