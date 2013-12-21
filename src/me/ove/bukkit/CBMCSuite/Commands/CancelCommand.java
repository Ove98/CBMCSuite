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

public class CancelCommand implements CommandExecutor {
	
	
	
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
        
        
        
        if(cmd.getName().equalsIgnoreCase("Cancel")) {	        
    		if(p.hasPermission("cbmc.signs.new")) {
	
		        if(args.length == 0) {
		        	if(manager.getData().getString("MemorySlot1").equalsIgnoreCase("NULL") && manager.getData().getString("MemorySlot2").equalsIgnoreCase("NULL")) {
		        		p.sendMessage(x+pec1+ "There's nothing to cancel.");
		        	} else {
						manager.getData().set("MemorySlot2", "NULL");
						manager.getData().set("MemorySlot1", "NULL");
						manager.saveData();
						manager.reloadData();
			        	p.sendMessage(x+ "Cancelled.");
		        	}
		        }
		        if(args.length > 0) {
		        	p.sendMessage(x+ "Invalid Command.");
		        }
    		} else {p.sendMessage(x+pec1+ "You do not have the cbmc.signs.new permission.");}
	        
	        
	        
        }
		return false;
	}
}
