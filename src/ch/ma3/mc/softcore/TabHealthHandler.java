package ch.ma3.mc.softcore;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class TabHealthHandler implements Listener {

	class UpdatePlayerHealthAfterDeath extends BukkitRunnable {

		private PlayerRespawnEvent event;

		public UpdatePlayerHealthAfterDeath(PlayerRespawnEvent event) {
			this.event = event;
		}

		public void run() {
			updatePlayerList(event.getPlayer(), MAXHEALTH);
		}

	}

	private static float HEART_DIVIDER = 2;
	private static int MAXHEALTH = 20;

	private Plugin plugin;

	public TabHealthHandler(Plugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onEntityDamaged(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player p = ((Player) event.getEntity()).getPlayer();

			if (!playerDies(event, p)) {
				updatePlayerList(p, p.getHealth() - event.getDamage());
			}
		}
	}

	private boolean playerDies(EntityDamageEvent event, Player p) {
		return p.getHealth() - event.getDamage() <= 0;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		updatePlayerList(event);
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		new UpdatePlayerHealthAfterDeath(event).runTaskLater(plugin, 20);
	}

	private void updatePlayerList(PlayerEvent event) {
		Player p = event.getPlayer();
		updatePlayerList(p, p.getHealth());
	}

	private void updatePlayerList(Player p, int newhealth) {
		p.setPlayerListName(p.getName() + " - " + (newhealth / HEART_DIVIDER));
	}
}
