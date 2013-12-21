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
	
	public static final Logger log = Logger.getLogger("Minecraft");
	
	CBMCSuiteManager manager = CBMCSuiteManager.getInstance();
	
	
	ChatColor pc1 = ChatColor.GRAY; /*pc1 == Primary Colour 1*/
	ChatColor pc2 = ChatColor.DARK_AQUA; /*pc2 == Primary Colour 2*/
	ChatColor pec1 = ChatColor.RED; /*pec1 == Primary Error Colour 1*/
	
	String x = pc2 + "[tjXHub] " + pc1;
	String NEWS = pc1+ "+ New [Info] sign tutorial! " +pc2+ "http://youtu.be/VhfZKeuG18Q";

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		
        if (!(sender instanceof Player)) {sender.sendMessage(x + pec1 + "This plugin is for in-game players only!"); return true;}
        Player p = (Player) sender;
        
        
        
        if(cmd.getName().equalsIgnoreCase("CBMCSuite")) {	        
	        
	        if(args.length == 0) {
	        	if(p.hasPermission("cbmc.news")) {
	        		p.sendMessage(NEWS);
	        	} else {p.sendMessage(x+pec1+ "You are not allowed to read the news.");}
	        }

	        if(args.length == 1) {
	        	if(p.hasPermission("cbmc.dev")) {
		        	if(args[0].equalsIgnoreCase("Reload")) {p.sendMessage(x+ "Reloading the .yml files..."); manager.reloadConfig(); manager.reloadData(); p.sendMessage(x+ "Done.");}
		        	else if(args[0].equalsIgnoreCase("Test")) {p.sendMessage(x+ "Coming soon");}
		        	else if(args[0].equalsIgnoreCase("Save")) {p.sendMessage(x+ "Saving the .yml files..."); manager.saveConfig(); manager.saveData(); p.sendMessage(x+ "Done.");}
		        	else if(args[0].equalsIgnoreCase("ClearData")) {p.sendMessage(x+ "Clearing all saved data..."); manager.getData().set("", null); p.sendMessage(x+ "Done.");}
		        	else {p.sendMessage(x+pec1+ "Invalid command!");}
	        	} else {p.sendMessage(x+pec1+ "Only developers are allowed to run this command.");}
	        }

	        
	        else if(args.length > 1) {
	        	p.sendMessage(x+pec1+ "Invalid command!");
	        }
	        
	        
	        
        }
		return false;
	}
}
