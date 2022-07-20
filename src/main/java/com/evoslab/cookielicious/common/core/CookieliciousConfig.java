package com.evoslab.cookielicious.common.core;

import org.apache.commons.lang3.tuple.Pair;

import co.eltrut.differentiate.core.condition.BooleanRecipeCondition;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class CookieliciousConfig {

	public static class Common {
		// Cookies
		public final ConfigValue<Boolean> enableVanillaCookies;
		public final ConfigValue<Boolean> enableStrawberryCookies;
		public final ConfigValue<Boolean> enableChocolateCookies;
		public final ConfigValue<Boolean> enableMintCookies;
		public final ConfigValue<Boolean> enableBananaCookies;
		public final ConfigValue<Boolean> enableAdzukiCookies;
		
		// Cookie tiles
		public final ConfigValue<Boolean> enableVanillaCookieTiles;
		public final ConfigValue<Boolean> enableStrawberryCookieTiles;
		public final ConfigValue<Boolean> enableChocolateCookieTiles;
		public final ConfigValue<Boolean> enableHoneyCookieTiles;
		public final ConfigValue<Boolean> enableSweetBerryCookieTiles;
		public final ConfigValue<Boolean> enableMintCookieTiles;
		public final ConfigValue<Boolean> enableBananaCookieTiles;
		public final ConfigValue<Boolean> enableAdzukiCookieTiles;
		public final ConfigValue<Boolean> enableCookieTiles;
		
		Common(ForgeConfigSpec.Builder builder) {
			builder.push("common");
			
			// Cookies
			enableVanillaCookies = builder.define("Whether vanilla cookies are enabled", true);
			enableStrawberryCookies = builder.define("Whether strawberry cookies are enabled", true);
			enableChocolateCookies = builder.define("Whether chocolate cookies are enabled", true);
			enableMintCookies = builder.define("Whether mint cookies are enabled", true);
			enableBananaCookies = builder.define("Whether banana cookies are enabled", true);
			enableAdzukiCookies = builder.define("Whether adzuki cookies are enabled", true);
			
			// Cookie tiles
			enableVanillaCookieTiles = builder.define("Whether vanilla cookie tiles are enabled", true);
			enableStrawberryCookieTiles = builder.define("Whether strawberry cookie tiles are enabled", true);
			enableChocolateCookieTiles = builder.define("Whether chocolate cookie tiles are enabled", true);
			enableHoneyCookieTiles = builder.define("Whether honey cookie tiles are enabled", true);
			enableSweetBerryCookieTiles = builder.define("Whether sweet berry cookie tiles are enabled", true);
			enableMintCookieTiles = builder.define("Whether mint cookie tiles are enabled", true);
			enableBananaCookieTiles = builder.define("Whether banana cookie tiles are enabled", true);
			enableAdzukiCookieTiles = builder.define("Whether adzuki cookie tiles are enabled", true);
			enableCookieTiles = builder.define("Whether cookie tiles are enabled", true);
			
			builder.pop();
			
			// Cookies
			BooleanRecipeCondition.MAP.put("vanilla_cookie", enableVanillaCookies);
			BooleanRecipeCondition.MAP.put("strawberry_cookie", enableStrawberryCookies);
			BooleanRecipeCondition.MAP.put("chocolate_cookie", enableChocolateCookies);
			BooleanRecipeCondition.MAP.put("mint_cookie", enableMintCookies);
			BooleanRecipeCondition.MAP.put("banana_cookie", enableBananaCookies);
			BooleanRecipeCondition.MAP.put("adzuki_cookie", enableAdzukiCookies);
			
			// Cookie tiles
			BooleanRecipeCondition.MAP.put("vanilla_cookie_tiles", enableVanillaCookieTiles);
			BooleanRecipeCondition.MAP.put("strawberry_cookie_tiles", enableStrawberryCookieTiles);
			BooleanRecipeCondition.MAP.put("chocolate_cookie_tiles", enableChocolateCookieTiles);
			BooleanRecipeCondition.MAP.put("honey_cookie_tiles", enableHoneyCookieTiles);
			BooleanRecipeCondition.MAP.put("sweet_berry_cookie_tiles", enableSweetBerryCookieTiles);
			BooleanRecipeCondition.MAP.put("mint_cookie_tiles", enableMintCookieTiles);
			BooleanRecipeCondition.MAP.put("banana_cookie_tiles", enableBananaCookieTiles);
			BooleanRecipeCondition.MAP.put("adzuki_cookie_tiles", enableAdzukiCookieTiles);
			BooleanRecipeCondition.MAP.put("cookie_tiles", enableCookieTiles);
		}
		
	}
	
	public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;
	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = specPair.getRight();
		COMMON = specPair.getLeft();
	}
	
}
