package net.otfeg.teleports.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		//set spawn of the world that the player is in at their current location
		if(sender instanceof Player){
			Player player = (Player) sender;
			Location location = player.getLocation();
			player.getWorld().setSpawnLocation(location.getBlockX(),
					location.getBlockY(),location.getBlockZ());
			player.sendMessage("Spawn set.");
		}
		return false;
	}
	
}
