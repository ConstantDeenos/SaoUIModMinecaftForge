package com.constantdeenos.saommo.rendering.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.ElytraModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OverheadCrystalLayer<T extends LivingEntity, M extends EntityModel<T> & IHasHead> extends LayerRenderer<T, M> {
    private static String crystalTextureLocation;
    private static final ResourceLocation TEXTURE_CRYSTAL = new ResourceLocation(crystalTextureLocation);
    private final ElytraModel<T> modelCrystal = new ElytraModel<>();

    public OverheadCrystalLayer(IEntityRenderer<T, M> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemstack = entitylivingbaseIn.getItemStackFromSlot(EquipmentSlotType.HEAD);
        int aggressionLevel = 1;
        if (shouldRender(itemstack,entitylivingbaseIn)){
            ResourceLocation resourceLocation;
            if (aggressionLevel == 0){
                crystalTextureLocation = "textures/entity/greenoverheadcrystal.png";
            } else if (aggressionLevel == 1) {
                crystalTextureLocation = "textures/entity/orangeoverheadcrystal.png";
            } else if (aggressionLevel == 2) {
                crystalTextureLocation = "textures/entity/redoverheadcrystal.png";
            } else {
                crystalTextureLocation = "textures/general/error.png";
            }

            matrixStackIn.push();
            matrixStackIn.translate(0.0D, 0.0D, 0.1250D);
            this.getEntityModel().copyModelAttributesTo(this.modelCrystal);
            this.modelCrystal.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            IVertexBuilder ivertexbuilder = ItemRenderer.func_239386_a_(bufferIn, RenderType.func_239263_a_(TEXTURE_CRYSTAL), false, itemstack.hasEffect());
            this.modelCrystal.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
    }
    public boolean shouldRender(ItemStack stack, T entity){return stack.getItem() == Items.DIAMOND_HELMET;}

    public ResourceLocation getCrystalTexture(ItemStack stack, T entity) {return TEXTURE_CRYSTAL;}
}
