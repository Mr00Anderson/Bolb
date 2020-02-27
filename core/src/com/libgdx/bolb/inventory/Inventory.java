package com.libgdx.bolb.inventory;

import com.badlogic.gdx.utils.Array;
import com.libgdx.bolb.items.Item;

import java.util.Comparator;

public class Inventory extends Array<ItemSlot> {

    //TODO make all items/weapons/etc.. implement 'Item'




    @Override
    public void sort() {
        //thx rafa
        super.sort(new Comparator<ItemSlot>() {
            @Override
            public int compare(ItemSlot slot1, ItemSlot slot2) {
                if (slot1.isEmpty())
                    return -1; // First slot is empty, so we return -1 because it goes AFTER the second one
                if (slot2.isEmpty())
                    return 1; // Second slot is empty, so we return 1 because the first one goes BEFORE.

                Item item1 = slot1.getItem();
                Item item2 = slot2.getItem();

                // Sort by rarity
                int rarity1 = item1.getRarity().getLevel();
                int rarity2 = item2.getRarity().getLevel();
                int rarityComparison = Integer.compare(rarity2, rarity1);
                if (rarityComparison != 0) { // Why != 0? Because if it's 0 they share the same rarity. In that case we keep sorting...
                    return rarityComparison;
                }

                // Sort by quantity
                int quantity1 = slot1.getAmount();
                int quantity2 = slot2.getAmount();
                int quantityComparison = Integer.compare(quantity2, quantity1);
                return quantityComparison;
            }
        });
    }
}
