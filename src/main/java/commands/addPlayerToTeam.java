package commands;

import custom_items.fallenKingdoms.FallenKingdoms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class addPlayerToTeam implements CommandExecutor {
    private FallenKingdoms plugin;

    public addPlayerToTeam(FallenKingdoms plugin){
        this.plugin=plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length<2){
            sender.sendMessage("Not enough arguments");
            return false;
        }

        this.plugin.getTeamManager().addPlayerToTeam(sender, args[0],args[1]);

        return false;
    }
}
