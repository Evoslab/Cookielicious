package com.evoslab.cookielicious.common.core;

import co.eltrut.differentiate.core.registrator.Registrator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("cookielicious")
public class Cookielicious {

    public static final String MOD_ID = "cookielicious";
    public static final Registrator REGISTRATOR = new Registrator(MOD_ID);
    public static Cookielicious instance;

    public Cookielicious() {
        instance = this;

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CookieliciousConfig.COMMON_SPEC);

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRATOR.register(modEventBus);

        modEventBus.addListener(this::doCommonStuff);
        modEventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

	private void doCommonStuff(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
}