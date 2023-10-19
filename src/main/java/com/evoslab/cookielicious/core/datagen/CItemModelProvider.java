package com.evoslab.cookielicious.core.datagen;

import com.evoslab.cookielicious.core.Cookielicious;
import com.evoslab.cookielicious.core.registry.CookieliciousItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CItemModelProvider extends ItemModelProvider {

    public CItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Cookielicious.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(CookieliciousItems.PUMPKIN_COOKIE.get());
        basicItem(CookieliciousItems.BEETROOT_COOKIE.get());
    }
}
