package com.libgdx.bolb.Items;

public enum Item {

	BROADSWORD,
	DAGGER,
	SHORTSWORD,
	
	BOW,
	GUN;
	
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
		//TODO add armor
		default:
			return false;
		}
	}
}