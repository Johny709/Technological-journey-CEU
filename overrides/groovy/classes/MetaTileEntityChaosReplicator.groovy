import com.fulltrix.gcyl.materials.GCYLMaterials
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
import gregtech.common.blocks.MetaBlocks
import gregtech.core.sound.GTSoundEvents
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class MetaTileEntityChaosReplicator extends RecipeMapMultiblockController {

    public static final RecipeMap<SimpleRecipeBuilder> CHAOS_REPLICATOR_RECIPES = new RecipeMapBuilder<>("chaos_replicator",
            new SimpleRecipeBuilder())
            .itemInputs(4)
            .itemOutputs(2)
            .fluidInputs(1)
            .progressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            .sound(GTSoundEvents.BATH)
            .build()

    MetaTileEntityChaosReplicator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, CHAOS_REPLICATOR_RECIPES)
    }

    @Override
    MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityChaosReplicator(this.metaTileEntityId)
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCCCC", "CXXXXXC", "CGGCGGC", "CGGCGGC", "CGGCGGC", "CGGGGGC", "CGGGGGC", "CXXXXXC", "CCCCCCC")
                .aisle("CCCCCCC", "XOOOOOX", "GN###NG", "GN###NG", "GN#A#NG", "GN###NG", "GN###NG", "XOOOOOX", "CCCCCCC")
                .aisle("CCCCCCC", "XOOOOOX", "G#OOO#G", "G#####G", "G#####G", "G#####G", "G#OOO#G", "XOOOOOX", "CCCCCCC")
                .aisle("CCCCCCC", "XOOOOOX", "C#OOO#C", "C##O##C", "CA#E#AC", "G##O##G", "G#OOO#G", "XOOOOOX", "CCCCCCC")
                .aisle("CCCCCCC", "XOOOOOX", "G#OOO#G", "G#####G", "G#####G", "G#####G", "G#OOO#G", "XOOOOOX", "CCCCCCC")
                .aisle("CCCCCCC", "XOOOOOX", "GN###NG", "GN###NG", "GN#A#NG", "GN###NG", "GN###NG", "XOOOOOX", "CCCCCCC")
                .aisle("CCCCCCC", "CXXSXXC", "CGGCGGC", "CGGCGGC", "CGGCGGC", "CGGGGGC", "CGGGGGC", "CXXXXXC", "CCCCCCC")
                .where('S' as char, this.selfPredicate())
                .where('C' as char, states(blockstate('technological_journey:chaoticcasing')))
                .where('X' as char, states(blockstate('technological_journey:chaoticcasing'))
                        .or(autoAbilities(true, true, true, true, true, false, false)))
                .where('O' as char, states(blockstate('draconicevolution:infused_obsidian')))
                .where('G' as char, states(blockstate('enderio:block_fused_quartz')))
                .where('N' as char, states(MetaBlocks.FRAMES.get(GCYLMaterials.EnrichedNaquadahAlloy).getStateFromMeta(1)))
                .where('A' as char, states(blockstate('draconicevolution:draconic_block')))
                .where('E' as char, states(MetaBlocks.FRAMES.get(GCYLMaterials.Chaos).getStateFromMeta(15)))
                .where('#' as char, air())
                .build()
    }

    @Override
    @SideOnly(Side.CLIENT)
    ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return TJTextures.CHAOS_CASING
    }
}