package me.ove.bukkit.CBMCSuite.Signs;

import me.ove.bukkit.CBMCSuite.CBMCSuiteManager;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

//
// CBMCSuiteGitHub By Ove98 & CreeperAnatomy
// Copyright (c) OveHenrik 2013
//

public class InfoSigns implements Listener {
	
	CBMCSuiteManager manager = CBMCSuiteManager.getInstance();

	
	ChatColor pc1 = ChatColor.GRAY; /*pc1 == Primary Colour 1*/
	ChatColor pc2 = ChatColor.DARK_AQUA; /*pc2 == Primary Colour 2*/
	ChatColor pec1 = ChatColor.RED; /*pec1 == Primary Error Colour 1*/
	
	String x = pc2 + "[tjXHub] " + pc1;
	
	
	
	
    @EventHandler
    public void onSignChange(SignChangeEvent e) {
            if (e.getLine(0).equalsIgnoreCase("[Info]")) {
            	if(e.getPlayer().hasPermission("cbmc.signs.create")) {

            	if(e.getLine(1).equals("")) {e.setLine(0, ChatColor.DARK_RED + "[Info]"); e.getPlayer().sendMessage(x+pec1+ "Please specify an information string.");}
            	else {
	            	if(manager.getData().contains("InfoSigns." + e.getLine(1).toLowerCase()) == true) {
	                    e.setLine(0, ChatColor.DARK_BLUE + "[Info]");
	                    e.setLine(1, e.getLine(1));
	            		e.getPlayer().sendMessage(x+pc2+ "Info sign sucsessfully created! ["+ e.getLine(1) +"]");
	            	} else {
	            		e.getPlayer().sendMessage(x+pec1+ "Invalid info string. ["+ e.getLine(1) +"]");
	            		e.setLine(0, ChatColor.DARK_RED + "[Info]");
	                    e.setLine(1, e.getLine(1));
	            	}
            	}
            } else {e.getPlayer().sendMessage(x+pec1+ "You do not have the cbmc.signs.create permission.");}
    	}
    }
   
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
            if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
            if (e.getClickedBlock().getState() instanceof Sign) {
                    Sign s = (Sign) e.getClickedBlock().getState();
                    if (s.getLine(0).equalsIgnoreCase(ChatColor.DARK_BLUE + "[Info]")) {
                    	Player p = (Player) e.getPlayer();
                    	if(p.hasPermission("cbmc.signs.use")) {
                    		p.sendMessage(ChatColor.GRAY + manager.getData().getString("InfoSigns." + s.getLine(1).toLowerCase()).replace("$logo$", x));
                    	} else {p.sendMessage(x+pec1+ "You do not have the cbmc.signs.use permission.");}
                    }
            }
    }
}