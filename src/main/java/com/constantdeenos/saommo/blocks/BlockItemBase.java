package com.constantdeenos.saommo.blocks;

import com.constantdeenos.saommo.Main;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(Main.TAB2));
    }
}
//In this class we attach the Block Item to the Tab we want it to be in
