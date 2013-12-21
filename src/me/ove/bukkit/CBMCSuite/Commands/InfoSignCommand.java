package me.ove.bukkit.CBMCSuite.Commands;

import java.util.ArrayList;
import java.util.logging.Logger;
import me.ove.bukkit.CBMCSuite.CBMCSuiteManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

//
// CBMCSuiteGitHub By Ove98 & CreeperAnatomy
// Copyright (c) OveHenrik 2013
//

@SuppressWarnings("deprecation")
public class InfoSignCommand implements Listener, CommandExecutor {
	
	
	
	public static final Logger log = Logger.getLogger("Minecraft");
	
	ArrayList<Player> nis = new ArrayList<Player>(); //nis = New Info String
    

	
	CBMCSuiteManager manager = CBMCSuiteManager.getInstance();
	
	double ver = manager.getConfig().getDouble("Plugin.Version");
	
	ChatColor pc1 = ChatColor.GRAY; /*pc1 == Primary Colour 1*/
	ChatColor pc2 = ChatColor.DARK_AQUA; /*pc2 == Primary Colour 2*/
	ChatColor pec1 = ChatColor.RED; /*pec1 == Primary Error Colour 1*/
	
	String x = pc2 + "[tjXHub] " + pc1;
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		
        if (!(sender instanceof Player)) {sender.sendMessage(x + pec1 + "This plugin is for in-game players only!"); return true;}
        Player p = (Player) sender;
        
        
        
        if(cmd.getName().equalsIgnoreCase("InfoSign")) {	        
	        
	        if(args.length == 0) {
	        	p.sendMessage(pc2+ "[   Info Sign Help   ]");
	        	if(p.hasPermission("cbmc.signs.use")) {p.sendMessage(pc2+ "/InfoSign Use" +pc1+ " - How to use [Info] signs.");}
	        	if(p.hasPermission("cbmc.signs.create")) {p.sendMessage(pc2+ "/InfoSign Create" +pc1+ " - How to create [Info] signs.");}
	        }
	        
	        else if(args.length == 1) {
	        	if(args[0].equalsIgnoreCase("Create")) {
	        		if(p.hasPermission("cbmc.signs.create")) {
	        			
	    	        	p.sendMessage(pc2+ "[   Info Sign Help (Create)   ]");
	    	        	p.sendMessage(x+ "To create an [Info] string you start with doing the " +pc2+ "/InfoSign New <String>" +pc1+ " command. After that, you just type the message you want the String to eaqualize.");
	    	        	p.sendMessage(x+pec1+ "Example: " +pc2+ "/InfoSign New Message1" +pc1+ "When you do that you'll either get an error (If the string exsists already) OR a message that tells you to write the message you want the sign to display.");
	    	        	p.sendMessage("");
	    	        	p.sendMessage(x+ "To create the sign itself, you simply write '[Info]' on the first line. followed by the information string on the next line. If you do anything wrong the sign will turn red, and the chat will display an message telling you wwat you did wrong.");
	    	        	
	        			
	        			
	        		} else {p.sendMessage(x+pec1+ "You do not have the cbmc.signs.create permission.");}
	        	}
	        	
	        	
	        	
	        	else if(args[0].equalsIgnoreCase("Use")) {
	        		if(p.hasPermission("cbmc.signs.use")) {
	        			
	    	        	p.sendMessage(pc2+ "[   Info Sign Help (Use)   ]");
	    	        	p.sendMessage(x+ "To use a [Info] sign you simply right click the sign. It'll display a message.");
	        			
	        		} else {p.sendMessage(x+pec1+ "You do not have the cbmc.signs.use permission.");}
	        	}
	        	
	        	
	        	
	        	
	        	else if(args[0].equalsIgnoreCase("New")) {
	        		if(p.hasPermission("cbmc.signs.new")) {
	        			
	    	        	p.sendMessage(pc2+ "Please specify an information string.");

	        			
	        		} else {p.sendMessage(x+pec1+ "You do not have the cbmc.signs.new permission.");}
	        	}
	        	
	        	
	        	else {p.sendMessage(x+pec1+ "Invalid Command.");}
	        }
	        
	        
	        
	        
	        
	        
	        else if(args.length == 2) {
	        	if(args[0].equalsIgnoreCase("New")) {
	        		if(p.hasPermission("cbmc.signs.new")) {

	        		
	        		if(manager.getConfig().contains("InfoSigns." + args[1].toLowerCase()) == true) {
	        			p.sendMessage(x+pec1+ "That information string exists already.");
	        			return false;
	        		} else {
	        			p.sendMessage(x+pc2+ "Creating information string. [" +args[1] +"]");
	        			nis.add(p);
	        			manager.getData().set("LastInfoString", args[1]);
	        			manager.saveData();
	        			manager.reloadData();
	        			p.sendMessage(x+pc2+ "Please enter your information string message. (In the local chat)");
	        		}
	        		} else {p.sendMessage(x+pec1+ "You do not have the cbmc.signs.new permission.");}

	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        	} else {p.sendMessage(x+pec1+ "Invalid Command.");}
	        }
	        
	        
	        
        }
		return false;
	}
	
	@EventHandler
	public void onPlayerChatEvent(PlayerChatEvent e) {
		Player p = e.getPlayer();
		String is = manager.getData().getString("LastInfoString");

		if(nis.contains(e.getPlayer())) {
			String msg = e.getMessage();
			e.setCancelled(true);
			manager.getData().set("InfoSigns." +is.toLowerCase(), msg);
			p.sendMessage(x+pc2+ "Successfully created the information string: [" +is+ "]");
			p.sendMessage(x+pc2+ "Message: " +pc1+ msg);
			
		}
	}
	
}
