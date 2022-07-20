package com.evoslab.cookielicious.common.item;

import com.teamabnormals.neapolitan.common.item.HealingItem;

import co.eltrut.differentiate.common.interf.ICompostableItem;

public class HealingCookieItem extends HealingItem implements ICompostableItem {

	public HealingCookieItem(float healAmount, Properties properties) {
		super(healAmount, properties);
	}

	@Override
	public float getCompostableChance() {
		return 0.85F;
	}
	
}
