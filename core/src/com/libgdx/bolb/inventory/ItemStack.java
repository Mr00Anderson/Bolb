package com.libgdx.bolb.inventory;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.libgdx.bolb.items.ItemMeta;
import com.libgdx.bolb.items.ItemType;
import com.libgdx.bolb.items.Rarity;

public class ItemStack implements Cloneable, Serializable {

	private ItemType type;
	private int amount;
	private Rarity rarity;
	private ItemMeta meta;
	
	protected ItemStack() {
		this.type = ItemType.EMPTY_SLOT;
		this.amount = 0;
	}

	public ItemStack(ItemStack stack) throws IllegalArgumentException {
		if (stack == null)
			throw new IllegalArgumentException("Cannot copy null stack");
		this.setType(stack.getType());
		this.setAmount(stack.getAmount());
		this.setRarity(stack.getRarity());
	}

	public ItemStack(ItemType type, int amount) throws IllegalArgumentException {
		this(type, amount, Rarity.COMMON, null);
	}

	public ItemStack(ItemType type, int amount, Rarity rarity) throws IllegalArgumentException {
		this(type, amount, rarity, null);
	}

	public ItemStack(ItemType type, int amount, Rarity rarity, ItemMeta meta) throws IllegalArgumentException {
		this.setType(type);
		this.setAmount(amount);
		this.setRarity(rarity);
		this.setMeta(meta);
	}
	
	public ItemType getType() {
		return type;
	}

	public ItemStack setType(ItemType type) {
		this.type = type;
		return this;
	}

	public int getAmount() {
		return amount;
	}

	public ItemStack setAmount(int amount) {
		this.amount = amount;
		return this;
	}

	public int getMaxStackSize() {
		return this.getType().getMaxStackSize();
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public boolean hasMeta() {
		return this.meta != null;
	}

	public ItemMeta getMeta() {
		return this.meta.clone();
	}

	public void setMeta(ItemMeta itemMeta) {
		if (itemMeta == null) {
			this.meta = null;
		} else {
			if (this.meta == itemMeta)
				this.meta = itemMeta.clone();
			else
				this.meta = itemMeta;
		}
	}

	public ItemStack clone() {
		ItemStack clone = new ItemStack();
		clone.type = this.type;
		clone.amount = this.amount;
		if (this.meta != null)
			clone.meta = this.meta;
		return clone;
	}

	@Override
	public void write(Json json) {
		json.writeValue("type", type);
		json.writeValue("amount", amount);
		if (meta != null)
			json.writeValue("meta", meta, ItemMeta.class);
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		this.type = json.readValue(ItemType.class, jsonData.get("type"));
		this.amount = jsonData.getInt("amount");
		if (jsonData.get("meta") != null && !jsonData.get("meta").isNull())
			this.meta = json.readValue(ItemMeta.class, jsonData.get("meta"));
	}
}