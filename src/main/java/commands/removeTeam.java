package commands;

import custom_items.fallenKingdoms.FallenKingdoms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class removeTeam implements CommandExecutor {
    private FallenKingdoms plugin;

    public removeTeam(FallenKingdoms plugin){
        this.plugin=plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length <1){
            sender.sendMessage("Not enough arguments");
            return false;
        }
        plugin.getTeamManager().removeTeam(sender,args[0]);
        return false;
    }
}
