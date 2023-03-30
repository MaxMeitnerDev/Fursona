package maxmeitner.fursona;

import org.bukkit.ChatColor;

public class StringHandler {
    public static String getBetterString(String path) {
        return ChatColor.translateAlternateColorCodes('&', Fursona.getPlugin().getConfig().getString(path)
                .replaceAll("#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])", "&x&$1&$2&$3&$4&$5&$6"));
    }
}
