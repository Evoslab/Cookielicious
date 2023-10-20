package com.evoslab.cookielicious.core.datagen.server;

import com.evoslab.cookielicious.core.registry.CookieliciousBlocks;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLootTableProvider extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> lootTables = ImmutableList.of(Pair.of(CBlockLoot::new, LootContextParamSets.BLOCK));

    public CLootTableProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return this.lootTables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
    }

    private static class CBlockLoot extends BlockLoot {

        @Override
        protected void addTables() {
            CookieliciousBlocks.ALL_TILES.forEach(block -> dropSelf(block.get()));
            CookieliciousBlocks.ALL_TILE_STAIRS.forEach(block -> dropSelf(block.get()));
            CookieliciousBlocks.ALL_TILE_SLABS.forEach(block -> this.add(block.get(), BlockLoot::createSlabItemTable));
            CookieliciousBlocks.ALL_TILE_WALLS.forEach(block -> dropSelf(block.get()));
            CookieliciousBlocks.ALL_TILE_VERTICAL_SLABS.forEach(block -> this.add(block.get(), BlockLoot::createSlabItemTable));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return CookieliciousBlocks.HELPER.getDeferredRegister().getEntries().stream().map(RegistryObject::get)::iterator;
        }

    }
}
