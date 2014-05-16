package io.github.hybrezz54.RandomTP;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomTP extends JavaPlugin {

	private Logger logger = Bukkit.getLogger();
	private Player destPlayer;

	@Override
	public void onEnable() {
		logger.warning("RandomTP v1.0 is enabled!");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (args.length >= 1) {
			if (cmd.getName().equalsIgnoreCase("randheight") && (args.length > 0)) {
				Player player = (Player) sender;

				if (args.length == 2) {
					destPlayer = Bukkit.getServer().getPlayer(args[0]);
					Location playerLoc = destPlayer.getLocation();
					playerLoc.setY(Integer.parseInt(args[1]));
					destPlayer.teleport(playerLoc);
					destPlayer.sendMessage(ChatColor.GREEN + "Moved to a height of " + playerLoc.getY());
					player.sendMessage(ChatColor.GREEN + "Moved " + destPlayer.getName() + " to a height of " + playerLoc.getY());
				} else if (args.length == 1) {
					destPlayer = Bukkit.getServer().getPlayer(args[0]);
					Location playerLoc = destPlayer.getLocation();
					playerLoc.setY(destPlayer.getWorld().getHighestBlockYAt(playerLoc) + ((int) (Math.random() * 50)));
					destPlayer.teleport(playerLoc);
					destPlayer.sendMessage(ChatColor.GREEN + "Moved to a height of " + playerLoc.getY());
					player.sendMessage(ChatColor.GREEN + "Moved " + destPlayer.getName() + " to a height of " + playerLoc.getY());
				} else {
					player.sendMessage(ChatColor.RED + "Player not found!");
				}

				return true;
			} else if (cmd.getName().equalsIgnoreCase("rand")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					player.sendMessage(ChatColor.GOLD + "This command has not been implemented!");;
					return true;
				}
			}
			return false;
		} else
			return false;
	}

	@Override
	public void onDisable() {
		logger.warning("RandomTP v1.0 is disabled!");
	}

}
