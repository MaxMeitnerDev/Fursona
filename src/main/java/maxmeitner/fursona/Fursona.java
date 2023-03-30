package maxmeitner.fursona;

import maxmeitner.fursona.db.Core;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Fursona extends JavaPlugin {
    private static Fursona plugin;
    private Core core;
    public Fursona() {}

    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        core = new Core();
        new Placeholders(this).register();
        getCommand("fursona").setExecutor(new Commands());
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
    }

    public void onDisable() {if(core != null) core.close();}

    public static Core getCore() {return plugin.core;}

    public static Fursona getPlugin() {return plugin;}
}
