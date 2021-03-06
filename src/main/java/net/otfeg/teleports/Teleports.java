package net.otfeg.teleports;

import java.util.logging.Logger;
import net.otfeg.teleports.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Teleports extends JavaPlugin {
	private Logger logger;
	
	@Override
	public void onEnable() {
		this.logger = this.getLogger();
		new Spawn(this);
		new SetSpawn(this);
		new Bed(this);
		new Back(this);
		//new TelportRequest(this);
		saveDefaultConfig();   	
	}
	
	public int getDelay() {
		return getConfig().getInt("delay");	
	}
	
	public int getRadius() {
		return getConfig().getInt("radius");
	}
}

