package com.constantdeenos.saommo.keybinds;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds {
    public static KeyBinding v;
    public static KeyBinding c;
    public static KeyBinding x;
    public static KeyBinding f;

    public static void register(){
        c = new KeyBinding("actionbutton1",67 , "saomod");
        x = new KeyBinding("actionbutton2", 88, "saomod");
        f = new KeyBinding("actionbutton3", 70, "saomod");
        v = new KeyBinding("actionbutton4", 86, "saomod");

        ClientRegistry.registerKeyBinding(c);
        ClientRegistry.registerKeyBinding(x);
        ClientRegistry.registerKeyBinding(f);
        ClientRegistry.registerKeyBinding(v);
    }
}
