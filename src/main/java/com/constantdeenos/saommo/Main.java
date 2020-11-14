package com.constantdeenos.saommo;

import com.constantdeenos.saommo.events.ModClientEvents;
import com.constantdeenos.saommo.gui.hud.BasicHudRenderer;
import com.constantdeenos.saommo.gui.hud.ComplexHudRenderer;
import com.constantdeenos.saommo.gui.hud.VanillaOverlayEventHandler;
import com.constantdeenos.saommo.keybinds.KeybindRegistry;
import com.constantdeenos.saommo.keybinds.Keybinds;
import com.constantdeenos.saommo.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("saocm")
public class Main {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "saocm";

    //Thing about the HUD
    public static Main instance;

    public Main() {
        //Thing about the HUD
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event) {
        Keybinds.register();
        MinecraftForge.EVENT_BUS.register(new ModClientEvents());
        MinecraftForge.EVENT_BUS.register(new VanillaOverlayEventHandler());
        MinecraftForge.EVENT_BUS.register(new BasicHudRenderer());
        MinecraftForge.EVENT_BUS.register(new ComplexHudRenderer());
        MinecraftForge.EVENT_BUS.register(new KeybindRegistry());

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public static final ItemGroup TAB1 = new ItemGroup("craftingMaterials") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUBY.get());
        }
    };

    public static final ItemGroup TAB2 = new ItemGroup("customBlocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUBY_BLOCK.get());
        }
    };
    public static final ItemGroup TAB3 = new ItemGroup("customWeapons") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUBY_SWORD.get());
        }
    };
    public static final ItemGroup TAB4 = new ItemGroup("customTools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUBY_PICKAXE.get());
        }
    };
}