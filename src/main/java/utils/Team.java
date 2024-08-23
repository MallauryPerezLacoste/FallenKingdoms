package utils;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    public String name="";
    public List<String> equipiers=new ArrayList<>();
    public Chunk position=null;
    public World world;

    public Team(){
        return;
    }

    public Team(String name, List<String> equipiers, Chunk chunck,World world){
        this.name=name;
        this.equipiers=equipiers;
        this.position = chunck;
        this.world=world;
    }
}
