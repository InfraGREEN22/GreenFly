package ru.infragreen22.greenfly.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.infragreen22.greenfly.commands.ToggleFly;

public class KeepFly implements Listener {

    private ToggleFly tf;

    public KeepFly(ToggleFly t) {
        this.tf = t;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (tf.hasFly.contains(event.getPlayer().getName())) {
            event.getPlayer().setAllowFlight(true);
            event.getPlayer().setFlying(true);
        }
    }
}
