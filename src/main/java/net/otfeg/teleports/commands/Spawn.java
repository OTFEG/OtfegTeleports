package net.otfeg.teleports.commands;

import net.otfeg.teleports.TeleportDelay;
import net.otfeg.teleports.Teleports;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor{
	private Teleports teleports;
	public Spawn(Teleports teleports) {
		this.teleports = teleports;
		teleports.getCommand("spawn").setExecutor(this);
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(!(sender instanceof Player)) return true; //check if player issued command
		Player player = (Player) sender;
		Location location;
		// /spawn
		switch(args.length){
		
			case 0: location = player.getWorld().getSpawnLocation();
			break;
			case 1:{
				if(args[0].equalsIgnoreCase("list")){ // /spawn list
					//list out worlds
					for(World world:teleports.getServer().getWorlds()){
						if(player.hasPermission("teleports."+world.getName()))
								player.sendMessage(world.getName());
					}
					return true;
				}else{ // /spawn <world>
					World world = teleports.getServer().getWorld(args[0]);
					if(world == null){ // check if work exist
						player.sendMessage("World not found.");
						player.sendMessage("Use /spawn list to show available worlds.");
						return true;
					}
					if(!player.hasPermission("teleports."+world.getName())) {
						player.sendMessage("You do not have permission to teleport to this world.");
						return true;
					}
					location = world.getSpawnLocation();
				}
				break;
			}
			default:
				return true;
		}
		//teleport player
		new TeleportDelay(teleports, player, location,
				teleports.getDelay(), teleports.getRadius(),
				"You have been teleported to " + location.getWorld().getName() + " spawn.");
		return true;
	}
	
}
