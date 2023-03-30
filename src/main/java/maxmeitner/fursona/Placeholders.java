package maxmeitner.fursona;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class Placeholders extends PlaceholderExpansion {
    private final Fursona plugin;

    public Placeholders(Fursona plugin) {
        this.plugin = plugin;
    }

    public boolean persist() {
        return true;
    }

    public boolean canRegister() {
        return true;
    }

    public String getAuthor() {
        return this.plugin.getDescription().getAuthors().toString();
    }

    public String getIdentifier() {return "fursona";}

    public String getVersion() {
        return this.plugin.getDescription().getVersion();
    }

    public String onPlaceholderRequest(Player player, String identifier) {
        if (identifier.contains("name")) {
            return StringHandler.getBetterString("fursona."+Fursona.getCore().getFursona(player.getName()));
        } else {return null;}
    }
}