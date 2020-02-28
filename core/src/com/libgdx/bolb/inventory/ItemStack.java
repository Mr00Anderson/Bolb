package com.libgdx.bolb.inventory;

import com.libgdx.bolb.items.ItemType;

public class ItemStack {

	private ItemType type;
	private int amount;

	protected ItemStack() {
		this.type = ItemType.NULL;
		this.amount = 0;
	}

	public ItemStack(ItemStack stack) throws IllegalArgumentException {
		this.type = ItemType.NULL;
		this.amount = 0;
		if (stack == null)
			throw new IllegalArgumentException("Cannot copy null stack");
		this.type = stack.getType();
		this.amount = stack.getAmount();

	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMaxStackSize() {
		return this.getType().getMaxStackSize();
	}

}
