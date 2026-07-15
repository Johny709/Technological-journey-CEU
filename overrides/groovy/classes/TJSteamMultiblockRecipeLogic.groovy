import gregtech.api.GTValues
import gregtech.api.capability.impl.MultiblockRecipeLogic
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController
import gregtech.api.recipes.RecipeBuilder
import gregtech.api.recipes.logic.OCResult
import gregtech.api.recipes.properties.RecipePropertyStorage
import gregtech.api.unification.material.Materials
import groovyjarjarantlr4.v4.runtime.misc.NotNull
import net.minecraftforge.fluids.FluidStack

class TJSteamMultiblockRecipeLogic extends MultiblockRecipeLogic {

    private FluidStack steamConsumption
    private boolean runAtZeroEnergy

    TJSteamMultiblockRecipeLogic(RecipeMapMultiblockController metaTileEntity) {
        this(metaTileEntity, false)
    }

    TJSteamMultiblockRecipeLogic(RecipeMapMultiblockController metaTileEntity, boolean runAtZeroEnergy) {
        super(metaTileEntity, metaTileEntity.recipeMap)
        this.runAtZeroEnergy = runAtZeroEnergy
        this.setAllowOverclocking(false)
    }

    @Override
    protected boolean drawEnergy(long recipeEUt, boolean simulate) {
        TJRecipeMapSteamMultiblockController controller = this.metaTileEntity as TJRecipeMapSteamMultiblockController
        return this.runAtZeroEnergy ? true : this.steamConsumption.isFluidStackIdentical(controller.getSteamTank().drain(this.steamConsumption, !simulate))
    }

    @Override
    protected boolean hasEnoughPower(long eut, int duration) {
        TJRecipeMapSteamMultiblockController controller = this.metaTileEntity as TJRecipeMapSteamMultiblockController
        return this.runAtZeroEnergy ? true : this.steamConsumption.isFluidStackIdentical(controller.getSteamTank().drain(this.steamConsumption, false))
    }

    @Override
    void applyParallelBonus(RecipeBuilder builder) {
        int currentParallel = builder.getParallel()
        long currentRecipeEU = builder.getEUt() / currentParallel as long
        int currentRecipeDuration = builder.getDuration() / this.getParallelLimit() as int
        builder.EUt(Math.ceil(currentRecipeEU * 1.33) as long)
                .duration((currentRecipeDuration * currentParallel * 1.5) as int)
    }

    @Override
    protected void modifyOverclockPost(@NotNull OCResult ocResult, @NotNull RecipePropertyStorage storage) {
        super.modifyOverclockPost(ocResult, storage)
        this.steamConsumption = Materials.Steam.getFluid(ocResult.eut * 2 as int)
    }

    @Override
    protected long getMaxParallelVoltage() {
        return GTValues.V[GTValues.LV] * this.getParallelLimit()
    }

    @Override
    long getMaxVoltage() {
        return GTValues.V[GTValues.LV]
    }
}