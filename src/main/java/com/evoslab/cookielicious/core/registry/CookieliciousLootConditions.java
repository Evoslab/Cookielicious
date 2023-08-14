package com.evoslab.cookielicious.core.registry;

import com.evoslab.cookielicious.core.Cookielicious;
import com.evoslab.cookielicious.core.CookieliciousConfig;
import com.teamabnormals.blueprint.core.util.DataUtil;
import net.minecraft.core.Registry;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CookieliciousLootConditions {

public static final DeferredRegister<LootItemConditionType> LOOT_ITEM_CONDITION_TYPE = DeferredRegister.create(Registry.LOOT_ITEM_REGISTRY, Cookielicious.MOD_ID);

public static final RegistryObject<LootItemConditionType> CONFIG = LOOT_ITEM_CONDITION_TYPE.register("config", () -> DataUtil.registerConfigCondition(Cookielicious.MOD_ID, CookieliciousConfig.COMMON));

}
