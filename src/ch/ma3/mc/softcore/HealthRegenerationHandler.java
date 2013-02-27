package ch.ma3.mc.softcore;

import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class HealthRegenerationHandler implements Listener {

	public HealthRegenerationHandler(Server server) {
		server.getLogger()
				.info("Players no longer regenerate Health if they have a full hunger bar.");
	}

	@EventHandler
	public void onHealthRegen(EntityRegainHealthEvent event) {
		if (event.getRegainReason() == RegainReason.SATIATED) {
			event.setCancelled(true);
		}
	}
}
