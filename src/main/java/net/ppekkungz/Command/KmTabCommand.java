package net.ppekkungz.Command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;
import net.ppekkungz.KmTab;

public class KmTabCommand implements TabExecutor {
    private final KmTab kmcore;

    public KmTabCommand(KmTab kmcore) {
    this.kmcore = kmcore;
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length >= 1 &&
        args[0].equals("reload")) {
            sender.sendMessage("" + ChatColor.GREEN + "KmTab-WaterFall : ReloadConfig!!");
            this.kmcore.reloadConfig();
        }
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
