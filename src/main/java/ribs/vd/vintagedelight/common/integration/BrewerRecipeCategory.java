package ribs.vd.vintagedelight.common.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import ribs.vd.vintagedelight.VintageDelight;
import ribs.vd.vintagedelight.common.block.VDBlocks;
import ribs.vd.vintagedelight.common.recipe.BrewerRecipe;
import java.util.List;

public class BrewerRecipeCategory implements IRecipeCategory<BrewerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(VintageDelight.MOD_ID, "brewing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(VintageDelight.MOD_ID, "textures/gui/brewer_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public BrewerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(VDBlocks.BREWER.get()));
    }

    @Override
    public RecipeType<BrewerRecipe> getRecipeType() {
        return JEITutorialModPlugin.INFUSION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Brewer");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BrewerRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 22).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 41).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 60).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 81, 22).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 31, 15)

                .addIngredients(ForgeTypes.FLUID_STACK, List.of(recipe.getFluid()))
                .setFluidRenderer(1000, true, 16, 61);


        builder.addSlot(RecipeIngredientRole.OUTPUT, 100, 60).addItemStack(recipe.getResultItem());
    }

}
