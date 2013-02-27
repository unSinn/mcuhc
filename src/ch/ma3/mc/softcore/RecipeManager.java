package ch.ma3.mc.softcore;

import java.util.Iterator;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeManager {

	public static void modifyHealingRecipes(Server server) {
		server.getLogger().info("Removing original recipes.");
		removeOriginalRecipes(server);
		addGoldIngotGoldenAppleRecipe(server);
		addGoldIngotGlisteringMelonRecipe(server);
	}

	private static void addGoldIngotGoldenAppleRecipe(Server server) {
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(
				Material.GOLDEN_APPLE, 1));
		recipe.shape(new String[] { "III", "IAI", "III" });
		recipe.setIngredient('I', Material.GOLD_INGOT);
		recipe.setIngredient('A', Material.APPLE);
		server.addRecipe(recipe);
	}

	private static void addGoldIngotGlisteringMelonRecipe(Server server) {
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(
				Material.getMaterial(382), 1));
		recipe.shape(new String[] { "III", "IMI", "III" });
		recipe.setIngredient('I', Material.GOLD_INGOT);
		recipe.setIngredient('M', Material.getMaterial(360));
		server.addRecipe(recipe);
	}

	private static void removeOriginalRecipes(Server server) {
		Iterator<Recipe> recipes = server.recipeIterator();
		while (recipes.hasNext()) {
			Recipe recipe = recipes.next();
			ItemStack result = recipe.getResult();

			if (isGoldenApple(result)) {
				server.getLogger().info("Golden Apple removed.");
				recipes.remove();
			}

			if (isGlisteringMelon(result)) {
				server.getLogger().info("Glistering Melon removed.");
				recipes.remove();
			}
		}
	}

	private static boolean isGoldenApple(ItemStack stack) {
		return stack.getType().getId() == Material.GOLDEN_APPLE.getId();
	}

	private static boolean isGlisteringMelon(ItemStack stack) {
		return stack.getType().getId() == 382; // Gl
	}
}
