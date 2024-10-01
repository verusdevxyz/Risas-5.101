/*
 Copyright Alan Wood 2021
 None of this code to be reused without my written permission
 Intellectual Rights owned by Alan Wood
 */
package dev.risas.module.impl.player;

import dev.risas.event.impl.motion.PreMotionEvent;
import dev.risas.module.Module;
import dev.risas.module.api.ModuleInfo;
import dev.risas.module.enums.Category;
import dev.risas.setting.impl.ModeSetting;
import dev.risas.setting.impl.NumberSetting;
import dev.risas.util.player.PacketUtil;
import net.minecraft.network.play.client.C03PacketPlayer;

@ModuleInfo(name = "FastEat", description = "Eat like Dream, who lives at 2710 Engli-.", category = Category.PLAYER)
public final class FastEat extends Module {

    private final ModeSetting mode = new ModeSetting("Mode", this, "Normal", "Normal", "Ghostly");
    private final NumberSetting speed = new NumberSetting("Speed", this, 20, 1, 100, 1);

    @Override
    public void onUpdateAlwaysInGui() {
        speed.hidden = mode.is("Hypixel");
    }

    @Override
    public void onPreMotion(final PreMotionEvent event) {
        if (mc.thePlayer.isEating() && !this.getModule(Scaffold.class).isEnabled()) {
            for (int i = 0; i < (int) (speed.getValue() / 2); i++) {
                switch (mode.getMode()) {
                    case "Normal":
                        PacketUtil.sendPacket(new C03PacketPlayer(mc.thePlayer.onGround));
                        PacketUtil.sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ, mc.thePlayer.onGround));
                        break;

                    case "Ghostly":
                        PacketUtil.sendPacket(new C03PacketPlayer.C06PacketPlayerPosLook(mc.thePlayer.posX, mc.thePlayer.posY + 1E-9, mc.thePlayer.posZ, mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch, false));
                        break;
                }
            }
        }
    }
}
