package com.evoslab.cookielicious.core.datagen;

import com.evoslab.cookielicious.core.Cookielicious;
import com.evoslab.cookielicious.core.registry.CookieliciousBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import com.evoslab.cookielicious.core.registry.CookieliciousBlocks.ToolType;

import java.util.Objects;
import java.util.function.Supplier;

public class CBlockTagProvider extends BlockTagsProvider {

    public CBlockTagProvider(DataGenerator dataGen, @Nullable ExistingFileHelper fileHelper) {
        super(dataGen, Cookielicious.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags() {
        effectiveToolTags();
    }

    private void effectiveToolTags() {
        for (RegistryObject<Block> block : CookieliciousBlocks.EFFECTIVE_TOOL_MAP.keySet()) {
            ToolType toolType = CookieliciousBlocks.EFFECTIVE_TOOL_MAP.get(block);

            switch (toolType) {
                case AXE -> addVariantBlockRepoToTag(block, BlockTags.MINEABLE_WITH_AXE);
                case HOE -> addVariantBlockRepoToTag(block, BlockTags.MINEABLE_WITH_HOE);
                case SHOVEL -> addVariantBlockRepoToTag(block, BlockTags.MINEABLE_WITH_SHOVEL);
                case PICKAXE -> addVariantBlockRepoToTag(block, BlockTags.MINEABLE_WITH_PICKAXE);
            }
        }
    }

    private void addVariantBlockRepoToTag(Supplier<? extends Block> blocks, TagKey<Block> blockTag) {
        Objects.requireNonNull(blocks);
        Objects.requireNonNull(blockTag);

        tag(blockTag).add(blocks.get());
    }
}
