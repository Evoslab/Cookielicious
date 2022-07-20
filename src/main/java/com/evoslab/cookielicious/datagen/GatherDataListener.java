package com.evoslab.cookielicious.datagen;

import com.evoslab.cookielicious.common.core.Cookielicious;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Cookielicious.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GatherDataListener {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator dataGen = event.getGenerator();

        if (event.includeClient()) {

        }
        if (event.includeServer()) {
            dataGen.addProvider(new CBlockTagProvider(dataGen, event.getExistingFileHelper()));
        }
    }
}
