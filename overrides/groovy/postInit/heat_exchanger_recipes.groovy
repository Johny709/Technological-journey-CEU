
import classes.MetaTileEntityHeatExchanger
import classes.TJMetaTileEntities
import com.fulltrix.gcyl.materials.GCYLNuclearMaterials
import gregicality.multiblocks.common.block.GCYMMetaBlocks
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing
import gregtech.api.recipes.RecipeMaps
import gregtech.api.unification.OreDictUnifier
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.common.metatileentities.MetaTileEntities

def heatExchangerRecipes = MetaTileEntityHeatExchanger.HEAT_EXCHANGER_RECIPES
def pahoehoeLava = content.createFluid('pahoehoe_lava') // TODO fix pahoehoe fluid texture
        .setColor(0x964B00)
        .setDefaultTexture()
        .isFinite()
        .register()

// heat exchanger
crafting.shapedBuilder()
        .row('PCP')
        .row('CBC')
        .row('PCP')
        .key('P', OreDictUnifier.get(OrePrefix.plate, GCYLNuclearMaterials.ReactorSteel))
        .key('C', GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.HIGH_TEMPERATURE_CASING))
        .key('B', MetaTileEntities.LARGE_STEEL_BOILER.getStackForm())
        .output(TJMetaTileEntities.HEAT_EXCHANGER.getStackForm())
        .register()
// steam, pahoehoe lava
heatExchangerRecipes.recipeBuilder()
        .fluidInput(Materials.Water.getFluid(), 1000)
        .fluidInput(Materials.Lava.getFluid(), 10000)
        .fluidOutputs(Materials.Steam.getFluid(), 172800)
        .fluidOutputs(pahoehoeLava, 1000)
        .duration(20)
        .buildAndRegister()
// obsidian, sulfur dust, carbon dust
RecipeMaps.ELECTROLYZER_RECIPES.recipeBuilder()
        .fluidInput(pahoehoeLava, 10000)
        .outputs(item('minecraft:obsidian'))
        .output(OrePrefix.dust, Materials.Sulfur)
        .output(OrePrefix.dust, Materials.Carbon)
        .EUt(7000).duration(20)
        .buildAndRegister()