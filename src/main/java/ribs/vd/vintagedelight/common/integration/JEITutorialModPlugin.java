package ribs.vd.vintagedelight.common.integration;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import ribs.vd.vintagedelight.VintageDelight;
import ribs.vd.vintagedelight.common.recipe.BrewerRecipe;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEITutorialModPlugin implements IModPlugin {
    public static RecipeType<BrewerRecipe> INFUSION_TYPE =
            new RecipeType<>(BrewerRecipeCategory.UID, BrewerRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(VintageDelight.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                BrewerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<BrewerRecipe> recipesBrewing = rm.getAllRecipesFor(BrewerRecipe.Type.INSTANCE);
        registration.addRecipes(INFUSION_TYPE, recipesBrewing);
    }


}