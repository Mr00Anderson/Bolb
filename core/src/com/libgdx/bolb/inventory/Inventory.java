package com.libgdx.bolb.inventory;

import java.util.LinkedHashMap;

public class Inventory extends LinkedHashMap<Integer, ItemSlot> {

	private static final long serialVersionUID = -4882451612453340302L;
	
	//TODO add methods for sorting items by rarity
	//TODO give rarity a value that determines how rare it is compared to another
	//TODO make all items/weapons/etc.. implement 'Item'
}
