package com.evoslab.cookielicious.datagen;

import co.eltrut.differentiate.common.repo.VariantBlocksRepo;
import com.evoslab.cookielicious.common.core.Cookielicious;
import com.evoslab.cookielicious.common.core.registry.CookieliciousBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import com.evoslab.cookielicious.common.core.registry.CookieliciousBlocks.ToolType;

import java.util.Objects;

public class CBlockTagProvider extends BlockTagsProvider {

    public CBlockTagProvider(DataGenerator dataGen, @Nullable ExistingFileHelper fileHelper) {
        super(dataGen, Cookielicious.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags() {
        effectiveToolTags();
    }

    private void effectiveToolTags() {
        for (VariantBlocksRepo blockRepo : CookieliciousBlocks.EFFECTIVE_TOOL_MAP.keySet()) {
            ToolType toolType = CookieliciousBlocks.EFFECTIVE_TOOL_MAP.get(blockRepo);

            switch (toolType) {
                case AXE -> addVariantBlockRepoToTag(blockRepo, BlockTags.MINEABLE_WITH_AXE);
                case HOE -> addVariantBlockRepoToTag(blockRepo, BlockTags.MINEABLE_WITH_HOE);
                case SHOVEL -> addVariantBlockRepoToTag(blockRepo, BlockTags.MINEABLE_WITH_SHOVEL);
                case PICKAXE -> addVariantBlockRepoToTag(blockRepo, BlockTags.MINEABLE_WITH_PICKAXE);
            }
        }
    }

    private void addVariantBlockRepoToTag(VariantBlocksRepo blocksRepo, TagKey<Block> blockTag) {
        Objects.requireNonNull(blocksRepo);
        Objects.requireNonNull(blockTag);

        tag(blockTag).add(
                blocksRepo.getBlock().get(),
                blocksRepo.getSlabBlock().get(),
                blocksRepo.getStairsBlock().get(),
                blocksRepo.getWallBlock().get(),
                blocksRepo.getVerticalSlabBlock().get()
        );
    }
}
