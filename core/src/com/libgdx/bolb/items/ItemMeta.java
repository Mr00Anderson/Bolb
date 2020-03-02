package com.libgdx.bolb.items;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Json.Serializable;

public class ItemMeta implements Cloneable, Serializable {

	private String name;
	private List<String> lore;

	ItemMeta() {
		this.name = null;
		this.lore = null;
	}

	ItemMeta(String name) {
		this.name = name;
	}

	ItemMeta(String name, List<String> lore) {
		this.name = name;
		this.lore = new ArrayList<String>(lore);
	}

	ItemMeta(ItemMeta meta) {
		this.name = meta.name;
		if (meta.lore != null)
			this.lore = new ArrayList<String>(meta.lore);
	}

	public boolean hasName() {
		return this.name != null;
	}

	public String getName() {
		return this.name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public boolean hasLore() {
		return this.lore != null;
	}

	public List<String> getLore() {
		return this.lore;
	}

	public void setLore(List<String> lore) {
		if (lore == null) {
			this.lore = null;
		} else if (this.lore == null) {
			this.lore = new ArrayList<String>(lore);
		} else {
			this.lore.clear();
			this.lore = new ArrayList<String>(lore);
		}
	}

	public ItemMeta clone() {
		ItemMeta clone = new ItemMeta();
		clone.name = this.name;
		if (this.lore != null)
			clone.lore = new ArrayList<String>(this.lore);
		return clone;
	}

	@Override
	public void write(Json json) {
		if (name != null)
			json.writeValue("name", name);
		if (lore != null)
			json.writeValue("lore", lore, ArrayList.class, String.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void read(Json json, JsonValue jsonData) {
		if (jsonData.get("name") != null && !jsonData.get("name").isNull())
			this.name = jsonData.getString("name");
		if (jsonData.get("lore") != null && !jsonData.get("lore").isNull())
			this.lore = json.readValue(ArrayList.class, String.class, jsonData.get("lore"));
	}
}