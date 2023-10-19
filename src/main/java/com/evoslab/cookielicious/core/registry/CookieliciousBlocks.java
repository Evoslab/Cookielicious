package com.evoslab.cookielicious.core.registry;


import com.evoslab.cookielicious.core.Cookielicious;
import com.evoslab.cookielicious.core.other.CookieliciousCompat;
import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Cookielicious.MOD_ID, bus = Bus.MOD)
public class CookieliciousBlocks {

	public static final BlockSubRegistryHelper HELPER = Cookielicious.REGISTRY_HELPER.getBlockSubHelper();

	public static final Map<RegistryObject<Block>, ToolType> EFFECTIVE_TOOL_MAP = new HashMap<>();
	public static final List<RegistryObject<Block>> ALL_TILES = new ArrayList<>();
	public static final List<RegistryObject<Block>> ALL_TILE_STAIRS = new ArrayList<>();
	public static final List<RegistryObject<Block>> ALL_TILE_SLABS = new ArrayList<>();
	public static final List<RegistryObject<Block>> ALL_TILE_WALLS = new ArrayList<>();
	public static final List<RegistryObject<Block>> ALL_TILE_VERTICAL_SLABS = new ArrayList<>();
	
	// Cookie Tiles
	public static final RegistryObject<Block> COOKIE_TILES = registerCookieTiles("cookie_tiles", ToolType.HOE, CookieliciousCompat.MINECRAFT);
	public static final RegistryObject<Block> COOKIE_TILE_STAIRS = registerCookieStairs("cookie_tile_stairs", COOKIE_TILES, ToolType.HOE, CookieliciousCompat.MINECRAFT);
	public static final RegistryObject<Block> COOKIE_TILE_SLAB = registerCookieSlabs("cookie_tile_slab", ToolType.HOE, CookieliciousCompat.MINECRAFT);
	public static final RegistryObject<Block> COOKIE_TILE_WALL = registerCookieWalls("cookie_tile_wall", ToolType.HOE, CookieliciousCompat.MINECRAFT);
	public static final RegistryObject<Block> COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> STRAWBERRY_COOKIE_TILES = registerCookieTiles("strawberry_cookie_tiles", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> STRAWBERRY_COOKIE_TILE_STAIRS = registerCookieStairs("strawberry_cookie_tile_stairs", STRAWBERRY_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> STRAWBERRY_COOKIE_TILE_SLAB = registerCookieSlabs("strawberry_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> STRAWBERRY_COOKIE_TILE_WALL = registerCookieWalls("strawberry_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> STRAWBERRY_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("strawberry_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> CHOCOLATE_COOKIE_TILES = registerCookieTiles("chocolate_cookie_tiles", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> CHOCOLATE_COOKIE_TILE_STAIRS = registerCookieStairs("chocolate_cookie_tile_stairs", CHOCOLATE_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> CHOCOLATE_COOKIE_TILE_SLAB = registerCookieSlabs("chocolate_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> CHOCOLATE_COOKIE_TILE_WALL = registerCookieWalls("chocolate_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> CHOCOLATE_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("chocolate_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> VANILLA_COOKIE_TILES = registerCookieTiles("vanilla_cookie_tiles", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> VANILLA_COOKIE_TILE_STAIRS = registerCookieStairs("vanilla_cookie_tile_stairs", VANILLA_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> VANILLA_COOKIE_TILE_SLAB = registerCookieSlabs("vanilla_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> VANILLA_COOKIE_TILE_WALL = registerCookieWalls("vanilla_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> VANILLA_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("vanilla_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> HONEY_COOKIE_TILES = registerCookieTiles("honey_cookie_tiles", ToolType.HOE, CookieliciousCompat.FARMERS_DELIGHT);
	public static final RegistryObject<Block> HONEY_COOKIE_TILE_STAIRS = registerCookieStairs("honey_cookie_tile_stairs", HONEY_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.FARMERS_DELIGHT);
	public static final RegistryObject<Block> HONEY_COOKIE_TILE_SLAB = registerCookieSlabs("honey_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.FARMERS_DELIGHT);
	public static final RegistryObject<Block> HONEY_COOKIE_TILE_WALL = registerCookieWalls("honey_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.FARMERS_DELIGHT);
	public static final RegistryObject<Block> HONEY_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("honey_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.FARMERS_DELIGHT, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> SWEET_BERRY_COOKIE_TILES = registerCookieTiles("sweet_berry_cookie_tiles", ToolType.HOE, CookieliciousCompat.FARMERS_DELIGHT);
	public static final RegistryObject<Block> SWEET_BERRY_COOKIE_TILE_STAIRS = registerCookieStairs("sweet_berry_cookie_tile_stairs", SWEET_BERRY_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.FARMERS_DELIGHT);
	public static final RegistryObject<Block> SWEET_BERRY_COOKIE_TILE_SLAB = registerCookieSlabs("sweet_berry_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.FARMERS_DELIGHT);
	public static final RegistryObject<Block> SWEET_BERRY_COOKIE_TILE_WALL = registerCookieWalls("sweet_berry_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.FARMERS_DELIGHT);
	public static final RegistryObject<Block> SWEET_BERRY_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("sweet_berry_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.FARMERS_DELIGHT, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> BANANA_COOKIE_TILES = registerCookieTiles("banana_cookie_tiles", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> BANANA_COOKIE_TILE_STAIRS = registerCookieStairs("banana_cookie_tile_stairs", BANANA_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> BANANA_COOKIE_TILE_SLAB = registerCookieSlabs("banana_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> BANANA_COOKIE_TILE_WALL = registerCookieWalls("banana_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> BANANA_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("banana_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> MINT_COOKIE_TILES = registerCookieTiles("mint_cookie_tiles", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> MINT_COOKIE_TILE_STAIRS = registerCookieStairs("mint_cookie_tile_stairs", MINT_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> MINT_COOKIE_TILE_SLAB = registerCookieSlabs("mint_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> MINT_COOKIE_TILE_WALL = registerCookieWalls("mint_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> MINT_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("mint_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> ADZUKI_COOKIE_TILES = registerCookieTiles("adzuki_cookie_tiles", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> ADZUKI_COOKIE_TILE_STAIRS = registerCookieStairs("adzuki_cookie_tile_stairs", ADZUKI_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> ADZUKI_COOKIE_TILE_SLAB = registerCookieSlabs("adzuki_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> ADZUKI_COOKIE_TILE_WALL = registerCookieWalls("adzuki_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.NEAPOLITAN);
	public static final RegistryObject<Block> ADZUKI_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("adzuki_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.NEAPOLITAN, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> CHERRY_COOKIE_TILES = registerCookieTiles("cherry_cookie_tiles", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.ENVIRONMENTAL);
	public static final RegistryObject<Block> CHERRY_COOKIE_TILE_STAIRS = registerCookieStairs("cherry_cookie_tile_stairs", CHERRY_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.ENVIRONMENTAL);
	public static final RegistryObject<Block> CHERRY_COOKIE_TILE_SLAB = registerCookieSlabs("cherry_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.ENVIRONMENTAL);
	public static final RegistryObject<Block> CHERRY_COOKIE_TILE_WALL = registerCookieWalls("cherry_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.ENVIRONMENTAL);
	public static final RegistryObject<Block> CHERRY_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("cherry_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.ENVIRONMENTAL, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> MULBERRY_COOKIE_TILES = registerCookieTiles("mulberry_cookie_tiles", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.UPGRADE_AQUATIC);
	public static final RegistryObject<Block> MULBERRY_COOKIE_TILE_STAIRS = registerCookieStairs("mulberry_cookie_tile_stairs", MULBERRY_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.UPGRADE_AQUATIC);
	public static final RegistryObject<Block> MULBERRY_COOKIE_TILE_SLAB = registerCookieSlabs("mulberry_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.UPGRADE_AQUATIC);
	public static final RegistryObject<Block> MULBERRY_COOKIE_TILE_WALL = registerCookieWalls("mulberry_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.UPGRADE_AQUATIC);
	public static final RegistryObject<Block> MULBERRY_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("mulberry_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.UPGRADE_AQUATIC, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> MAPLE_COOKIE_TILES = registerCookieTiles("maple_cookie_tiles", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.AUTUMNITY);
	public static final RegistryObject<Block> MAPLE_COOKIE_TILE_STAIRS = registerCookieStairs("maple_cookie_tile_stairs", MAPLE_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.AUTUMNITY);
	public static final RegistryObject<Block> MAPLE_COOKIE_TILE_SLAB = registerCookieSlabs("maple_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.AUTUMNITY);
	public static final RegistryObject<Block> MAPLE_COOKIE_TILE_WALL = registerCookieWalls("maple_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.AUTUMNITY);
	public static final RegistryObject<Block> MAPLE_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("maple_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.ABNORMALS_DELIGHT, CookieliciousCompat.AUTUMNITY, CookieliciousCompat.QUARK);

	public static final RegistryObject<Block> GOOSEBERRY_JAM_COOKIE_TILES = registerCookieTiles("gooseberry_jam_cookie_tiles", ToolType.HOE, CookieliciousCompat.BAYOU_BLUES);
	public static final RegistryObject<Block> GOOSEBERRY_JAM_COOKIE_TILE_STAIRS = registerCookieStairs("gooseberry_jam_cookie_tile_stairs", GOOSEBERRY_JAM_COOKIE_TILES, ToolType.HOE, CookieliciousCompat.BAYOU_BLUES);
	public static final RegistryObject<Block> GOOSEBERRY_JAM_COOKIE_TILE_SLAB = registerCookieSlabs("gooseberry_jam_cookie_tile_slab", ToolType.HOE, CookieliciousCompat.BAYOU_BLUES);
	public static final RegistryObject<Block> GOOSEBERRY_JAM_COOKIE_TILE_WALL = registerCookieWalls("gooseberry_jam_cookie_tile_wall", ToolType.HOE, CookieliciousCompat.BAYOU_BLUES);
	public static final RegistryObject<Block> GOOSEBERRY_JAM_COOKIE_TILE_VERTICAL_SLAB = registerCookieVerticalSlab("gooseberry_jam_cookie_tile_vertical_slab", ToolType.HOE, CookieliciousCompat.BAYOU_BLUES, CookieliciousCompat.QUARK);

	public static class Properties {

    	public static final Block.Properties COOKIE = Block.Properties.of(Material.WOOD)
				.strength(2.0F, 3.0F)
				.sound(SoundType.WOOD);
    }

	public enum ToolType {
		PICKAXE,
		AXE,
		HOE,
		SHOVEL
	}

	private static RegistryObject<Block> registerCookieTiles(String name, @Nullable ToolType toolType, String... modIds) {
		RegistryObject<Block> blockObject = HELPER.createCompatBlock(name, () -> new Block(Properties.COOKIE), CreativeModeTab.TAB_BUILDING_BLOCKS, modIds);
		if (toolType != null) {
			EFFECTIVE_TOOL_MAP.put(blockObject, toolType);
		}
		ALL_TILES.add(blockObject);
		return blockObject;
	}

	private static RegistryObject<Block> registerCookieStairs(String name, Supplier<? extends Block> parentBlock, @Nullable ToolType toolType, String... modIds) {
		RegistryObject<Block> blockObject = HELPER.createCompatBlock(name, () -> new StairBlock(parentBlock.get()::defaultBlockState, Properties.COOKIE), CreativeModeTab.TAB_BUILDING_BLOCKS, modIds);
		if (toolType != null) {
			EFFECTIVE_TOOL_MAP.put(blockObject, toolType);
		}
		ALL_TILE_STAIRS.add(blockObject);
		return blockObject;
	}

	private static RegistryObject<Block> registerCookieSlabs(String name, @Nullable ToolType toolType, String... modIds) {
		RegistryObject<Block> blockObject = HELPER.createCompatBlock(name, () -> new SlabBlock(Properties.COOKIE), CreativeModeTab.TAB_BUILDING_BLOCKS, modIds);
		if (toolType != null) {
			EFFECTIVE_TOOL_MAP.put(blockObject, toolType);
		}
		ALL_TILE_SLABS.add(blockObject);
		return blockObject;
	}

	private static RegistryObject<Block> registerCookieWalls(String name, @Nullable ToolType toolType, String... modIds) {
		RegistryObject<Block> blockObject = HELPER.createCompatBlock(name, () -> new WallBlock(Properties.COOKIE), CreativeModeTab.TAB_DECORATIONS, modIds);
		if (toolType != null) {
			EFFECTIVE_TOOL_MAP.put(blockObject, toolType);
		}
		ALL_TILE_WALLS.add(blockObject);
		return blockObject;
	}

	private static RegistryObject<Block> registerCookieVerticalSlab(String name, @Nullable ToolType toolType, String... modIds) {
		RegistryObject<Block> blockObject = HELPER.createCompatBlock(name, () -> new VerticalSlabBlock(Properties.COOKIE), CreativeModeTab.TAB_BUILDING_BLOCKS, modIds);
		if (toolType != null) {
			EFFECTIVE_TOOL_MAP.put(blockObject, toolType);
		}
		ALL_TILE_VERTICAL_SLABS.add(blockObject);
		return blockObject;
	}
}