package com.evoslab.cookielicious.core.datagen.client;

import com.evoslab.cookielicious.core.Cookielicious;
import com.evoslab.cookielicious.core.registry.CookieliciousBlocks;
import com.evoslab.cookielicious.core.registry.CookieliciousItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

import static com.evoslab.cookielicious.core.datagen.CDatagenUtil.*;

public class CItemModelProvider extends ItemModelProvider {

    public CItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Cookielicious.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(CookieliciousItems.VANILLA_COOKIE);
        basicItem(CookieliciousItems.CHOCOLATE_COOKIE);
        basicItem(CookieliciousItems.STRAWBERRY_COOKIE);
        basicItem(CookieliciousItems.BANANA_COOKIE);
        basicItem(CookieliciousItems.MINT_COOKIE);
        basicItem(CookieliciousItems.ADZUKI_COOKIE);
        basicItem(CookieliciousItems.BEETROOT_COOKIE);
        basicItem(CookieliciousItems.PUMPKIN_COOKIE);
    }

    private void basicItem(Supplier<? extends Item> item) {
        basicItem(item.get());
    }


}
