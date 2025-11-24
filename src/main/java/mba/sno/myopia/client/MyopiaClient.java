package mba.sno.myopia.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyopiaClient implements ClientModInitializer {
    public static final String MOD_ID = "Myopia";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final String KEY_CATEGORY_MYOPIA = "key.category.myopia";
    private static final String KEY_TOGGLE_MYOPIA = "key.myopia.toggle";
    public static boolean enableBlur = true;

    @Override
    public void onInitializeClient() {
        LOGGER.info("Making Minecraft look Bad™ since 2024!");
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_TOGGLE_MYOPIA, // Translation key for the keybind name
                InputUtil.Type.KEYSYM, // Key type (keyboard)
                GLFW.GLFW_KEY_O, // Default key (e.g., O for MyO-pia)
                KEY_CATEGORY_MYOPIA // Translation key for the category name
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleKey.wasPressed()) {
                enableBlur = !enableBlur;
                client.worldRenderer.reload();
            }
        });
    }// 1. Declare the keybind statically
    private static KeyBinding toggleKey;
}
