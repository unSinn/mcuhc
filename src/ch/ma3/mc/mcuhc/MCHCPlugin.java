package ch.ma3.mc.mcuhc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MCHCPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		addChainMailRecipes();
		modifyHealingRecipes();
		preventHealthRegeneration();
		showPlayerHealthInTab();
		telePortawayAfterDistance();
	}

	private void telePortawayAfterDistance() {
		getServer().getPluginManager().registerEvents(new RespawnHandler(),
				this);
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}

	private void showPlayerHealthInTab() {
		getServer().getPluginManager().registerEvents(new TabHealthHandler(),
				this);
	}

	private void addChainMailRecipes() {
		getLogger().info("Adding Chain Mail recipes");
		ChainMailRecipes.addChainMailRecipesToServer(getServer());
	}

	private void preventHealthRegeneration() {
		getServer().getPluginManager().registerEvents(
				new HealthRegenerationHandler(getServer()), this);
	}

	private void modifyHealingRecipes() {
		RecipeManager.modifyHealingRecipes(getServer());
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
