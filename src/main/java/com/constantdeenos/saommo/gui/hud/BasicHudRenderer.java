package com.constantdeenos.saommo.gui.hud;

import com.constantdeenos.saommo.Main;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.sun.glass.ui.Screen;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "saocm", value = Dist.CLIENT)
public class BasicHudRenderer {
    Minecraft mc = Minecraft.getInstance();
    public ResourceLocation bars = new ResourceLocation(Main.MOD_ID, "textures/gui/hudassets.png");
    MatrixStack stack = new MatrixStack();

    @SubscribeEvent
    public void renderEmptyHealthOverlay(RenderGameOverlayEvent.Pre event){
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL){
            RenderSystem.enableBlend();
            mc.getTextureManager().bindTexture(bars);
            mc.ingameGUI.blit(stack, 0, 0, 0, 0, 184, 24);
        }
    }

//    @SubscribeEvent
//    public void renderEmptyStaminaOverlay(RenderGameOverlayEvent.Pre event){
//        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL){
//            RenderSystem.enableBlend();
//            mc.getTextureManager().bindTexture(bars);
//            mc.ingameGUI.blit(stack, 0, 18 , 0, 40, 130, 8);
//        }
//    }
//
//    @SubscribeEvent
//    public void renderEmptyManaOverlay(RenderGameOverlayEvent.Pre event){
//        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL){
//            RenderSystem.enableBlend();
//            mc.getTextureManager().bindTexture(bars);
//            mc.ingameGUI.blit(stack, 0, 31 , 0, 60, 130, 8);
//        }
//    }
}

