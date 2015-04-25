package net.otfeg.teleports.commands;

import java.util.HashMap;
import net.otfeg.teleports.TeleportDelay;
import net.otfeg.teleports.Teleports;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Back implements Listener, CommandExecutor{

	private HashMap<Player, Location> lastlocation;
	private Teleports teleports;
	public Back(Teleports teleports) {
		this.teleports = teleports;
		teleports.getCommand("back").setExecutor(this);
		teleports.getServer().getPluginManager().registerEvents(this, teleports);
		lastlocation = new HashMap<Player, Location>();
	}
	@EventHandler
	public void PlayerTeleport(PlayerTeleportEvent event) {
		lastlocation.put(event.getPlayer(), event.getFrom());
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		Player player = (Player) sender;
		Location location = lastlocation.get(player);
		if(location==null) return true;
		new TeleportDelay(teleports, player, location,
				teleports.getDelay(), teleports.getRadius(), "You have been teleported back.");
		return true;
	}

}
