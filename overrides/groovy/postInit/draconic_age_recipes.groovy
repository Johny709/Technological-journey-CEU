import classes.TJMaterials
import com.fulltrix.gcyl.api.recipes.GCYLRecipeMaps
import com.fulltrix.gcyl.blocks.GCYLExplosive
import com.fulltrix.gcyl.blocks.GCYLMetaBlocks
import com.fulltrix.gcyl.item.GCYLCoreItems
import com.fulltrix.gcyl.materials.GCYLMaterials
import gregtech.api.GTValues
import gregtech.api.fluids.store.FluidStorageKeys
import gregtech.api.recipes.RecipeMaps
import gregtech.api.unification.material.MarkerMaterials
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.common.items.MetaItems

// hardened upgrade kit
crafting.removeByOutput(item('thermalfoundation:upgrade'))
RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
        .inputs(item('draconicevolution:draconic_core') * 10)
        .input(OrePrefix.plate, TJMaterials.StarMetalAlloy, 10)
        .input(OrePrefix.wireGtSingle, GCYLMaterials.UVSuperconductor, 64)
        .input(OrePrefix.plate, GCYLMaterials.TitanSteel, 64)
        .fluidInputs(Materials.SolderingAlloy.getFluid(1440), GCYLMaterials.Draconium.getFluid(1440))
        .outputs(item('thermalfoundation:upgrade'))
        .EUt(GTValues.VAOC[GTValues.MAX]).duration(100)
        .buildAndRegister()
// reinforced upgrade kit
crafting.removeByOutput(item('thermalfoundation:upgrade', 1))
RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
        .inputs(item('draconicevolution:wyvern_core') * 10)
        .input(OrePrefix.plate, GCYLMaterials.ProtoAdamantium, 64)
        .input(OrePrefix.wireGtSingle, GCYLMaterials.UHVSuperconductor, 64)
        .input(OrePrefix.plate, GCYLMaterials.Pikyonium, 64)
        .fluidInputs(Materials.SolderingAlloy.getFluid(1440), GCYLMaterials.Draconium.getFluid(1440),
                Materials.NaquadahAlloy.getFluid(1440))
        .outputs(item('thermalfoundation:upgrade', 1))
        .EUt(GTValues.VAOC[GTValues.MAX]).duration(100)
        .buildAndRegister()
// signalum upgrade kit
crafting.removeByOutput(item('thermalfoundation:upgrade', 2))
RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
        .inputs(item('draconicevolution:awakened_core') * 10)
        .input(OrePrefix.plate, Materials.Seaborgium, 64)
        .input(OrePrefix.wireGtSingle, GCYLMaterials.UEVSuperconductor, 64)
        .input(OrePrefix.plate, GCYLMaterials.BlackTitanium, 64)
        .fluidInputs(Materials.SolderingAlloy.getFluid(1440), GCYLMaterials.AwakenDraconium.getFluid(1440),
                GCYLMaterials.EnrichedNaquadahAlloy.getFluid(1440))
        .outputs(item('thermalfoundation:upgrade', 2))
        .EUt(GTValues.VAOC[GTValues.MAX]).duration(100)
        .buildAndRegister()
// resonant upgrade kit
crafting.removeByOutput(item('thermalfoundation:upgrade', 3))
RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
        .inputs(item('draconicevolution:chaotic_core') * 10)
        .input(OrePrefix.plate, Materials.Bohrium, 64)
        .input(OrePrefix.wireGtSingle, GCYLMaterials.UIVSuperconductor, 64)
        .input(OrePrefix.plate, GCYLMaterials.HDCS, 64)
        .fluidInputs(Materials.SolderingAlloy.getFluid(1440), GCYLMaterials.Chaos.getFluid(1440),
                GCYLMaterials.NaquadriaticTaranium.getFluid(1440))
        .outputs(item('thermalfoundation:upgrade', 3))
        .EUt(GTValues.VAOC[GTValues.MAX]).duration(100)
        .buildAndRegister()
// creative conversion kit
RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
        .inputs(item('thermalfoundation:upgrade'), item('thermalfoundation:upgrade', 1), item('thermalfoundation:upgrade', 2),
                item('thermalfoundation:upgrade', 3))
        .fluidInputs(GCYLMaterials.NaquadriaticTaranium.getFluid(1440), GCYLMaterials.CosmicNeutronium.getFluid(1440),
                GCYLMaterials.EnrichedNaquadahAlloy.getFluid(1440), Materials.NaquadahAlloy.getFluid(1440))
        .outputs(item('thermalfoundation:upgrade', 256))
        .EUt(GTValues.VAOC[GTValues.MAX]).duration(100)
        .buildAndRegister()
// chaotic energy core
RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
        .inputs(item('draconicevolution:chaotic_core') * 4)
        .input(OrePrefix.plate, GCYLMaterials.Chaos, 10)
        .input(OrePrefix.wireGtSingle, GCYLMaterials.Chaos, 10)
        .input(GCYLCoreItems.UNSTABLE_STAR)
        .fluidInputs(Materials.Redstone.getFluid(1440))
        .outputs(item('draconicadditions:chaotic_energy_core'))
        .EUt(GTValues.VAOC[GTValues.MAX]).duration(100)
        .buildAndRegister()
// chaos stabilizer core
crafting.shapedBuilder()
        .row('HSC')
        .row('DOD')
        .row('LBF')
        .key('H', item('draconicadditions:chaotic_helm'))
        .key('S', item('draconicadditions:chaotic_staff_of_power'))
        .key('C', item('draconicadditions:chaotic_chest'))
        .key('D', item('draconicevolution:draconic_energy_core'))
        .key('O', item('draconicadditions:chaotic_energy_core'))
        .key('L', item('draconicadditions:chaotic_legs'))
        .key('B', item('draconicadditions:chaotic_bow'))
        .key('F', item('draconicadditions:chaotic_boots'))
        .output(item('draconicadditions:chaos_stabilizer_core'))
        .register()
// chaotic core
RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
        .inputs(item('draconicevolution:awakened_core'), item('technological_journey:refinedchaoscrystal'))
        .input(OrePrefix.frameGt, GCYLMaterials.Quantum, 10)
        .input(OrePrefix.plate, GCYLMaterials.Cinobite, 10)
        .input(OrePrefix.plate, GCYLMaterials.AwakenDraconium, 10)
        .input(OrePrefix.plate, GCYLMaterials.Chaos, 10)
        .input(MetaItems.FIELD_GENERATOR_UXV)
        .input(MetaItems.SENSOR_UXV)
        .input(MetaItems.EMITTER_UXV)
        .input(OrePrefix.circuit, MarkerMaterials.Tier.UXV)
        .fluidInputs(Materials.SolderingAlloy.getFluid(50))
        .outputs(item('draconicevolution:chaotic_core') * 2)
        .EUt(GTValues.V[GTValues.UIV]).duration(600)
        .buildAndRegister()
// ender energy manipulator
RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
        .inputs(item('draconicevolution:draconic_core') * 2, item('draconicevolution:wyvern_core'), item('draconicevolution:dislocator'),
                item('draconicadditions:chaotic_energy_core'), item('minecraft:skull'))
        .input(OrePrefix.gem, Materials.EnderEye, 7)
        .fluidInputs(Materials.Blaze.getFluid(2304))
        .outputs(item('draconicevolution:ender_energy_manipulator'))
        .EUt(GTValues.V[GTValues.UHV]).duration(200)
        .buildAndRegister()
// chaos infinity alloy plasma
GCYLRecipeMaps.STELLAR_FORGE_RECIPES.recipeBuilder()
        .inputs(GCYLMetaBlocks.EXPLOSIVE.getItemVariant(GCYLExplosive.ExplosiveType.QCD_CHARGE))
        .input(OrePrefix.ingot, GCYLMaterials.CosmicNeutronium)
        .input(GCYLCoreItems.COSMIC_MESH)
        .fluidInputs(GCYLMaterials.Chaos.getFluid(1008))
        .fluidOutputs(GCYLMaterials.ChaosAlloy.getPlasma(2592))
        .EUt(GTValues.V[GTValues.UIV]).duration(20)
        .buildAndRegister()
// chaos infinity alloy
GCYLRecipeMaps.PLASMA_CONDENSER_RECIPES.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(GCYLMaterials.ChaosAlloy.getPlasma(144), Materials.Helium.getFluid(FluidStorageKeys.LIQUID, 100))
        .fluidOutputs(GCYLMaterials.ChaosAlloy.getFluid(144), Materials.Helium.getFluid(100))
        .EUt(960).duration(98)
        .buildAndRegister()
