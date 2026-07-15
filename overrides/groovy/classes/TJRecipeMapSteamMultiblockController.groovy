import gregtech.api.capability.IMultipleTankHandler
import gregtech.api.capability.impl.FluidTankList
import gregtech.api.metatileentity.multiblock.MultiblockAbility
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController
import gregtech.api.mui.GTGuiTheme
import gregtech.api.pattern.PatternMatchContext
import gregtech.api.recipes.RecipeMap
import groovyjarjarantlr4.v4.runtime.misc.NotNull
import groovyjarjarantlr4.v4.runtime.misc.Nullable

import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

abstract class TJRecipeMapSteamMultiblockController extends RecipeMapMultiblockController {

    protected IMultipleTankHandler steamTank

    TJRecipeMapSteamMultiblockController(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap) {
        super(metaTileEntityId, recipeMap)
    }

    @Override
    @SideOnly(Side.CLIENT)
    void addInformation(ItemStack stack, @Nullable World world, @NotNull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, world, tooltip, advanced)
        tooltip.add(net.minecraft.client.resources.I18n.format("gregtech.universal.tooltip.parallel", this.recipeMapWorkable.getParallelLimit()))
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context)
        this.steamTank = new FluidTankList(true, this.getAbilities(MultiblockAbility.STEAM))
    }

    @Override
    void invalidateStructure() {
        super.invalidateStructure()
        this.steamTank = new FluidTankList(true)
    }

    @Override
    GTGuiTheme getUITheme() {
        return GTGuiTheme.PRIMITIVE
    }

    IMultipleTankHandler getSteamTank() {
        return this.steamTank
    }

    @Override
    boolean hasMaintenanceMechanics() {
        return false
    }
}