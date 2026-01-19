package com.druid;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.sdk.ui.CustomPageLifetime;
import com.hypixel.hytale.sdk.ui.InteractiveCustomUIPage;
import com.hypixel.hytale.sdk.ui.builder.UICommandBuilder;
import com.hypixel.hytale.sdk.ui.builder.UIEventBuilder;
import com.hypixel.hytale.server.event.player.PlayerRef;

public class DruidBarPage extends InteractiveCustomUIPage {

    public DruidBarPage(Ref<PlayerRef> playerRef) {
        super(playerRef, CustomPageLifetime.PERMANENT);
    }

    @Override
    public void build(UICommandBuilder builder) {
        // Path to your .ui file relative to the Mods folder
        builder.resource("DruidForms/Common/UI/Pages/druid_bar.ui");
    }

    @Override
    public void onEvent(UIEventBuilder event) {
        String elementId = event.getElementId();

        // If a button ending in _btn is clicked (antelope_btn, cat_btn, etc.)
        if (elementId.endsWith("_btn")) {
            // Formats the name to match your JSON files (e.g., 'DruidAntelopeForm')
            String species = elementId.substring(0, 1).toUpperCase() +
                    elementId.substring(1).replace("_btn", "");
            String effectName = "Druid" + species + "Form";

            // Applies the shapeshift effect from your JSON files
            getPlayer().applyEffect(effectName);
        }
    }
}