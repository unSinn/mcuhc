package ch.ma3.mc.softcore;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnHandler implements Listener {

	class Point {
		public double x;
		public double z;
	}

	private static final int MAX_DISTANCE = 1000;
	private static final int MIN_DISTANCE = 500;
	private Server server;
	private World defaultWorld;

	public RespawnHandler(Server server) {
		this.server = server;
		defaultWorld = server.getWorlds().get(0);
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Location oldSpawnLocation = player.getWorld().getSpawnLocation();
		Point newspawnPoint = calcRespawnPosition(oldSpawnLocation);

		int height = (int) defaultWorld.getHighestBlockYAt(
				(int) newspawnPoint.x, (int) newspawnPoint.z);
		event.setRespawnLocation(new Location(server.getWorlds().get(0),
				newspawnPoint.x, height, newspawnPoint.z));
	}

	private Point calcRespawnPosition(Location location) {
		Point spawnPoint = new Point();
		spawnPoint.x = location.getX();
		spawnPoint.z = location.getY();

		Point awayPoint = new Point();

		while (!inOrbit(spawnPoint, awayPoint)) {
			awayPoint.x = spawnPoint.x + Math.random() * MAX_DISTANCE * 2
					- MAX_DISTANCE;
			awayPoint.z = spawnPoint.z + Math.random() * MAX_DISTANCE * 2
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
		double dy = a.z - b.z;

		return Math.sqrt(dx * dx + dy * dy);
	}

}
