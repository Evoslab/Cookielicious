package com.evoslab.cookielicious.core.registry;

import com.evoslab.cookielicious.core.Cookielicious;
import com.evoslab.cookielicious.common.item.CookieItem;
import com.evoslab.cookielicious.common.item.HealingCookieItem;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.neapolitan.core.Neapolitan;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Cookielicious.MOD_ID, bus = Bus.MOD)
public class CookieliciousItems {

	public static final ItemSubRegistryHelper HELPER = Cookielicious.REGISTRY_HELPER.getItemSubHelper();

	public static final RegistryObject<Item> VANILLA_COOKIE = HELPER.createItem("vanilla_cookie", () -> new CookieItem(Properties.VANILLA));
    public static final RegistryObject<Item> CHOCOLATE_COOKIE = HELPER.createItem("chocolate_cookie", () -> new CookieItem(Properties.CHOCOLATE));
    public static final RegistryObject<Item> STRAWBERRY_COOKIE = HELPER.createItem("strawberry_cookie", () -> new HealingCookieItem(1F, Properties.STRAWBERRY));
    public static final RegistryObject<Item> BANANA_COOKIE = HELPER.createItem("banana_cookie", () -> new CookieItem(Properties.BANANA));
    public static final RegistryObject<Item> MINT_COOKIE = HELPER.createItem("mint_cookie", () -> new CookieItem(Properties.MINT));
    public static final RegistryObject<Item> ADZUKI_COOKIE = HELPER.createItem("adzuki_cookie", () -> new CookieItem(Properties.ADZUKI));
    
    public static class Properties {
    	
    	public static final Item.Properties STRAWBERRY = new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder()
    			.nutrition(2)
    			.saturationMod(1F)
    			.fast()
    			.build());
    	public static final Item.Properties VANILLA = new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder()
				.nutrition(2)
				.saturationMod(1F)
				.effect(() -> new MobEffectInstance(Effects.VANILLA_SCENT, 120, 0), 1F)
				.fast()
				.build());
		public static final Item.Properties CHOCOLATE = new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder()
				.nutrition(2)
				.saturationMod(1F)
				.effect(() -> new MobEffectInstance(Effects.SUGAR_RUSH, 120, 0), 1F)
				.fast()
				.build());
		public static final Item.Properties BANANA = new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder()
				.nutrition(2)
				.saturationMod(1F)
				.effect(() -> new MobEffectInstance(Effects.AGILITY, 120, 0), 1F)
				.fast()
				.build());
		public static final Item.Properties MINT = new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder()
				.nutrition(2)
				.saturationMod(1F)
				.effect(() -> new MobEffectInstance(Effects.BERSERKING, 120, 0), 1F)
				.fast()
				.build());
		public static final Item.Properties ADZUKI = new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder()
				.nutrition(2)
				.saturationMod(1F)
				.effect(() -> new MobEffectInstance(Effects.HARMONY, 120, 0), 1F)
				.fast()
				.build());
    	public static Item.Properties getCookieProps(MobEffect effect) {
    		return getCookieProps(effect, 2, 1F);
    	}
    	
    	public static Item.Properties getCookieProps(MobEffect effect, int nutrition, float saturation) {
    		return new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder()
					.nutrition(nutrition)
					.saturationMod(saturation)
    				.effect(() -> new MobEffectInstance(effect, 120, 0), 1F)
    				.fast()
    				.build());
    	}
    	
    }
    
    public static class Effects {
    	public static final MobEffect VANILLA_SCENT = getEffect(Neapolitan.MOD_ID, "vanilla_scent");
    	public static final MobEffect SUGAR_RUSH = getEffect(Neapolitan.MOD_ID, "sugar_rush");
    	public static final MobEffect AGILITY = getEffect(Neapolitan.MOD_ID, "agility");
    	public static final MobEffect BERSERKING = getEffect(Neapolitan.MOD_ID, "berserking");
    	public static final MobEffect HARMONY = getEffect(Neapolitan.MOD_ID, "harmony");
    	
    	public static MobEffect getEffect(String modId, String id) {
    		return ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(modId, id));
    	}
    }
}
