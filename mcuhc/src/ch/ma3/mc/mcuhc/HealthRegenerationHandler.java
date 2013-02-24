package ch.ma3.mc.mcuhc;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class HealthRegenerationHandler implements Listener {
	@EventHandler
	public void onHealthRegen(EntityRegainHealthEvent event) {
		if (event.getRegainReason() == RegainReason.SATIATED) {
			event.setCancelled(true);
		}
	}
}
