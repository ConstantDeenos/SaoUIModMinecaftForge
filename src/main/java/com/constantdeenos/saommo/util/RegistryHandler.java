package com.constantdeenos.saommo.util;

import com.constantdeenos.saommo.Main;
import com.constantdeenos.saommo.blocks.BlockItemBase;
import com.constantdeenos.saommo.blocks.RubyBlock;
import com.constantdeenos.saommo.items.ItemBase;
import com.constantdeenos.saommo.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    //In order to add another item copy and paste the line above and replace ruby with the name of the item you want. Then copy and paste the json file in assets/saomc/models/item and replace the name of the file and inside the file. Finally add the .png file into assets/saomc/textures/items
    //This takes it's properties from the ItemBase class

    //Tools
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register( "ruby_pickaxe", () -> new PickaxeItem(ModItemTier.RUBY, 2, -2.8F, new Item.Properties().group(Main.TAB4)));
    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register( "ruby_axe", () -> new AxeItem(ModItemTier.RUBY, 2, -2.8F, new Item.Properties().group(Main.TAB4)));
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register( "ruby_shovel", () -> new ShovelItem(ModItemTier.RUBY, 2, -2.8F, new Item.Properties().group(Main.TAB4)));
    public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register( "ruby_hoe", () -> new HoeItem(ModItemTier.RUBY, 2, 2, new Item.Properties().group(Main.TAB4)));

    //Weapons
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register( "ruby_sword", () -> new SwordItem(ModItemTier.RUBY, 4, -2.4F, new Item.Properties().group(Main.TAB3)));

    //Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", RubyBlock::new);
    //This is for the block not the block item
    //Instead of the RubyBlock lamda use the name of the /blocks class
    //This takes it's properties from the RubyBlock class, new one is needed every time

    //Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () -> new BlockItemBase(RUBY_ORE.get()));
    //This takes it's properties from the BlockItemBase class
    //We attach the block item to the block with the new BlockItemBase lamda
}
