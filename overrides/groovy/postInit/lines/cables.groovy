package postInit.lines

import com.fulltrix.gcyl.item.GCYLCoreItems
import com.fulltrix.gcyl.materials.GCYLMaterials
import gregtech.api.GTValues
import gregtech.api.recipes.RecipeMaps
import gregtech.api.recipes.builders.SimpleRecipeBuilder
import gregtech.api.unification.OreDictUnifier
import gregtech.api.unification.material.Material
import gregtech.api.unification.material.Materials
import gregtech.api.unification.material.properties.WireProperties
import gregtech.api.unification.ore.OrePrefix
import gregtech.api.util.GTUtility
import gregtech.common.pipelike.cable.BlockCable
import net.minecraft.block.Block
import net.minecraft.item.ItemStack
import net.minecraftforge.fluids.FluidStack

FluidStack styreneRubber = Materials.StyreneButadieneRubber.getFluid(1)

int polycaprolactamTier = 0
int polyethyleneTier = 1
int polyvinylChlorideTier = 2
int polyphenyleneSulfideTier = 3
int polybenzimidazoleTier = 4
int polyetheretherketoneTier = 6
int zylonTier = 8
int fullerenePolymerMatrixTier = 10

def getCableQuantity = { OrePrefix orePrefix ->
    if (orePrefix == OrePrefix.cableGtDouble)
        return 2
    if (orePrefix == OrePrefix.cableGtQuadruple)
        return 4
    if (orePrefix == OrePrefix.cableGtOctal)
        return 8
    if (orePrefix == OrePrefix.cableGtHex)
        return 16
    return 1
}

def getWireOreDict = { OrePrefix orePrefix ->
    if (orePrefix == OrePrefix.cableGtDouble)
        return OrePrefix.wireGtDouble
    if (orePrefix == OrePrefix.cableGtQuadruple)
        return OrePrefix.wireGtQuadruple
    if (orePrefix == OrePrefix.cableGtOctal)
        return OrePrefix.wireGtOctal
    if (orePrefix == OrePrefix.cableGtHex)
        return OrePrefix.wireGtHex
    return OrePrefix.wireGtSingle
}

// cable recipes
RecipeMaps.ASSEMBLER_RECIPES.getRecipeList().forEach(recipe -> {
    ItemStack cableOutput = recipe.getOutputs().get(0)
    Block block = Block.getBlockFromItem(cableOutput.getItem())
    if (block instanceof BlockCable) {
        WireProperties wireProperties = ((BlockCable) block).createItemProperties(cableOutput)
        if (wireProperties != null) {
            RecipeMaps.ASSEMBLER_RECIPES.removeRecipe(recipe)
            if (styreneRubber.isFluidEqual(recipe.getFluidInputs().get(0).getInputFluidStack())) {
                Material cableMaterial = ((BlockCable) block).getItemMaterial(cableOutput)
                OrePrefix orePrefix = OreDictUnifier.getPrefix(cableOutput)
                OrePrefix wireOrePrefix = getWireOreDict(orePrefix)
                int tier = GTUtility.getTierByVoltage(wireProperties.getVoltage())
                // cable with rubber
                if (tier < GTValues.MV) {
                    double multiplier = getCableQuantity(orePrefix)
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .input(OrePrefix.foil, Materials.Rubber, 4 * multiplier as int)
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .fluidInputs(Materials.Rubber.getFluid(144 * multiplier as int))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()

                    List<?> ingredients = [OreDictUnifier.get(wireOrePrefix, cableMaterial), ore('string')]
                    int amount = getCableQuantity(orePrefix)
                    for (i in 0..<amount) {
                        ingredients.add(OreDictUnifier.get(OrePrefix.plate, Materials.Rubber))
                    }
                    crafting.removeByOutput(cableOutput)
                    if (ingredients.size() < 10)
                        crafting.addShapeless(cableOutput, ingredients)
                }
                // cable with polycaprolactam
                if (tier < GTValues.HV) {
                    double multiplier = getCableQuantity(orePrefix) / Math.pow(2, polycaprolactamTier - tier)
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .input(OrePrefix.foil, Materials.Polycaprolactam, Math.max(1, multiplier as int))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .fluidInputs(Materials.Polycaprolactam.getFluid(Math.max(1, 36 * multiplier as int)))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                }
                // cable with polyethylene (PE)
                if (tier < GTValues.EV) {
                    double multiplier = getCableQuantity(orePrefix) / Math.pow(2, polyethyleneTier - tier)
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .input(OrePrefix.foil, Materials.Polyethylene, Math.max(1, multiplier as int))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .fluidInputs(Materials.Polyethylene.getFluid(Math.max(1, 36 * multiplier as int)))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                }
                // cable with polyvinyl chloride (PVC)
                if (tier < GTValues.IV) {
                    double multiplier = getCableQuantity(orePrefix) / Math.pow(2, polyvinylChlorideTier - tier)
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .input(OrePrefix.foil, Materials.PolyvinylChloride, Math.max(1, multiplier as int))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .fluidInputs(Materials.PolyvinylChloride.getFluid(Math.max(1, 36 * multiplier as int)))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                }
                // cable with polyphenylene sulfide
                if (tier < GTValues.ZPM) {
                    double multiplier = getCableQuantity(orePrefix) / Math.pow(2, polyphenyleneSulfideTier - tier)
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .input(OrePrefix.foil, Materials.PolyphenyleneSulfide, Math.max(1, multiplier as int))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .fluidInputs(Materials.PolyphenyleneSulfide.getFluid(Math.max(1, 36 * multiplier as int)))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                }
                // cable with polybenzimidazole (PBI)
                if (tier < GTValues.UHV) {
                    double multiplier = getCableQuantity(orePrefix) / Math.pow(2, polybenzimidazoleTier - tier)
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .input(OrePrefix.foil, Materials.Polybenzimidazole, Math.max(1, multiplier as int))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .fluidInputs(Materials.Polybenzimidazole.getFluid(Math.max(1, 36 * multiplier as int)))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                }
                // cable with polyetheretherketone (PEEK)
                if (tier < GTValues.UIV) {
                    double multiplier = getCableQuantity(orePrefix) / Math.pow(2, polyetheretherketoneTier - tier)
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .input(OrePrefix.foil, GCYLMaterials.Polyetheretherketone, Math.max(1, multiplier as int))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                    RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .fluidInputs(GCYLMaterials.Polyetheretherketone.getFluid(Math.max(1, 36 * multiplier as int)))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                            .buildAndRegister()
                }
                // cable with zylon
                if (tier < GTValues.OpV) {
                    double multiplier = getCableQuantity(orePrefix) / Math.pow(2, zylonTier - tier)
                    SimpleRecipeBuilder recipeMap = RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .input(OrePrefix.foil, GCYLMaterials.Zylon, Math.max(1, multiplier as int))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                    SimpleRecipeBuilder recipeMap2 = RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .fluidInputs(GCYLMaterials.Zylon.getFluid(Math.max(1, 36 * multiplier as int)))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                    if (tier > GTValues.UIV) {
                        recipeMap.input(GCYLCoreItems.INSULATION_WIRE_ASSEMBLY, Math.max(1, multiplier / 2 as int))
                        recipeMap2.input(GCYLCoreItems.INSULATION_WIRE_ASSEMBLY, Math.max(1, multiplier / 2 as int))
                    }
                    recipeMap.buildAndRegister()
                    recipeMap2.buildAndRegister()
                }
                // cable with fullerene polymer matrix (FPM)
                if (tier < 15) {
                    double multiplier = getCableQuantity(orePrefix) / Math.pow(2, fullerenePolymerMatrixTier - tier)
                    SimpleRecipeBuilder recipeMap = RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .input(OrePrefix.foil, GCYLMaterials.FullerenePolymerMatrix, Math.max(1, multiplier as int))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                    SimpleRecipeBuilder recipeMap2 = RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                            .circuitMeta(24)
                            .input(wireOrePrefix, cableMaterial)
                            .fluidInputs(GCYLMaterials.FullerenePolymerMatrix.getFluid(Math.max(1, 36 * multiplier as int)))
                            .outputs(cableOutput)
                            .EUt(8).duration(150)
                    if (tier > GTValues.UIV) {
                        recipeMap.input(GCYLCoreItems.INSULATION_WIRE_ASSEMBLY, Math.max(1, multiplier / 2 as int))
                        recipeMap2.input(GCYLCoreItems.INSULATION_WIRE_ASSEMBLY, Math.max(1, multiplier / 2 as int))
                    }
                    recipeMap.buildAndRegister()
                    recipeMap2.buildAndRegister()
                }
            }
        }
    }
})

