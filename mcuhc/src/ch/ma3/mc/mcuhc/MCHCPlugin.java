package ch.ma3.mc.mcuhc;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MCHCPlugin extends JavaPlugin {

	private Logger log;

	@Override
	public void onEnable() {
		log = getLogger();
		log.info("onEnable has been invoked!");

		ChainMailRecipes.addChainMailRecipesToServer(getServer());

	}

	@Override
	public void onDisable() {
		log = getLogger();
		log.info("onDisable has been invoked!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("pos")) {
			// doSomething
			return true;
		}
		return false;
	}

}
