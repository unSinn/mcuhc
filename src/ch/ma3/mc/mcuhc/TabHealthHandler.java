package ch.ma3.mc.mcuhc;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class TabHealthHandler implements Listener {

	private static float HEART_DIVIDER = 2;
	private static int MAXHEALTH = 20;

	@EventHandler
	public void onEntityDamaged(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player p = ((Player) event.getEntity()).getPlayer();
			updatePlayerList(p, p.getHealth() - event.getDamage());

			// Old player stays in the list for some reason... ?
			if (playerDies(event, p)) {
				p.setPlayerListName("");
			}

		}
	}

	private boolean playerDies(EntityDamageEvent event, Player p) {
		return p.getHealth() - event.getDamage() < 0;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		updatePlayerList(event);
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		updatePlayerList(event.getPlayer(), MAXHEALTH);
	}

	private void updatePlayerList(PlayerEvent event) {
		Player p = event.getPlayer();
		updatePlayerList(p, p.getHealth());
	}

	private void updatePlayerList(Player p, int newhealth) {
		p.setPlayerListName(p.getName() + " - " + (newhealth / HEART_DIVIDER));
	}
}
