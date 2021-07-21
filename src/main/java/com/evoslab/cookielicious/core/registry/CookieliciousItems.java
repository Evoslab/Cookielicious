package com.evoslab.cookielicious.core.registry;

import com.evoslab.cookielicious.common.item.CookieItem;
import com.evoslab.cookielicious.common.item.HealingCookieItem;
import com.evoslab.cookielicious.core.Cookielicious;

import co.eltrut.differentiate.core.registrator.ItemHelper;
import co.eltrut.differentiate.core.util.CompatUtil.Mods;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Cookielicious.MOD_ID, bus = Bus.MOD)
public class CookieliciousItems {
	
	public static final ItemHelper HELPER = Cookielicious.REGISTRATOR.getHelper(ForgeRegistries.ITEMS);
	
    public static final RegistryObject<Item> VANILLA_COOKIE = HELPER.createItem("vanilla_cookie", () -> new CookieItem(Properties.VANILLA));
    public static final RegistryObject<Item> CHOCOLATE_COOKIE = HELPER.createItem("chocolate_cookie", () -> new CookieItem(Properties.CHOCOLATE));
    public static final RegistryObject<Item> STRAWBERRY_COOKIE = HELPER.createItem("strawberry_cookie", () -> new HealingCookieItem(1F, Properties.STRAWBERRY));
    public static final RegistryObject<Item> BANANA_COOKIE = HELPER.createItem("banana_cookie", () -> new CookieItem(Properties.BANANA));
    public static final RegistryObject<Item> MINT_COOKIE = HELPER.createItem("mint_cookie", () -> new CookieItem(Properties.MINT));
    public static final RegistryObject<Item> ADZUKI_COOKIE = HELPER.createItem("adzuki_cookie", () -> new CookieItem(Properties.ADZUKI));
    
    public static class Properties {
    	
    	//public static final Item.Properties VANILLA = getCookieProps(Effects.VANILLA_SCENT);
    	//public static final Item.Properties CHOCOLATE = getCookieProps(Effects.SUGAR_RUSH);
    	public static final Item.Properties STRAWBERRY = new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder()
    			.hunger(2)
    			.saturation(1F)
    			.fastToEat()
    			.build());
    	/*public static final Item.Properties BANANA = getCookieProps(Effects.AGILITY);
    	public static final Item.Properties MINT = getCookieProps(Effects.BERSERKING);
    	public static final Item.Properties ADZUKI = getCookieProps(Effects.HARMONY);*/
    	public static final Item.Properties VANILLA = new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder()
				.hunger(2)
				.saturation(1F)
				.effect(() -> new EffectInstance(Effects.VANILLA_SCENT, 120, 0), 1F)
				.fastToEat()
				.build());
		public static final Item.Properties CHOCOLATE = new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder()
				.hunger(2)
				.saturation(1F)
				.effect(() -> new EffectInstance(Effects.SUGAR_RUSH, 120, 0), 1F)
				.fastToEat()
				.build());
		public static final Item.Properties BANANA = new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder()
				.hunger(2)
				.saturation(1F)
				.effect(() -> new EffectInstance(Effects.AGILITY, 120, 0), 1F)
				.fastToEat()
				.build());
		public static final Item.Properties MINT = new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder()
				.hunger(2)
				.saturation(1F)
				.effect(() -> new EffectInstance(Effects.AGILITY, 120, 0), 1F)
				.fastToEat()
				.build());
		public static final Item.Properties ADZUKI = new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder()
				.hunger(2)
				.saturation(1F)
				.effect(() -> new EffectInstance(Effects.HARMONY, 120, 0), 1F)
				.fastToEat()
				.build());
    	public static Item.Properties getCookieProps(Effect effect) {
    		return getCookieProps(effect, 2, 1F);
    	}
    	
    	public static Item.Properties getCookieProps(Effect effect, int nutrition, float saturation) {
    		return new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder()
    				.hunger(nutrition)
    				.saturation(saturation)
    				.effect(() -> new EffectInstance(effect, 120, 0), 1F)
    				.fastToEat()
    				.build());
    	}
    	
    }
    
    public static class Effects {
    	
    	public static final Effect VANILLA_SCENT = getEffect("vanilla_scent");
    	public static final Effect SUGAR_RUSH = getEffect("sugar_rush");
    	public static final Effect AGILITY = getEffect("agility");
    	public static final Effect BERSERKING = getEffect("berserking");
    	public static final Effect HARMONY = getEffect("harmony");
    	
    	public static Effect getEffect(String id) {
    		return ForgeRegistries.POTIONS.getValue(new ResourceLocation(Mods.NEAPOLITAN, id));
    	}
    }
    
}
