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
import gregtech.common.blocks.BlockBoilerCasing
import gregtech.common.blocks.BlockMultiblockCasing
import gregtech.common.blocks.MetaBlocks
import gregtech.core.sound.GTSoundEvents
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class MetaTileEntityLargePoweredSpawner extends RecipeMapMultiblockController {

    public static final RecipeMap<SimpleRecipeBuilder> LARGE_POWERED_SPAWNER_RECIPES = new RecipeMapBuilder<>("large_powered_spawner",
            new SimpleRecipeBuilder())
            .itemInputs(2)
            .itemOutputs(1)
            .fluidInputs(1)
            .progressBar(GuiTextures.PROGRESS_BAR_CANNER)
            .sound(GTSoundEvents.COMPRESSOR)
            .build()

    MetaTileEntityLargePoweredSpawner(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, LARGE_POWERED_SPAWNER_RECIPES)
    }

    @Override
    MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityLargePoweredSpawner(this.metaTileEntityId)
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXXXX", "P   P", "P   P", "P   P", "XXXXX")
                .aisle("XCCCX", " TMT ", " TMT ", " TMT ", "XGGGX")
                .aisle("XCCCX", " MBM ", " MBM ", " MBM ", "XGGGX")
                .aisle("XCCCX", " TMT ", " TMT ", " TMT ", "XGGGX")
                .aisle("XXSXX", "P   P", "P   P", "P   P", "XXXXX")
                .where('S' as char, this.selfPredicate())
                .where('C' as char, states(blockstate('technological_journey:soulcasing')))
                .where('X' as char, states(blockstate('technological_journey:soulcasing'))
                        .or(autoAbilities(true, true, true, true, true, false, false)))
                .where('P' as char, states(MetaBlocks.FRAMES.get(Materials.Protactinium).getStateFromMeta(6)))
                .where('T' as char, states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE)))
                .where('M' as char, states(blockstate('enderio:block_decoration1')))
                .where('B' as char, states(blockstate('enderio:block_alloy', 8)))
                .where('G' as char, states(MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING)))
                .build()
    }

    @Override
    @SideOnly(Side.CLIENT)
    ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return TJTextures.SOUL_CASING
    }
}