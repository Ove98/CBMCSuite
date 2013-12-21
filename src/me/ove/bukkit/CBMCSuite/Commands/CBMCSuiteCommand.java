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

public class CBMCSuiteCommand implements CommandExecutor {
	
	//
	// NEWS CLASS
	//
	String NEWS = ChatColor.GRAY+ "No news.";
	
	public static final Logger log = Logger.getLogger("Minecraft");
	
	CBMCSuiteManager manager = CBMCSuiteManager.getInstance();
	
	double ver = manager.getConfig().getDouble("Plugin.Version");
	
	ChatColor pc1 = ChatColor.WHITE; /*pc1 == Primary Colour 1*/
	ChatColor pc2 = ChatColor.DARK_AQUA; /*pc2 == Primary Colour 2*/
	ChatColor pec1 = ChatColor.RED; /*pec1 == Primary Error Colour 1*/
	
	String x = pc2 + "[tjXHub] " + pc1;
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		
        if (!(sender instanceof Player)) {sender.sendMessage(x + pec1 + "This plugin is for in-game players only!"); return true;}
        Player p = (Player) sender;
        
        
        
        if(cmd.getName().equalsIgnoreCase("CBMCSuite")) {	        
	        
	        if(args.length == 0) {
	        	p.sendMessage(pc1+ "CBMCSuite Coded By " +ChatColor.BLUE+ "Ove98 " +pc1+ "& " +ChatColor.BLUE+ "CreeperAnatomy");
	        	p.sendMessage(NEWS);
	        }

	        
	        else if(args.length > 0) {
	        	p.sendMessage(x+pec1+ "Invalid command!");
	        }
	        
	        
	        
        }
		return false;
	}
}
