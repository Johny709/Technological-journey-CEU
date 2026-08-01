import classes.TJMaterials
import com.fulltrix.gcyl.materials.GCYLMaterials
import gregtech.api.GTValues
import gregtech.api.recipes.RecipeMaps
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix

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