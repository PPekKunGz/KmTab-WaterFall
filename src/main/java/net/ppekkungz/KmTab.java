package net.ppekkungz;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.ppekkungz.Command.KmTabCommand;

import java.io.File;
import java.io.FileWriter;

public class KmTab extends Plugin {

    public Configuration configuration;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("KmTab-Waterfall : Start Testing....");
        // Config
        makeConfig();
        // RegisterCommand
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new KmTabCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("KmTab-Waterfall : Stop Testing....");
    }

    private void makeConfig() {
        try {
            if (!getDataFolder().exists()) {
                getLogger().info("Created config folder: " + getDataFolder().mkdir());
            }
            File configFile = new File(getDataFolder(), "config.yml");
            if (!configFile.exists()) {
                FileWriter fileWriter = new FileWriter(configFile);
                fileWriter.write("ListHeader:\n-TEST\nListFooter:\n-TEST");
                fileWriter.close();
            }
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
        } catch (Exception ignored) {
            getLogger().warning("Can't Load Config!");
        }
    }

    public void reloadConfig() {
        try {
            File configFile = new File(getDataFolder(), "config.yml");
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
            getLogger().info("Reload Config!");
        } catch (Exception ignored) {
            getLogger().warning("Can't Reload Config!");
        }
    }

}
