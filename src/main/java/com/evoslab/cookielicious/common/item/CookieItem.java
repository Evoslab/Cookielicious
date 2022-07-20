package com.evoslab.cookielicious.common.item;

import co.eltrut.differentiate.common.interf.ICompostableItem;
import net.minecraft.world.item.Item;

public class CookieItem extends Item implements ICompostableItem {

	public CookieItem(Properties properties) {
		super(properties);
	}

	@Override
	public float getCompostableChance() {
		return 0.85F;
	}

}
