package com.sekwah.advancedportals.portalcontrolls;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.sekwah.advancedportals.AdvancedPortalsPlugin;
import com.sekwah.advancedportals.ConfigAccessor;

public class Portal {
	
	private static AdvancedPortalsPlugin plugin;
	
	public static Object[] Portals;
	
	public static Object[] pos1;
	
	public static Object[] pos2;
	
    public Portal(AdvancedPortalsPlugin plugin) {
        Portal.plugin = plugin;
        Portal.loadPortals();
    }
    
	/**
	 * This can be used to move the get keys to different sections
	 * 
	 * ConfigurationSection section = config.getSection("sectionname");
	 * 
	 * section.getKeys(false);
	 * 
	 */
    
    public static void loadPortals(){
    	
    	ConfigAccessor config = new ConfigAccessor(plugin, "Portals.yml");
    	Set<String> PortalSet = config.getConfig().getKeys(false);
    	Portals = PortalSet.toArray();
    	
    	for(Object portal: Portals){
    		portal.toString();
    		
    	}
    	
    }
    
	@SuppressWarnings("deprecation")
	public static void create(Location pos1, Location pos2 , String name, String destination , Material triggerBlockId) {
		ConfigAccessor config = new ConfigAccessor(plugin, "Portals.yml");
		
		config.getConfig().set(name + ".world", pos1.getWorld().getName());
		config.getConfig().set(name + ".hastriggerblock", true);
		
		config.getConfig().set(name + ".triggerblock", triggerBlockId.toString());
		
		config.getConfig().set(name + ".destination", destination);
		
		config.getConfig().set(name + ".pos1.X", pos1.getX());
		config.getConfig().set(name + ".pos1.Y", pos1.getY());
		config.getConfig().set(name + ".pos1.Z", pos1.getZ());
		
		config.getConfig().set(name + ".pos2.X", pos2.getX());
		config.getConfig().set(name + ".pos2.Y", pos2.getY());
		config.getConfig().set(name + ".pos2.Z", pos2.getZ());
		
		config.saveConfig();
		
		loadPortals();
	}
	
	public static void create(Location pos1, Location pos2, String name, String destination) { // add stuff for destination names or coordinates
		ConfigAccessor config = new ConfigAccessor(plugin, "Portals.yml");
		
		config.getConfig().set(name + ".world", pos1.getWorld().getName());
		config.getConfig().set(name + ".hastriggerblock", false);
		
		config.getConfig().set(name + ".destination", destination);
		
		config.getConfig().set(name + ".pos1.X", pos1.getX());
		config.getConfig().set(name + ".pos1.Y", pos1.getY());
		config.getConfig().set(name + ".pos1.Z", pos1.getZ());
		
		config.getConfig().set(name + ".pos2.X", pos2.getX());
		config.getConfig().set(name + ".pos2.Y", pos2.getY());
		config.getConfig().set(name + ".pos2.Z", pos2.getZ());
		
		loadPortals();
	}
	
	public static void redefine(Location pos1, Location pos2, String name){
		
		ConfigAccessor config = new ConfigAccessor(plugin, "Portals.yml");
		
		config.getConfig().set(name + ".pos1.X", pos1.getX());
		config.getConfig().set(name + ".pos1.Y", pos1.getY());
		config.getConfig().set(name + ".pos1.Z", pos1.getZ());
		
		config.getConfig().set(name + ".pos2.X", pos2.getX());
		config.getConfig().set(name + ".pos2.Y", pos2.getY());
		config.getConfig().set(name + ".pos2.Z", pos2.getZ());
		
		config.saveConfig();
		
		loadPortals();
		
	}
	
	public static void remove(String name){
		ConfigAccessor config = new ConfigAccessor(plugin, "Portals.yml");
		
		config.getConfig().set(name + ".world", null);
		config.getConfig().set(name + ".hastriggerblock", null);
		
		config.getConfig().set(name + ".pos1.X", null);
		config.getConfig().set(name + ".pos1.Y", null);
		config.getConfig().set(name + ".pos1.Z", null);
		
		config.getConfig().set(name + ".pos2.X", null);
		config.getConfig().set(name + ".pos2.Y", null);
		config.getConfig().set(name + ".pos2.Z", null);
		
		config.saveConfig();
		
		loadPortals();
	}
	
	

}
