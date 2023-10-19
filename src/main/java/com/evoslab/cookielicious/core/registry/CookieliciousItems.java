package com.evoslab.cookielicious.core.registry;

import com.evoslab.cookielicious.core.Cookielicious;
import com.evoslab.cookielicious.common.item.CookieItem;
import com.evoslab.cookielicious.common.item.HealingCookieItem;
import com.evoslab.cookielicious.core.other.CookieliciousCompat;
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
    public static final RegistryObject<Item> BEETROOT_COOKIE = HELPER.createItem("beetroot_cookie", () -> new CookieItem(Properties.BEETROOT));
    public static final RegistryObject<Item> PUMPKIN_COOKIE = HELPER.createItem("pumpkin_cookie", () -> new CookieItem(Properties.PUMPKIN));

    public static class Properties {
    	public static final Item.Properties STRAWBERRY = getCookieProps();
    	public static final Item.Properties VANILLA = getCookieProps(Effects.VANILLA_SCENT);
		public static final Item.Properties CHOCOLATE = getCookieProps(Effects.SUGAR_RUSH);
		public static final Item.Properties BANANA = getCookieProps(Effects.AGILITY);
		public static final Item.Properties MINT = getCookieProps(Effects.BERSERKING);
		public static final Item.Properties ADZUKI = getCookieProps(Effects.HARMONY);
		public static final Item.Properties BEETROOT = getCookieProps(Effects.ROOTED);
		public static final Item.Properties PUMPKIN = getCookieProps(Effects.STUFFED);

    	public static Item.Properties getCookieProps(MobEffect effect) {
    		return getCookieProps().food(new FoodProperties.Builder().effect(() -> new MobEffectInstance(effect, 120, 0), 1F).build());
    	}
    	
    	public static Item.Properties getCookieProps() {
    		return new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder()
					.nutrition(2)
					.saturationMod(1F)
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
    	public static final MobEffect ROOTED = getEffect(CookieliciousCompat.SEASONALS, "rooted");
    	public static final MobEffect STUFFED = getEffect(CookieliciousCompat.SEASONALS, "stuffed");

    	public static MobEffect getEffect(String modId, String id) {
    		return ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(modId, id));
    	}
    }
}
