package com.constantdeenos.saommo.gui.hud;

import com.constantdeenos.saommo.Main;
import com.constantdeenos.saommo.keybinds.Keybinds;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.client.gui.SpectatorGui;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;


@Mod.EventBusSubscriber(modid = "saocm", value = Dist.CLIENT)
public class ComplexHudRenderer {
    Minecraft mc = Minecraft.getInstance();
    public ResourceLocation hud = new ResourceLocation(Main.MOD_ID, "textures/gui/hudassets.png");
    MatrixStack stack = new MatrixStack();
    PlayerEntity player = Minecraft.getInstance().player;

    protected SpectatorGui spectatorGui;
    ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
    private int animationsToGo;
    private Item item;
    private int count;
    protected  ItemStack itemStack;
   //LivingEntity entityIn = this.getRenderViewPlayer();

    private static String text = "Test Text";
    private static int color = 0xFFFFFF;
    private FontRenderer fontRenderer;

    float maxMana = 100;
    int currentMana = 0;

    public static final ItemStack EMPTY = new ItemStack((Item)null);

    int width = this.mc.getMainWindow().getScaledWidth();
    int height = this.mc.getMainWindow().getScaledHeight();



    public ComplexHudRenderer() {
    }

//    @SubscribeEvent
//    public void onKeyInput(InputEvent.KeyInputEvent event) {
//        if (Keybinds.v.isPressed()) {
//            if (currentMana + 10 >= maxMana) {
//                currentMana = 100;
//            } else if (currentMana + 10 < maxMana) {
//                currentMana = currentMana + 10;
//            }
//        }
//        if (Keybinds.c.isPressed()) {
//            if (currentMana - 10 <= 0) {
//                currentMana = 0;
//            } else if (currentMana - 10 > 0) {
//                currentMana = currentMana - 10;
//            }
//        }
//    }

    @SubscribeEvent
    public void renderHealthOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            PlayerEntity player = Minecraft.getInstance().player;

            float currentHealth = (float) player.getHealth();
            float maxHealth = 20;

            float percentageHealth = currentHealth / maxHealth;
            int hpBarWidth = (int) ((percentageHealth * 1160) * 256 / 2560);

            RenderSystem.enableBlend();
            mc.getTextureManager().bindTexture(hud);

            mc.ingameGUI.blit(stack, 57, 5, 0, 28, hpBarWidth, 8);
            //mc.player.sendChatMessage(String.valueOf(width) + String.valueOf(height));
        }
    }

    @SubscribeEvent
    public void renderHealthText(RenderGameOverlayEvent.Post event) {
        PlayerEntity player = Minecraft.getInstance().player;

        int currentHealth = (int) player.getHealth();
        int maxHealth = 20;

        AbstractGui.drawCenteredString(stack, mc.fontRenderer, currentHealth + " / " + maxHealth + " HP", 190, 12, 16777215);
        //mc.fontRenderer.drawStringWithShadow(stack, "jeff", 150, 150, 16777215);
    }

    @SubscribeEvent
    public void renderStaminaOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            PlayerEntity player = Minecraft.getInstance().player;

            float currentStamina = player.getFoodStats().getFoodLevel();
            float maxStamina = 20;

            float percentageStamina = currentStamina / maxStamina;
            int staminaBarWidth = (int) ((percentageStamina * 1300) * 256 / 2560);

            RenderSystem.enableBlend();
            mc.getTextureManager().bindTexture(hud);

            mc.ingameGUI.blit(stack, 0, 18, 0, 50, staminaBarWidth, 8);
        }
    }
//    @SubscribeEvent
//    public void playerEvent(TickEvent.PlayerTickEvent event){
//        PlayerEntity player = Minecraft.getInstance().player;
//        if(event.phase == TickEvent.Phase.END){
//            float xp = player.experience;
//            mc.player.sendChatMessage(String.valueOf(xp));
//        }
//    }

    @SubscribeEvent
    public void renderManaOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            PlayerEntity player = Minecraft.getInstance().player;

            float percentageMana = currentMana / maxMana;
            int manaBarWidth = (int) ((percentageMana * 1300) * 256 / 2560);

            RenderSystem.enableBlend();
            mc.getTextureManager().bindTexture(hud);

            mc.ingameGUI.blit(stack, 0, 31, 0, 70, manaBarWidth, 8);
        }
    }

    private PlayerEntity getRenderViewPlayer() {
        return !(this.mc.getRenderViewEntity() instanceof PlayerEntity) ? null : (PlayerEntity)this.mc.getRenderViewEntity();
    }


    public boolean isEmpty() {
        if (this.getItemRaw() != null && this.getItemRaw() != Items.AIR) {
            return this.count <= 0;
        } else {
            return true;
        }
    }

    @Nullable
    private Item getItemRaw() {
        return this.item;
    }

    public void setAnimationsToGo(int animations) {
        this.animationsToGo = animations;
    }

    private void renderHotbarItem(int x, int y, float partialTicks, PlayerEntity player, ItemStack stack) {
        if (!stack.isEmpty()) {
            float f = (float)stack.getAnimationsToGo() - partialTicks;
            if (f > 0.0F) {
                RenderSystem.pushMatrix();
                float f1 = 1.0F + f / 5.0F;
                RenderSystem.translatef((float)(x + 8), (float)(y + 12), 0.0F);
                RenderSystem.scalef(1.0F / f1, (f1 + 1.0F) / 2.0F, 1.0F);
                RenderSystem.translatef((float)(-(x + 8)), (float)(-(y + 12)), 0.0F);
            }

            this.itemRenderer.renderItemAndEffectIntoGUI(player, stack, x, y);
            if (f > 0.0F) {
                RenderSystem.popMatrix();
            }

            this.itemRenderer.renderItemOverlays(this.mc.fontRenderer, stack, x, y);
        }
    }

    @SubscribeEvent
    public void renderHotbar(RenderGameOverlayEvent.Post event) {
        PlayerEntity playerEntity = this.getRenderViewPlayer();

        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            if (playerEntity != null){
                float partialTicks = event.getPartialTicks();

                mc.getTextureManager().bindTexture(hud);
                ItemStack itemStack = playerEntity.getHeldItemOffhand();
                HandSide handSide = playerEntity.getPrimaryHand().opposite();
                int x = width / 2;
                int y = (height / 2) - 60;
                int j = mc.ingameGUI.getBlitOffset();
                //mc.ingameGUI.setBlitOffset(-90);
                mc.ingameGUI.blit(stack, 0, y, 230, 40, 21, 189);
                mc.ingameGUI.blit(stack, 0, y + playerEntity.inventory.currentItem * 21, 200, 40, 21, 21);
                if (!itemStack.isEmpty()) {
                    if (handSide == HandSide.LEFT) {
                        mc.ingameGUI.blit(stack, x - 91 - 29, y - 23, 24, 22, 29, 24);
                    } else {
                        mc.ingameGUI.blit(stack, x + 91, y - 23, 53, 22, 29, 24);
                    }
                }

                mc.ingameGUI.setBlitOffset(j);
                RenderSystem.enableRescaleNormal();
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();

                for (int i1 = 0; i1 < 9; ++i1) {
                    int x1 = 2;
                    int y1 = y + i1 * 21 + 2;
                    this.renderHotbarItem(x1, y1, partialTicks, playerEntity, playerEntity.inventory.mainInventory.get(i1));
                }

                if (!itemStack.isEmpty()) {
                    int i2 = y - 16 - 3;
                    if (handSide == HandSide.LEFT) {
                        //this.renderHotbarItem(x - 91 - 26, i2, partialTicks, playerEntity, itemStack);
                    } else {
                        //this.renderHotbarItem(x + 91 + 10, i2, partialTicks, playerEntity, itemStack);
                    }
                }
                RenderSystem.disableRescaleNormal();
                RenderSystem.disableBlend();
            }
        }
    }



}