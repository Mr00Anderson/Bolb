package com.libgdx.bolb.inventory;

import com.libgdx.bolb.items.Item;

public class ItemSlot {
	
	int amount;
	Item item;
	
	public int getAmount() {
		return amount;
	}
	
	public Item getItem() {
		return item;
	}
	
	public boolean isEmpty() {
		return item == null;
	}
}
