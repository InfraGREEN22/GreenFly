package ru.infragreen22.greenfly;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ru.infragreen22.greenfly.commands.ToggleFly;
import ru.infragreen22.greenfly.events.KeepFly;


public class Fly extends JavaPlugin {

    private ToggleFly reference = new ToggleFly();

    @Override
    public void onEnable() {
        PluginDescriptionFile pdf = getDescription();
        getLogger().info(pdf.getName()+ " " + pdf.getVersion() + " by " + pdf.getAuthors() + " has been enabled!");
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile pdf = getDescription();
        getLogger().info(pdf.getName()+ " " + pdf.getVersion() + " by " + pdf.getAuthors() + " has been disabled!");
    }

    public void registerCommands() {
        getCommand("fly").setExecutor(reference);
    }

    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new KeepFly(reference), this);
    }
}
