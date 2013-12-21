package me.ove.bukkit.CBMCSuite;

import java.util.logging.Logger;
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
    }


    public void onDisable() {
        log.info("[tjXHub] has been disabled.");
    }
}
