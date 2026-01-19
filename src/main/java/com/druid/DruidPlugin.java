package com.druid;

import com.hypixel.hytale.sdk.plugin.BasePlugin;
import com.hypixel.hytale.sdk.plugin.PluginInit;
import com.hypixel.hytale.server.event.player.PlayerJoinEvent;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DruidPlugin extends BasePlugin {
    private final Map<UUID, DruidBarPage> playerBars = new ConcurrentHashMap<>();

    public DruidPlugin(PluginInit init) {
        super(init);
    }

    @Override
    public void onEnable() {
        // Registers the plugin to listen for the player joining
        getEventRegistry().register(this);
        getLogger().info("Druid Forms Mod enabled!");
    }

    public void onPlayerJoin(PlayerJoinEvent event) {
        var player = event.getPlayer();
        var page = new DruidBarPage(player.getRef());

        // Opens your custom UI page for the player
        player.getPageManager().openCustomPage(page);

        // Maps the player's unique ID to their UI page
        playerBars.put(player.getUniqueId(), page);
    }
}