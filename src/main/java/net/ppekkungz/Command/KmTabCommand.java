package net.ppekkungz.Command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;
import net.ppekkungz.KmTab;

import java.util.ArrayList;
import java.util.List;

public class KmTabCommand extends Command implements TabExecutor {
    private final KmTab kmcore;

    public KmTabCommand(KmTab kmcore) {
        super("kmtab");
        this.kmcore = kmcore;
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length >= 1 && args[0].equals("reload")) {
            sender.sendMessage(ChatColor.GREEN + "KmTab-WaterFall : ReloadConfig!!");
            this.kmcore.reloadConfig();
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        ArrayList<String> lists = new ArrayList<>();
        if (args.length == 1) {
            lists.add("reload");
        }
        return lists;
    }


}
