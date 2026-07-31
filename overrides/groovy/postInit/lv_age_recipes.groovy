import gregtech.api.GTValues
import gregtech.api.recipes.RecipeMaps
import gregtech.api.unification.OreDictUnifier
import gregtech.api.unification.material.MarkerMaterials
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.common.metatileentities.MetaTileEntities

// farming station
crafting.removeByOutput(item('enderio:block_farm_station'))
RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
        .circuitMeta(0)
        .inputs(item('enderio:item_material', 41), item('minecraft:diamond_hoe'))
        .input(OrePrefix.circuit, MarkerMaterials.Tier.LV, 2)
        .input(MetaTileEntities.HULL[GTValues.LV])
        .outputs(item('enderio:block_farm_station'))
        .EUt(30).duration(160)
        .buildAndRegister()

// tool casing
crafting.addShapeless(item('thermalfoundation:material', 640), [item('actuallyadditions:item_misc', 16)])
// item dislocator
crafting.removeByOutput(item('draconicevolution:magnet'))
RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
        .input(OrePrefix.circuit, MarkerMaterials.Tier.LV, 2)
        .input(OrePrefix.dust, Materials.Redstone, 2)
        .inputs(item('enderio:item_alloy_ingot') * 4)
        .outputs(item('draconicevolution:magnet'))
        .EUt(28).duration(100)
        .buildAndRegister()
// Z-logic controller
crafting.shapedBuilder()
        .row('SIS')
        .row('DZD')
        .row('DRD')
        .key('S', item('enderio:item_alloy_ingot', 7))
        .key('I', OreDictUnifier.get(OrePrefix.ingot, Materials.Iron))
        .key('D', OreDictUnifier.get(OrePrefix.dust, Materials.Silicon))
        .key('Z', item('minecraft:skull', 2))
        .key('R', OreDictUnifier.get(OrePrefix.block, Materials.Redstone))
        .output(item('enderio:item_material', 41))
        .register()