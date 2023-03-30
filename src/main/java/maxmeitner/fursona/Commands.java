package maxmeitner.fursona;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class Commands implements CommandExecutor {
    public Commands() {}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        FileConfiguration conf = Fursona.getPlugin().getConfig();
        if (args.length!=0 && args[0].equals("reload")) {
            if (sender.hasPermission("fursona.reload")) {
                Fursona.getPlugin().reloadConfig();
                sender.sendMessage(StringHandler.getBetterString("messages.reload"));
            } else {sender.sendMessage(StringHandler.getBetterString("messages.noPermReload"));}

        } else if (args.length>1 && args[0].equals("set")) {
            if (sender.hasPermission("fursona.set")) {
                if (conf.getString("fursona."+args[1]) != null) {
                    Fursona.getCore().setFursona(sender.getName(), args[1]);
                    sender.sendMessage(StringHandler.getBetterString("messages.setFursona")
                            .replace("{fursona}", conf.getString("fursona."+args[1])));
                } else {sender.sendMessage(StringHandler.getBetterString("messages.fursonaNotFound"));}
            } else {sender.sendMessage(StringHandler.getBetterString("messages.noPermSetFursona"));}

        } else if (args.length!=0 && args[0].equals("list")) {
            if (sender.hasPermission("fursona.list")) {
                sender.sendMessage(StringHandler.getBetterString("messages.listFursonas")
                        .replace("{list}", String.join(", ", conf.getConfigurationSection("fursona").getKeys(true))));
            } else {sender.sendMessage(StringHandler.getBetterString("messages.noPermListFursonas"));}

        } else {sender.sendMessage(StringHandler.getBetterString("messages.help"));}

        return true;
    }
}
