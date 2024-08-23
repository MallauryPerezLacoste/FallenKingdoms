package commands;

import custom_items.fallenKingdoms.FallenKingdoms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class forceAddPlayerToTeam implements CommandExecutor {
    private FallenKingdoms plugin;


    public forceAddPlayerToTeam(FallenKingdoms plugin){
        this.plugin=plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length<2){
            sender.sendMessage("Not enough arguments");
            return false;
        }
        plugin.getTeamManager().forceAddPlayerToTeam(sender,args[0], args[1]);
        return false;
    }
}
