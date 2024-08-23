package utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;

public class TeamManager {
    private HashMap<String,Team> Teams =new HashMap<>();


    public HashMap<String, Team> getTeams() {
        return Teams;
    }

    public boolean removePlayerFromTeam(CommandSender sender, String player, String team){
        if(!Teams.containsKey(team)){
            sender.sendMessage("There is no team: "+team);
            return false;
        }
        if(!Teams.get(team).equipiers.contains(player)){
            sender.sendMessage("There is no "+player+" in "+team);
            return false;
        }
        Teams.get(team).equipiers.removeAll(Arrays.asList(player));

        return true;
    }

    public boolean addPlayerToTeam(CommandSender sender, String player, String team){

        String teamPlayer="";
        teamPlayer=teamOfPlayer(player);
        if(teamPlayer!=""){
            sender.sendMessage(player+" is already in "+teamPlayer);
            return  false;
        }
        if (Teams.containsKey(team)){
            Teams.get(team).equipiers.add(player);
        }else{
            sender.sendMessage("There is no team: " + team);
        }


        return true;
    }

    public String teamOfPlayer(String player){
        for(Team team:Teams.values()){
            if(team.equipiers.contains(player)){
                return team.name;
            }
        }

        return "";
    }



    public boolean forceAddPlayerToTeam(CommandSender sender,String player, String team){
        String actualTeam= "";
        actualTeam= teamOfPlayer(player);
        if (!actualTeam.equals("")){
            try {
                removePlayerFromTeam(sender,player,actualTeam);
            } catch (Exception e) {
                sender.sendMessage("removePlayerFromTeam\n"+String.valueOf(e));
            }
        }
        try{
            addPlayerToTeam(sender,player,team);
        } catch (Exception e) {
            sender.sendMessage("addPlayerToTeam\n"+String.valueOf(e));
        }

        return true;
    }


    public boolean showTeamsInfos(CommandSender sender){
        sender.sendMessage(ChatColor.RED+""+ChatColor.UNDERLINE+"There are "+Teams.size()+" teams");
        sender.sendMessage();

        for(Team valuesTeam:Teams.values()){
            sender.sendMessage(ChatColor.UNDERLINE+"Team: "+valuesTeam.name);

            String pseudos="";
            for(String pseudo:valuesTeam.equipiers){
                if(pseudos==""){
                    pseudos=pseudo;
                }else {
                    pseudos=pseudos+" "+pseudo;
                }
            }
            if(pseudos==""){
                sender.sendMessage("No player in this team");
            }else {
                sender.sendMessage("Equipiers: "+pseudos);
            }

            if(valuesTeam.world==null){
                sender.sendMessage("Ths team has no base in any world");
            }else {
                sender.sendMessage("World: "+valuesTeam.world.getName());
            }

            if(valuesTeam.position==null){
                sender.sendMessage("Ths team has no base");
            }else {
                sender.sendMessage("Position"+valuesTeam.position.getX()+" "+valuesTeam.position.getZ());
                sender.sendMessage(" ");
            }
        }
        return true;
    }

    public boolean createTeam(CommandSender sender,int number){
        if(number>16 &&number<2 ){
            sender.sendMessage("Range number of teams 2-16");
            return false;
        }

        for (int i=0; i<number;i++){
            Team tmpTeam=new Team();
            tmpTeam.name=ChatColor.values()[i].name();
            Teams.put(tmpTeam.name,tmpTeam);
            sender.sendMessage(tmpTeam.name+" has been created");
        }
        return true;
    }

    public boolean removeTeam(CommandSender sender, String team){
        if(team.equalsIgnoreCase("all")){
            Teams=new HashMap<>();
        }
        Teams.remove(team);
        return true;
    }
}
