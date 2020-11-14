package com.constantdeenos.saommo.rendering.entity;

import com.constantdeenos.saommo.rendering.entity.layers.OverheadCrystalLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class CrystalRenderer extends PlayerRenderer {
    public CrystalRenderer(EntityRendererManager renderManager, boolean useSmallArms) {
        super(renderManager, useSmallArms);
        this.addLayer(new OverheadCrystalLayer<>(this));
    }
}
