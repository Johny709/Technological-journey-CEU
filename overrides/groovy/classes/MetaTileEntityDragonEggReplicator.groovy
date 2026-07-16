import gregtech.api.gui.GuiTextures
import gregtech.api.metatileentity.MetaTileEntity
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity
import gregtech.api.metatileentity.multiblock.IMultiblockPart
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController
import gregtech.api.pattern.BlockPattern
import gregtech.api.pattern.FactoryBlockPattern
import gregtech.api.recipes.RecipeMap
import gregtech.api.recipes.RecipeMapBuilder
import gregtech.api.recipes.builders.SimpleRecipeBuilder
import gregtech.client.renderer.ICubeRenderer
import gregtech.core.sound.GTSoundEvents
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class MetaTileEntityDragonEggReplicator extends RecipeMapMultiblockController {

    public static final RecipeMap<SimpleRecipeBuilder> DRAGON_EGG_REPLICATOR_RECIPES = new RecipeMapBuilder<>("dragon_egg_replicator",
            new SimpleRecipeBuilder())
            .itemInputs(2)
            .itemOutputs(3)
            .fluidInputs(1)
            .fluidOutputs(1)
            .progressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            .sound(GTSoundEvents.BATH)
            .build()

    MetaTileEntityDragonEggReplicator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, DRAGON_EGG_REPLICATOR_RECIPES)
    }

    @Override
    MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityDragonEggReplicator(this.metaTileEntityId)
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "XXX", "XXX")
                .aisle("XXX", "X#X", "XXX")
                .aisle("XXX", "XSX", "XXX")
                .where('S', this.selfPredicate())
                .where('X' as char, states(blockstate('technologcial_journey:awakenedcasing')).setMinGlobalLimited(9)
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('#' as char, air())
                .build()
    }

    @Override
    @SideOnly(Side.CLIENT)
    ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return TJTextures.AWAKENED_CASING
    }
}