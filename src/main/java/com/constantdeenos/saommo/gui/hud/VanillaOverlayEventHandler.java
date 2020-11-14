package com.constantdeenos.saommo.gui.hud;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class VanillaOverlayEventHandler {
    @SubscribeEvent
    //Post means that this renders after the normal HUD
    public void onGameOverlayRender(RenderGameOverlayEvent.Pre event){
        if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTH){
            event.setCanceled(true);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.FOOD){
            event.setCanceled(true);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.ARMOR){
            event.setCanceled(true);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR){
            event.setCanceled(true);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE){
            event.setCanceled(true);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTHMOUNT){
            event.setCanceled(true);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.JUMPBAR){
            event.setCanceled(true);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            event.setCanceled(true);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.AIR){
            event.setCanceled(true);
        }
    }
}
