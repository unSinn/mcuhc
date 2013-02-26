package ch.ma3.mc.mcuhc;

import java.util.Iterator;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeManager {

	public static void modifyHealingRecipes(Server server) {
		server.getLogger().info("Removing original recipes.");
		removeOriginalGoldenAppleRecipe(server);
		addGoldIngotGoldenAppleRecipe(server);
	}

	private static void addGoldIngotGoldenAppleRecipe(Server server) {
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(
				Material.GOLDEN_APPLE, 1));
		recipe.shape(new String[] { "III", "IAI", "III" });
		recipe.setIngredient('I', Material.GOLD_INGOT);
		recipe.setIngredient('A', Material.APPLE);
		server.addRecipe(recipe);
	}

	private static void removeOriginalGoldenAppleRecipe(Server server) {
		Iterator<Recipe> recipes = server.recipeIterator();
		while (recipes.hasNext()) {
			Recipe recipe = recipes.next();
			ItemStack result = recipe.getResult();

			if (isGoldenApple(result)) {
				server.getLogger().info("Golden Apple removed.");
				recipes.remove();
			}
		}
	}

	private static boolean isGoldenApple(ItemStack stack) {
		return stack.getType().getId() == Material.GOLDEN_APPLE.getId();
	}
}
