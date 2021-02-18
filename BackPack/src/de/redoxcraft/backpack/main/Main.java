package de.redoxcraft.backpack.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.redoxcraft.backpack.commands.OpenBackpackCommand;

public class Main extends JavaPlugin {

	public void onEnable() {
		System.out.println(this.getDescription().getName() + " " + this.getDescription().getVersion() + " geladen.");
		
		getCommand("rucksack").setExecutor(new OpenBackpackCommand());
	}
	
}
