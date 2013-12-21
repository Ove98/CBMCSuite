package me.ove.bukkit.CBMCSuite;

import java.util.logging.Logger;
import me.ove.bukkit.CBMCSuite.Commands.CBMCSuiteCommand;
import me.ove.bukkit.CBMCSuite.Commands.CancelCommand;
import me.ove.bukkit.CBMCSuite.Commands.HubCommand;
import me.ove.bukkit.CBMCSuite.Commands.InfoSignCommand;
import me.ove.bukkit.CBMCSuite.Listeners.JoinListener;
import me.ove.bukkit.CBMCSuite.Signs.InfoSigns;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

//
// CBMCSuite By Ove98 & CreeperAnatomy
// Copyright (c) OveHenrik 2013
//

public class CBMCSuite extends JavaPlugin {
	CBMCSuiteManager manager = CBMCSuiteManager.getInstance();
	public static final Logger log = Logger.getLogger("Minecraft");
	
    public void onEnable() {
        log.info("[tjXHub] has been enabled.");
        
        
        
        
        //Register Commands.
        getCommand("Hub").setExecutor(new HubCommand());
        getCommand("CBMCSuite").setExecutor(new CBMCSuiteCommand());
        getCommand("InfoSign").setExecutor(new InfoSignCommand());
        getCommand("Cancel").setExecutor(new CancelCommand());
        
        //Register Events.
        Bukkit.getServer().getPluginManager().registerEvents(new InfoSigns(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new InfoSignCommand(), this);
        
        //Manager Setup
        manager.setup(this);
    }


    public void onDisable() {
        log.info("[tjXHub] has been disabled.");
    }
}
