package net.ppekkungz;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.ppekkungz.Command.KmTabCommand;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class KmTab extends Plugin {

    public Configuration configuration;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("KmTab-Waterfall : Start Testing....");
        // CONFIG
        makeConfig();
        // RegisterCommand
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new KmTabCommand(this));
        // RegistetTab
        getProxy().getScheduler().schedule(this, () -> {
            if (configuration != null) {
                BaseComponent[] header = TextComponent.fromLegacyText(listToString(configuration.getStringList("ListHeader")));
                BaseComponent[] footer = TextComponent.fromLegacyText(listToString(configuration.getStringList("ListFooter")));
                for (ProxiedPlayer player : getProxy().getPlayers()) {
                    player.setTabHeader(header, footer);
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("KmTab-Waterfall : Stop Testing....");
    }

    public void makeConfigAlternative() throws IOException {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            try (InputStream in = getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void makeConfig() {
        try {
            makeConfigAlternative();
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void reloadConfig() {
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
            getLogger().info("Reload Config!");
        } catch (Exception ignored) {
            getLogger().warning("Can't Reload Config!");
        }
    }

    public String listToString(List<String> a) {
        if (a.isEmpty())
            return "";
        StringBuilder builder = new StringBuilder();
        for (String b : a) {
            builder.append("\n").append(b);
        }
        return builder.toString().replaceFirst("\n", "").replace("&", "§");
    }

}
