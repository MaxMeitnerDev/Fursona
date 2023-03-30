package maxmeitner.fursona;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {
    public EventListener() {}

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {Fursona.getCore().getFursona(e.getPlayer().getName());}
    // Sets the fursona value to "notSelected" if the player is not found in the database.
}
