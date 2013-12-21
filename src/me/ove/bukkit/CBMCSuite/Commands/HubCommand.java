package me.ove.bukkit.CBMCSuite.Commands;

import java.util.logging.Logger;
import me.ove.bukkit.CBMCSuite.CBMCSuiteManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

//
// CBMCSuite By Ove98 & CreeperAnatomy
// Copyright (c) OveHenrik 2013
//

public class HubCommand implements CommandExecutor {
	
	
	
	public static final Logger log = Logger.getLogger("Minecraft");
	
	CBMCSuiteManager manager = CBMCSuiteManager.getInstance();
		
	ChatColor pc1 = ChatColor.GRAY; /*pc1 == Primary Colour 1*/
	ChatColor pc2 = ChatColor.DARK_AQUA; /*pc2 == Primary Colour 2*/
	ChatColor pec1 = ChatColor.RED; /*pec1 == Primary Error Colour 1*/
	
	String x = pc2 + "[tjXHub] " + pc1;
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		
        if (!(sender instanceof Player)) {sender.sendMessage(x + pec1 + "This plugin is for in-game players only!"); return true;}
        Player p = (Player) sender;
        
        
        
        if(cmd.getName().equalsIgnoreCase("Hub")) {	        
	        
	        if(args.length == 0) {
	        	p.sendMessage(pc1+ "CBMCSuite Coded By " +ChatColor.DARK_GRAY+ "Ove98 " +pc1+ "& " +ChatColor.DARK_GRAY+ "CreeperAnatomy");
	        	p.sendMessage(pc1+ "Type " +pc2+ "/Hub Help" +pc1+ " To view all available commands.");
	        }
	        
	        else if(args.length == 1) {
	        	if(args[0].equalsIgnoreCase("Help")) {
		        	p.sendMessage(pc2+ "[   CBMCSuite Help   ]");
		        	p.sendMessage(pc2+ "/CBMCSuite" +pc1+ " - Displays important plugin news.");
		        	p.sendMessage(pc2+ "/Hub Version" +pc1+ " - Displays the current version of the plugin.");
		        	p.sendMessage(pc2+ "/Hub Information" +pc1+ " - Displays some info about this plugin.");
		        	p.sendMessage(pc2+ "/Hub" +pc1+ " - ");
		        	p.sendMessage(pc2+ "/Hub" +pc1+ " - ");
		        	p.sendMessage(pc2+ "/Hub" +pc1+ " - ");



	        	}
	        	
	        	else if(args[0].equalsIgnoreCase("Version") || args[0].equalsIgnoreCase("Ver")) {
	        		p.sendMessage(x+ "Current Version: " +ChatColor.ITALIC+ manager.getConfig().getDouble("Plugin.Version"));
	        	}
	        	
	        	else if(args[0].equalsIgnoreCase("Information") || args[0].equalsIgnoreCase("Info")) {
	        		p.sendMessage(x+ ChatColor.GRAY + "Created By Ove98 & CreeperAtonomy");
	        		p.sendMessage(x+ "CBMC Hub is a plugin designed for the CB-MC server, it's the newest Hub plugin that enhances your server experience.");
	        	}
	        	
	        	
	        	
	        	else {
		        	p.sendMessage(x+pec1+ "Invalid command!");	
	        	}
	        	
	        }
	        
	        else if(args.length > 1) {
	        	p.sendMessage(x+pec1+ "Invalid command!");
	        }
	        
	        
	        
        }
		return false;
	}
}
