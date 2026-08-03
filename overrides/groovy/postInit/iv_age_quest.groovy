import classes.TJMaterials
import com.fulltrix.gcyl.materials.GCYLMaterials
import gregicality.multiblocks.api.recipes.GCYMRecipeMaps
import gregtech.api.GTValues
import gregtech.api.recipes.RecipeMaps
import gregtech.api.unification.OreDictUnifier
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.common.items.MetaItems
import gregtech.common.metatileentities.MetaTileEntities

// memory chest (extended)
crafting.shapedBuilder()
        .row(' C ')
        .row(' H ')
        .row(' C ')
        .key('C', ore('circuitZpm'))
        .key('H', item('enderutilities:storage_0', 5))
        .output(item('enderutilities:storage_0', 6))
        .replace()
        .register()
// memory card (items) 12 B
crafting.shapedBuilder()
        .row('   ')
        .row('PCP')
        .row('PHP')
        .key('P', item('enderio:item_alloy_ingot', 5))
        .key('C', ore('circuitZpm'))
        .key('H', MetaTileEntities.QUANTUM_CHEST[1].getStackForm())
        .output(item('enderutilities:enderpart', 54))
        .replace()
        .register()
// mob grinder
crafting.shapedBuilder()
        .row('PBP')
        .row('BHF')
        .row('PBP')
        .key('P', OreDictUnifier.get(OrePrefix.plate, Materials.NaquadahAlloy))
        .key('B', OreDictUnifier.get(OrePrefix.turbineBlade, Materials.Osmium))
        .key('H', MetaTileEntities.HULL[GTValues.IV].getStackForm())
        .key('F', MetaItems.FIELD_GENERATOR_IV.getStackForm())
        .output(item('draconicevolution:grinder'))
        .replace()
        .register()
// advanced dislocator
RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
        .inputs(item('draconicevolution:dislocator'))
        .input(OrePrefix.gem, Materials.EnderEye, 7)
        .input(OrePrefix.gem, Materials.EnderPearl, 3)
        .input(MetaItems.QUANTUM_EYE)
        .fluidInputs(GCYLMaterials.Draconium.getFluid(576))
        .outputs(item('draconicevolution:dislocator_advanced'))
        .EUt(GTValues.V[GTValues.LuV]).duration(200)
        .buildAndRegister()
// molten stellar alloy
GCYMRecipeMaps.ALLOY_BLAST_RECIPES.recipeBuilder()
        .blastFurnaceTemp(8100)
        .input(OrePrefix.dust, TJMaterials.StarMetalAlloy, 5)
        .input(OrePrefix.dust, Materials.Americium, 4)
        .input(OrePrefix.dust, Materials.NetherStar)
        .fluidOutputs(TJMaterials.StellarAlloy.getFluid(1440))
        .EUt(2430).duration(420)
        .buildAndRegister()
// stellar alloy ingot
RecipeMaps.FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
        .notConsumable(MetaItems.SHAPE_MOLD_INGOT)
        .fluidInputs(TJMaterials.StellarAlloy.getFluid(144))
        .outputs(item('enderio:item_alloy_endergy_ingot', 3))
        .EUt(8).duration(20)
        .buildAndRegister()