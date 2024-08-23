package custom_items.fallenKingdoms;

import commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import utils.Team;
import utils.TeamManager;

import java.util.HashMap;

public final class FallenKingdoms extends JavaPlugin {
    private TeamManager teamManager =new TeamManager();


    @Override
    public void onEnable() {
        this.getCommand("createteam").setExecutor(new createTeam(this));
        this.getCommand("showTeamsInfos").setExecutor(new showTeamsInfos(this));
        this.getCommand("addPlayerToTeam").setExecutor(new addPlayerToTeam(this));
        this.getCommand("removePlayerFromTeam").setExecutor(new removePlayerFromTeam(this));
        this.getCommand("forceAddPlayerToTeam").setExecutor(new forceAddPlayerToTeam(this));
        this.getCommand("removeTeam").setExecutor(new removeTeam(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public TeamManager getTeamManager(){
        return teamManager;
    }
}
