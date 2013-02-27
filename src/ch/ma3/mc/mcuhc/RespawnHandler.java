package ch.ma3.mc.mcuhc;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnHandler implements Listener {

	private static final int MAX_DISTANCE = 1000;
	private static final int MIN_DISTANCE = 500;

	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		calcRespawnPosition(player);
	}
	
	private Position calcRespawnPosition(Player player){
		Point spawnPoint;
		Point awayPoint;
		
		while(!inOrbit(spawnPoint, awayPoint)){
			spawnPoint.x = spawnPoint.x + Math.random() * MAX_DISTANCE;
			spawnPoint.y = spawnPoint.y + Math.random() * MAX_DISTANCE;
		}
	}

}
