package commands;

import custom_items.fallenKingdoms.FallenKingdoms;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import utils.Team;

public class createTeam implements CommandExecutor {
    private final FallenKingdoms plugin;

    public createTeam(FallenKingdoms plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==0){
            sender.sendMessage("Precise number of teams");
            return false;
        }
        plugin.getTeamManager().createTeam(sender,Integer.valueOf(args[0]));

        return false;
    }


}
