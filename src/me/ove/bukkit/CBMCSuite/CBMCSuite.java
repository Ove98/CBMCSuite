package me.ove.bukkit.CBMCSuite;

import java.util.logging.Logger;

import me.ove.bukkit.CBMCSuite.Commands.CBMCSuiteCommand;
import me.ove.bukkit.CBMCSuite.Commands.HubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import org.bukkit.plugin.java.JavaPlugin;

//
// CBMCSuite By Ove98 & CreeperAnatomy
// Copyright (c) OveHenrik 2013
//

public class CBMCSuite extends JavaPlugin implements Listener {
	CBMCSuiteManager manager = CBMCSuiteManager.getInstance();
	public static final Logger log = Logger.getLogger("Minecraft");
	
	private Scoreboard board;
	private Objective o;
	private Score s;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		p.setScoreboard(board);
		
	}
	
    public void onEnable() {
        log.info("[tjXHub] has been enabled.");
        getCommand("Hub").setExecutor(new HubCommand());
        getCommand("CBMCSuite").setExecutor(new CBMCSuiteCommand());
        board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
        o = board.registerNewObjective("totalPlayers", "totalKillCount");
        o.setDisplayName("Player Kills");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        s = o.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "Kills:"));
        manager.setup(this);
    }


    public void onDisable() {
        log.info("[tjXHub] has been disabled.");
    }
}
