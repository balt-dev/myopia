package mba.sno.myopia.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyopiaClient implements ClientModInitializer {
    public static final String MOD_ID = "Myopia";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Making Minecraft look Bad™ since 2024!");
    }
}
