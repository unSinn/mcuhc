package ch.ma3.mc.mcuhc;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class ChainMailRecipes {

	private static Server server;

	static void addChainMailRecipesToServer(Server s) {
		server = s;

		s.getLogger().info("Adding Chainmail recipes.");
		
		addChainBoots();
		addChainChest();
		addChainLeggins();
		addChainHelmet();
	}

	private static void addChainBoots() {
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(
				Material.CHAINMAIL_BOOTS, 1));
		recipe.shape(new String[] { "L L", "I I", "   " });
		recipe.setIngredient('L', Material.LEATHER);
		recipe.setIngredient('I', Material.IRON_INGOT);
		server.addRecipe(recipe);
	}

	private static void addChainChest() {
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(
				Material.CHAINMAIL_CHESTPLATE, 1));
		recipe.shape(new String[] { "W W", "IWI", "WLW" });
		recipe.setIngredient('W', Material.WOOL);
		recipe.setIngredient('L', Material.LEATHER);
		recipe.setIngredient('I', Material.IRON_INGOT);
		server.addRecipe(recipe);
	}

	private static void addChainLeggins() {
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(
				Material.CHAINMAIL_LEGGINGS, 1));
		recipe.shape(new String[] { "LWL", "I I", "W W" });
		recipe.setIngredient('L', Material.LEATHER);
		recipe.setIngredient('W', Material.WOOL);
		recipe.setIngredient('I', Material.IRON_INGOT);
		server.addRecipe(recipe);
	}

	private static void addChainHelmet() {
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(
				Material.CHAINMAIL_HELMET, 1));
		recipe.shape(new String[] { "ILI", "W W", "   " });
		recipe.setIngredient('W', Material.WOOL);
		recipe.setIngredient('L', Material.LEATHER);
		recipe.setIngredient('I', Material.IRON_INGOT);
		server.addRecipe(recipe);
	}

}
