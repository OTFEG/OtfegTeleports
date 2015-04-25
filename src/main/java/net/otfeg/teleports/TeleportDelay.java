package net.otfeg.teleports;

import net.otfeg.teleports.Teleports;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TeleportDelay extends BukkitRunnable{
    private Location location, destination;
    private Player player;
    private int radius;
    private String message;

    public TeleportDelay(Teleports plugin,Player player, Location destination,
                         int delay, int radius, String message){
        if(delay == 0 ){ //if delay is 0 teleport player immediately
            player.teleport(destination);
            player.sendMessage(message);
        }else{ //create a delayed task
            runTaskLater(plugin, delay * 20);
            location = player.getLocation();
            this.destination = destination;
            this.player = player;
            this.radius = radius;
            this.message = message;
            player.sendMessage(ChatColor.YELLOW +
                    "You will be teleported in " + delay + " seconds.");
            player.sendMessage(ChatColor.YELLOW +
                    "Please stay in a " + radius + " block radius.");
        }
    }
    public void run() {
        /*Check if player is within the radius, if they are teleport them
        */
        if(Math.abs(this.location.getBlockX() -
                this.player.getLocation().getBlockX()) <= this.radius &&
                Math.abs(this.location.getBlockZ() -
                        this.player.getLocation().getBlockZ()) <= this.radius){
            this.player.teleport(this.destination);
            player.sendMessage(this.message);
        }else player.sendMessage(ChatColor.YELLOW + "You moved too far away.");
        location = null;
        destination = null;
        player = null;
        radius = 0;
        message = null;


    }

}