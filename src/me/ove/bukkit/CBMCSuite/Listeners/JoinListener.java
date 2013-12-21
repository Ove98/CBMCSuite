package me.ove.bukkit.CBMCSuite.Listeners;

import java.util.ArrayList;

import me.ove.bukkit.CBMCSuite.CBMCSuiteManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

//
// CBMCSuiteGitHub By Ove98 & CreeperAnatomy
// Copyright (c) OveHenrik 2013
//

public class JoinListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		/*Strings & Valuables*/
		//////////////////////////////////////////////////////////////////////
		CBMCSuiteManager manager = CBMCSuiteManager.getInstance();
		ChatColor pc1 = ChatColor.GRAY; /*pc1 == Primary Colour 1*/
		ChatColor pc2 = ChatColor.DARK_AQUA; /*pc2 == Primary Colour 2*/
		@SuppressWarnings("unused")
		ChatColor pec1 = ChatColor.RED; /*pec1 == Primary Error Colour 1*/
		String x = pc2 + "[tjXHub] " + pc1;
		Player p = e.getPlayer();
		//////////////////////////////////////////////////////////////////////

		
		/*Message Of The Day (MOTD)*/
		//////////////////////////////////////////////////////////////////////
		if(manager.getConfig().getString("PlayerJoin.Enable.MOTD").equalsIgnoreCase("true")) {
			
			p.sendMessage("==========================================");
			
			p.sendMessage("+ "+pc1+ manager.getConfig().getString("MOTD.Message")
					.replace("$cbmc$", pc2+"CB-MC"+pc1)
					.replace("$logo$", pc2+"[tjXHub]"+pc1)
					.replace("$plugin$", pc2+"CBMCSuite"+pc1)
					.replace("$player$", p.getName())
					.replace("$devs$", pc2+"Ove98 & CreeperAnatomy"+pc1) );
			
			p.sendMessage("==========================================");
		}
		//////////////////////////////////////////////////////////////////////

		
		
		
		/*Potion Effects*/
		//////////////////////////////////////////////////////////////////////
		if(manager.getConfig().getString("PlayerJoin.Enable.PotionEffects").equalsIgnoreCase("true")) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, 0));
		}
		//////////////////////////////////////////////////////////////////////

		
		
		
		/*Welcome Broadcast*/
		//////////////////////////////////////////////////////////////////////
		if(manager.getConfig().getString("PlayerJoin.Enable.WelcomeBroadcast").equalsIgnoreCase("true")) {
			if(p.hasPlayedBefore() == false) {
				Bukkit.broadcastMessage(x+pc2+ manager.getConfig().getString("PlayerJoin.Messages.Welcome")
						.replace("$cbmc$", pc2+"CB-MC"+pc1)
						.replace("$logo$", pc2+"[tjXHub]"+pc1)
						.replace("$plugin$", pc2+"CBMCSuite"+pc1)
						.replace("$player$", p.getName())
						.replace("$devs$", pc2+"Ove98 & CreeperAnatomy"+pc1));
			}
		}
		//////////////////////////////////////////////////////////////////////

		
		
		/*Welcome Kit*/
		//////////////////////////////////////////////////////////////////////
		if(manager.getConfig().getString("PlayerJoin.Enable.JoinClear&Kit").equalsIgnoreCase("true")) {
			PlayerInventory pi = p.getInventory();			
			ItemStack item = new ItemStack(Material.COMPASS);
			ItemMeta id = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			
			id.setDisplayName(ChatColor.RED + "Server Selector");
			lore.add(ChatColor.GRAY +""+ ChatColor.ITALIC +"Browse through all avalible servers.");
			id.setLore(lore);
			item.setItemMeta(id);
			
			pi.clear(); //Clears the player's inventory.
			pi.addItem(new ItemStack(item)); //Adds the item to your inventory
		}
		//////////////////////////////////////////////////////////////////////
	}
}
