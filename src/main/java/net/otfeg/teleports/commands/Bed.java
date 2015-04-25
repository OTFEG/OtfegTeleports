package net.otfeg.teleports.commands;

import net.otfeg.teleports.TeleportDelay;
import net.otfeg.teleports.Teleports;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bed implements CommandExecutor {
	private Teleports teleports;

	public Bed(Teleports teleports) {
		this.teleports = teleports;
		teleports.getCommand("bed").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command arg1, String arg2,
			String[] arg3) {
		//teleports the palyer to their bed
		if(sender instanceof Player){ //Check if a player executed the command
			Player player = (Player)sender;
			if(player.getBedSpawnLocation()!=null){ //check if player has a bed
				new TeleportDelay(teleports, player, player.getBedSpawnLocation(),
						teleports.getDelay(), teleports.getRadius() ,
						"You have been teleported to your bed.");
			}else sender.sendMessage("Your bed cannot be found.");
		}
		return true;
	}

}
