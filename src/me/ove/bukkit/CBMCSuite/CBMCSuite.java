package me.ove.bukkit.CBMCSuite;

import java.util.logging.Logger;

import me.ove.bukkit.CBMCSuite.Commands.CBMCSuiteCommand;
import me.ove.bukkit.CBMCSuite.Commands.HubCommand;

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
        getCommand("Hub").setExecutor(new HubCommand());
        getCommand("CBMCSuite").setExecutor(new CBMCSuiteCommand());
    }


    public void onDisable() {
        log.info("[tjXHub] has been disabled.");
    }
}
