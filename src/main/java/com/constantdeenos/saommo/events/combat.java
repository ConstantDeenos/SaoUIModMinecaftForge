package com.constantdeenos.saommo.events;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;

public class combat {
    PlayerEntity player = Minecraft.getInstance().player;


    public void mana(){
        float currentMana = (float) this.player.getXPSeed();
        System.out.println(currentMana);
    }

}
