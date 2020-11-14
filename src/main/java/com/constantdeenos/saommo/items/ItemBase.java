package com.constantdeenos.saommo.items;

import com.constantdeenos.saommo.Main;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(Main.TAB1));
    }
}
//In this class we attach the Items to the Tab we want them to be in