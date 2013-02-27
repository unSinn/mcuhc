package ch.ma3.mc.mcuhc;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnHandler implements Listener {

	class Point {
		public double x;
		public double y;
	}

	private static final int MAX_DISTANCE = 1000;
	private static final int MIN_DISTANCE = 500;

	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Point newspawnPoint = calcRespawnPosition(player);
		player.teleport(new Location(player.getWorld(), newspawnPoint.x,
				newspawnPoint.y, 100));
	}

	private Point calcRespawnPosition(Player player) {
		Point spawnPoint = new Point();
		spawnPoint.x = player.getLocation().getX();
		spawnPoint.y = player.getLocation().getY();

		Point awayPoint = new Point();

		while (!inOrbit(spawnPoint, awayPoint)) {
			awayPoint.x = spawnPoint.x + Math.random() * MAX_DISTANCE * 2
					- MAX_DISTANCE;
			awayPoint.y = spawnPoint.y + Math.random() * MAX_DISTANCE * 2
					- MAX_DISTANCE;
		}

		return awayPoint;
	}

	private boolean inOrbit(Point a, Point b) {
		if (distance(a, b) > MIN_DISTANCE && distance(a, b) < MAX_DISTANCE) {
			return true;
		}
		return false;
	}

	private double distance(Point a, Point b) {
		double dx = a.x - b.x;
		double dy = a.y - b.y;

		return Math.sqrt(dx * dx + dy * dy);
	}

}
