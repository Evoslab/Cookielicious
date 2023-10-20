package com.evoslab.cookielicious.core.datagen.server;

import com.evoslab.cookielicious.core.Cookielicious;
import com.evoslab.cookielicious.core.registry.CookieliciousBlocks;
import com.teamabnormals.blueprint.core.other.tags.BlueprintItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class CItemTagsProvider extends ItemTagsProvider {

    public CItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, Cookielicious.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        CookieliciousBlocks.ALL_TILE_SLABS.forEach(block -> tag(ItemTags.SLABS).add(block.get().asItem()));
        CookieliciousBlocks.ALL_TILE_STAIRS.forEach(block -> tag(ItemTags.STAIRS).add(block.get().asItem()));
        CookieliciousBlocks.ALL_TILE_WALLS.forEach(block -> tag(ItemTags.WALLS).add(block.get().asItem()));
        CookieliciousBlocks.ALL_TILE_VERTICAL_SLABS.forEach(block -> tag(BlueprintItemTags.VERTICAL_SLABS).add(block.get().asItem()));
    }
}
