package commands;

import custom_items.fallenKingdoms.FallenKingdoms;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import utils.Team;

import java.util.Map;

public class showTeamsInfos  implements CommandExecutor {
    private FallenKingdoms plugin;


    public showTeamsInfos(FallenKingdoms plugin){
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.getTeamManager().showTeamsInfos(sender);

        return false;
    }
}
