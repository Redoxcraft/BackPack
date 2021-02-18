package de.redoxcraft.backpack.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class OpenBackpackCommand implements CommandExecutor {

	@Override
	public boolean onCommand( CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			//if(p.hasPermission("rucksack")) {
				if(args.length == 0) {
					p.openInventory(p.getEnderChest());
					return true;
				}else if(args.length == 1) {
					if(p.isOp()) {
						Player target = Bukkit.getPlayer(args[0]);
						if(target == null) {
							p.sendMessage(ChatColor.WHITE + "Der Spieler " + args[0] + " ist nicht Online." + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Wo er wohl seinen Rucksack versteckt?*");
							return true;
						}else {
							p.openInventory(target.getEnderChest());
							p.sendMessage(ChatColor.WHITE + "Rucksack von " + target.getName() + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Du verschaffst dir einen Überblick des Inhaltes*");
							return true;
						}
					}else {
						p.openInventory(p.getEnderChest());
						return true;
					}
				}else {
					p.openInventory(p.getEnderChest());
					return true;
				}
			//}return false;
		}return false;
	}

	
}
