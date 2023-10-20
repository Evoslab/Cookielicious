package com.evoslab.cookielicious.core.datagen.client;

import com.evoslab.cookielicious.core.Cookielicious;
import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.evoslab.cookielicious.core.datagen.CDatagenUtil.*;
import static com.evoslab.cookielicious.core.registry.CookieliciousBlocks.*;

public class CBlockStateProvider extends BlockStateProvider {

    public CBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Cookielicious.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        cookieTileVariants(COOKIE_TILES, COOKIE_TILE_STAIRS, COOKIE_TILE_SLAB, COOKIE_TILE_WALL, COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(STRAWBERRY_COOKIE_TILES, STRAWBERRY_COOKIE_TILE_STAIRS, STRAWBERRY_COOKIE_TILE_SLAB, STRAWBERRY_COOKIE_TILE_WALL, STRAWBERRY_COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(CHOCOLATE_COOKIE_TILES, CHOCOLATE_COOKIE_TILE_STAIRS, CHOCOLATE_COOKIE_TILE_SLAB, CHOCOLATE_COOKIE_TILE_WALL, CHOCOLATE_COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(VANILLA_COOKIE_TILES, VANILLA_COOKIE_TILE_STAIRS, VANILLA_COOKIE_TILE_SLAB, VANILLA_COOKIE_TILE_WALL, VANILLA_COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(HONEY_COOKIE_TILES, HONEY_COOKIE_TILE_STAIRS, HONEY_COOKIE_TILE_SLAB, HONEY_COOKIE_TILE_WALL, HONEY_COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(SWEET_BERRY_COOKIE_TILES, SWEET_BERRY_COOKIE_TILE_STAIRS, SWEET_BERRY_COOKIE_TILE_SLAB, SWEET_BERRY_COOKIE_TILE_WALL, SWEET_BERRY_COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(BANANA_COOKIE_TILES, BANANA_COOKIE_TILE_STAIRS, BANANA_COOKIE_TILE_SLAB, BANANA_COOKIE_TILE_WALL, BANANA_COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(MINT_COOKIE_TILES, MINT_COOKIE_TILE_STAIRS, MINT_COOKIE_TILE_SLAB, MINT_COOKIE_TILE_WALL, MINT_COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(ADZUKI_COOKIE_TILES, ADZUKI_COOKIE_TILE_STAIRS, ADZUKI_COOKIE_TILE_SLAB, ADZUKI_COOKIE_TILE_WALL, ADZUKI_COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(CHERRY_COOKIE_TILES, CHERRY_COOKIE_TILE_STAIRS, CHERRY_COOKIE_TILE_SLAB, CHERRY_COOKIE_TILE_WALL, CHERRY_COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(MULBERRY_COOKIE_TILES, MULBERRY_COOKIE_TILE_STAIRS, MULBERRY_COOKIE_TILE_SLAB, MULBERRY_COOKIE_TILE_WALL, MULBERRY_COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(MAPLE_COOKIE_TILES, MAPLE_COOKIE_TILE_STAIRS, MAPLE_COOKIE_TILE_SLAB, MAPLE_COOKIE_TILE_WALL, MAPLE_COOKIE_TILE_VERTICAL_SLAB);
        cookieTileVariants(GOOSEBERRY_JAM_COOKIE_TILES, GOOSEBERRY_JAM_COOKIE_TILE_STAIRS, GOOSEBERRY_JAM_COOKIE_TILE_SLAB, GOOSEBERRY_JAM_COOKIE_TILE_WALL, GOOSEBERRY_JAM_COOKIE_TILE_VERTICAL_SLAB);
    }

    private void cookieTileVariants(Supplier<? extends Block> base, Supplier<? extends Block> stair, Supplier<? extends Block> slab, Supplier<? extends Block> wall, Supplier<? extends Block> verticalSlab) {
        basicBlock(base);
        modStairsBlock(stair, base);
        modSlabBlock(slab, base);
        modWallBlock(wall, base);
        modVerticalSlabBlock(verticalSlab, base);
    }

    private void basicBlock(Supplier<? extends Block> block) {
        simpleBlock(block.get());
        basicBlockItem(block);
    }

    private void basicBlockItem(Supplier<? extends Block> blockForItem) {
        simpleBlockItem(blockForItem.get(), new ModelFile.ExistingModelFile(modBlockLocation(name(blockForItem.get())), this.models().existingFileHelper));
    }

    private void modStairsBlock(Supplier<? extends Block> stair, Supplier<? extends Block> base) {
        stairsBlock((StairBlock) stair.get(), modBlockLocation(name(base.get())));
        basicBlockItem(stair);
    }

    private void modSlabBlock(Supplier<? extends Block> slab, Supplier<? extends Block> base) {
        slabBlock((SlabBlock) slab.get(), modBlockLocation(name(base.get())), modBlockLocation(name(base.get())));
        basicBlockItem(slab);
    }

    private void modWallBlock(Supplier<? extends Block> wall, Supplier<? extends Block> base) {
        wallBlock((WallBlock) wall.get(), modBlockLocation(name(base.get())));
        this.itemModels().getBuilder(name(wall.get())).parent(this.models().wallInventory(name(wall.get()) + "_inventory", modBlockLocation(name(base.get()))));
    }

    private void modVerticalSlabBlock(Supplier<? extends Block> verticalSlab, Supplier<? extends Block> base) {
        ModelFile model = this.models()
                .withExistingParent(name(verticalSlab.get()), modBlockLocation("vertical_slab"))
                .texture("top", modBlockLocation(name(base.get())))
                .texture("bottom", modBlockLocation(name(base.get())))
                .texture("side", modBlockLocation(name(base.get())));

        getVariantBuilder(verticalSlab.get())
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.NORTH).addModels(new ConfiguredModel(model, 0, 0, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.SOUTH).addModels(new ConfiguredModel(model, 0, 180, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.EAST).addModels(new ConfiguredModel(model, 0, 90, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.WEST).addModels(new ConfiguredModel(model, 0, 270, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.DOUBLE).addModels(new ConfiguredModel(this.models().getExistingFile(modBlockLocation(name(base.get())))));

        basicBlockItem(verticalSlab);
    }
}
