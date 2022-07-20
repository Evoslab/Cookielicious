package com.evoslab.cookielicious.common.core.registry;

import co.eltrut.differentiate.common.repo.VariantBlocksRepo;
import co.eltrut.differentiate.core.registrator.BlockHelper;
import co.eltrut.differentiate.core.util.CompatUtil.Mods;
import com.evoslab.cookielicious.common.core.Cookielicious;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Cookielicious.MOD_ID, bus = Bus.MOD)
public class CookieliciousBlocks {
	
	public static final BlockHelper HELPER = Cookielicious.REGISTRATOR.getHelper(ForgeRegistries.BLOCKS);

	public static final Map<VariantBlocksRepo, ToolType> EFFECTIVE_TOOL_MAP = new HashMap<>();

	
	// Cookie Tiles
	public static final VariantBlocksRepo COOKIE_TILES = createSimpleWithVariants("cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final VariantBlocksRepo STRAWBERRY_COOKIE_TILES = createSimpleWithVariants("strawberry_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final VariantBlocksRepo CHOCOLATE_COOKIE_TILES = createSimpleWithVariants("chocolate_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final VariantBlocksRepo VANILLA_COOKIE_TILES = createSimpleWithVariants("vanilla_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final VariantBlocksRepo HONEY_COOKIE_TILES = createSimpleWithVariants("honey_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS, Mods.FARMERS_DELIGHT);
	public static final VariantBlocksRepo SWEET_BERRY_COOKIE_TILES = createSimpleWithVariants("sweet_berry_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS, Mods.FARMERS_DELIGHT);
	public static final VariantBlocksRepo BANANA_COOKIE_TILES = createSimpleWithVariants("banana_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final VariantBlocksRepo MINT_COOKIE_TILES = createSimpleWithVariants("mint_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final VariantBlocksRepo ADZUKI_COOKIE_TILES = createSimpleWithVariants("adzuki_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final VariantBlocksRepo CHERRY_COOKIE_TILES = createSimpleWithVariants("cherry_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS, Mods.ABNORMALS_DELIGHT);
	public static final VariantBlocksRepo MULBERRY_COOKIE_TILES = createSimpleWithVariants("mulberry_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS, Mods.ABNORMALS_DELIGHT);
	public static final VariantBlocksRepo MAPLE_COOKIE_TILES = createSimpleWithVariants("maple_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS, Mods.ABNORMALS_DELIGHT);
	public static final VariantBlocksRepo GOOSEBERRY_JAM_COOKIE_TILES = createSimpleWithVariants("gooseberry_jam_cookie_tiles", Properties.COOKIE, ToolType.HOE, CreativeModeTab.TAB_BUILDING_BLOCKS, Mods.BAYOU_BLUES);

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

	@SuppressWarnings("SameParameterValue")
	private static VariantBlocksRepo createSimpleWithVariants(String regName, BlockBehaviour.Properties properties, @Nullable ToolType toolType, CreativeModeTab creativeTab, String... mods) {
		VariantBlocksRepo blockRepo = HELPER.createSimpleBlockWithVariants(regName, properties, creativeTab, mods);

		if (toolType != null)
			EFFECTIVE_TOOL_MAP.put(blockRepo, toolType);

		return blockRepo;
	}
}
