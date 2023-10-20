package com.evoslab.cookielicious.core;

import com.evoslab.cookielicious.core.datagen.client.CBlockStateProvider;
import com.evoslab.cookielicious.core.datagen.client.CItemModelProvider;
import com.evoslab.cookielicious.core.datagen.client.CLangProvider;
import com.evoslab.cookielicious.core.datagen.server.CItemTagsProvider;
import com.evoslab.cookielicious.core.datagen.server.CLootTableProvider;
import com.evoslab.cookielicious.core.other.CookieliciousCompat;
import com.evoslab.cookielicious.core.registry.CookieliciousLootConditions;
import com.evoslab.cookielicious.core.datagen.server.CBlockTagsProvider;
import com.evoslab.cookielicious.core.datagen.server.CRecipeProvider;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Cookielicious.MOD_ID)
@Mod.EventBusSubscriber(modid = Cookielicious.MOD_ID)
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

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        boolean client = event.includeClient();
        boolean server = event.includeServer();
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(client, new CBlockStateProvider(generator, fileHelper));
        generator.addProvider(client, new CItemModelProvider(generator, fileHelper));
        generator.addProvider(client, new CLangProvider(generator));

        CBlockTagsProvider blockTagProvider = new CBlockTagsProvider(generator, fileHelper);
        generator.addProvider(server, blockTagProvider);
        generator.addProvider(server, new CItemTagsProvider(generator, blockTagProvider, fileHelper));
        generator.addProvider(server, new CRecipeProvider(generator));
        generator.addProvider(server, new CLootTableProvider(generator));

    }
}