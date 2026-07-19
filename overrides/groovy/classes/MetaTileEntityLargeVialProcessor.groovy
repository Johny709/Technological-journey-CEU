import gregtech.api.GTValues
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
import gregtech.api.unification.material.Materials
import gregtech.client.renderer.ICubeRenderer
import gregtech.client.renderer.texture.Textures
import gregtech.common.blocks.BlockBoilerCasing
import gregtech.common.blocks.BlockMultiblockCasing
import gregtech.common.blocks.BlockTurbineCasing
import gregtech.common.blocks.MetaBlocks
import gregtech.core.sound.GTSoundEvents
import groovyjarjarantlr4.v4.runtime.misc.NotNull
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class MetaTileEntityLargeVialProcessor extends RecipeMapMultiblockController {

    public static final RecipeMap<SimpleRecipeBuilder> LARGE_VIAL_PROCESSOR_RECIPES = new RecipeMapBuilder<>("large_vial_processor",
            new SimpleRecipeBuilder().EUt(GTValues.VA[GTValues.LuV]).duration(20))
            .itemInputs(1)
            .itemOutputs(14)
            .fluidOutputs(1)
            .progressBar(GuiTextures.PROGRESS_BAR_EXTRACT)
            .sound(GTSoundEvents.COMPRESSOR)
            .build()

    MetaTileEntityLargeVialProcessor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, LARGE_VIAL_PROCESSOR_RECIPES)
    }

    @Override
    MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityLargeVialProcessor(this.metaTileEntityId)
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXXXX", "P   P", "P   P", "P   P", "XXXXX")
                .aisle("XTTTX", " OGO ", " OGO ", " OGO ", "XTTTX")
                .aisle("XTETX", " GEG ", " GEG ", " GEG ", "XTETX")
                .aisle("XTTTX", " OGO ", " OGO ", " OGO ", "XTTTX")
                .aisle("XXSXX", "P   P", "P   P", "P   P", "XXXXX")
                .where('S' as char, this.selfPredicate())
                .where('X' as char, states(blockstate('technological_journey:soulcasing')))
                .where('T' as char, states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE))
                        .or(autoAbilities(true, true, true, true, false, true, false)))
                .where('P' as char, states(MetaBlocks.FRAMES.get(Materials.Protactinium).getStateFromMeta(6)))
                .where('O' as char, states(MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX)))
                .where('G' as char, states(MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING)))
                .where('E' as char, states(blockstate('enderio:block_alloy', 8)))
                .build()
    }

    @Override
    @SideOnly(Side.CLIENT)
    ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return TJTextures.SOUL_CASING
    }

    @NotNull
    @Override
    @SideOnly(Side.CLIENT)
    protected ICubeRenderer getFrontOverlay() {
        return Textures.EXTRACTOR_OVERLAY
    }
}