import gregtech.api.gui.GuiTextures
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity
import gregtech.api.recipes.RecipeMap
import gregtech.api.recipes.RecipeMapBuilder
import gregtech.api.recipes.builders.SimpleRecipeBuilder
import gregtech.client.renderer.texture.Textures
import gregtech.core.sound.GTSoundEvents
import net.minecraft.util.ResourceLocation

class MetaTileEntityVialProcessor extends SimpleMachineMetaTileEntity {

    public static final RecipeMap<SimpleRecipeBuilder> VIAL_PROCESSOR_RECIPES = new RecipeMapBuilder<>("vial_processor",
            new SimpleRecipeBuilder().EUt(16).duration(4))
            .itemInputs(1)
            .itemOutputs(4)
            .progressBar(GuiTextures.PROGRESS_BAR_EXTRACT)
            .sound(GTSoundEvents.COMPRESSOR)
            .build()

    MetaTileEntityVialProcessor(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, VIAL_PROCESSOR_RECIPES, Textures.EXTRACTOR_OVERLAY, tier, true)
    }
}