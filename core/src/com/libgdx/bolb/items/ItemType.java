package com.libgdx.bolb.items;

public enum ItemType {

	EMPTY_SLOT(-1),

	BROADSWORD, 
	DAGGER, 
	SHORTSWORD,

	BOW, 
	GUN;

	private final int maxStack;

	private ItemType() {
		this(99);
	}

	private ItemType(int stack) {
		this.maxStack = stack;
	}

	public boolean isMelee() {
		switch (this) {
		case BROADSWORD:
			return true;
		case DAGGER:
			return true;
		case SHORTSWORD:
			return true;
		default:
			return false;
		}
	}

	public boolean isRanged() {
		switch (this) {
		case BOW:
			return true;
		case GUN:
			return true;
		default:
			return false;
		}
	}

	public boolean isArmor() {
		switch (this) {
		// TODO add armor
		default:
			return false;
		}
	}

	public int getMaxStackSize() {
		return this.maxStack;

	}
}
