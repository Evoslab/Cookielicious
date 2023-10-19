package com.evoslab.cookielicious.core;

import com.evoslab.cookielicious.core.datagen.CItemModelProvider;
import com.evoslab.cookielicious.core.datagen.CLangProvider;
import com.evoslab.cookielicious.core.other.CookieliciousCompat;
import com.evoslab.cookielicious.core.registry.CookieliciousLootConditions;
import com.evoslab.cookielicious.core.datagen.CBlockTagProvider;
import com.evoslab.cookielicious.core.datagen.CRecipeProvider;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Cookielicious.MOD_ID)
public class Cookielicious {
    public static final String MOD_ID = "cookielicious";
    public static ResourceLocation modPrefix(String path) {
        return new ResourceLocation(Cookielicious.MOD_ID, path);
    }
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public Cookielicious() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_HELPER.register(modEventBus);
        CookieliciousLootConditions.LOOT_ITEM_CONDITION_TYPE.register(modEventBus);

        modEventBus.addListener(this::doCommonStuff);
        modEventBus.addListener(this::doClientStuff);
        modEventBus.addListener(this::gatherData);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CookieliciousConfig.COMMON_SPEC);
    }

	private void doCommonStuff(final FMLCommonSetupEvent event) {
        event.enqueueWork(CookieliciousCompat::registerCompat);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    private void gatherData(GatherDataEvent event) {
        boolean client = event.includeClient();
        boolean server = event.includeServer();
        DataGenerator dataGen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        dataGen.addProvider(client, new CLangProvider(dataGen));
        dataGen.addProvider(client, new CItemModelProvider(dataGen, fileHelper));

        dataGen.addProvider(server, new CBlockTagProvider(dataGen, fileHelper));
        dataGen.addProvider(server, new CRecipeProvider(dataGen));
        //TODO add LootTableProvider

    }
}