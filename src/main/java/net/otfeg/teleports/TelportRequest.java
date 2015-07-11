package net.otfeg.teleports;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TelportRequest {
	private Teleports teleports;

	public TelportRequest(Teleports teleports) {
		this.teleports = teleports;
		Map<Player, Stack<Player>> requests = new HashMap<Player, Stack<Player>>();
		
	}
	class Request{
		
	}
	class Tpa implements CommandExecutor{

		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
				String[] arg3) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	class TpaHere implements CommandExecutor{

		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
				String[] arg3) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	class Tpaccept implements CommandExecutor{

		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
				String[] arg3) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
}
