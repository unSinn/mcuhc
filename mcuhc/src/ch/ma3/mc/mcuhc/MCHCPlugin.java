package ch.ma3.mc.mcuhc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MCHCPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		addChainMailRecipes();
		preventHealthRegeneration();
	}

	private void addChainMailRecipes() {
		getLogger().info("Adding Chain Mail recipes");
		ChainMailRecipes.addChainMailRecipesToServer(getServer());
	}

	private void preventHealthRegeneration() {
		getLogger()
				.info("Players no longer regenerate Health if they have a full hunger bar.");
		getServer().getPluginManager().registerEvents(
				new HealthRegenerationHandler(), this);
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
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
