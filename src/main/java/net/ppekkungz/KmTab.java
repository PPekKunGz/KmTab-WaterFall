package net.ppekkungz;

import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.ppekkungz.Command.KmTabCommand;


import java.util.ArrayList;
import java.util.Objects;

public class KmTab extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("KmTab-Waterfall : Start Testing....");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("KmTab-Waterfall : Stop Testing....");
    }

    public void reloadConfig() {
    }
}
