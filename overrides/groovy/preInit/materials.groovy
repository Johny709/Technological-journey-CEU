import classes.TJMaterials
import gregtech.api.fluids.FluidBuilder
import gregtech.api.fluids.FluidState
import gregtech.api.fluids.store.FluidStorageKeys
import gregtech.api.unification.material.Material
import gregtech.api.unification.material.Materials
import gregtech.api.unification.material.event.MaterialEvent
import gregtech.api.unification.material.info.MaterialFlags
import gregtech.api.unification.material.info.MaterialIconSet
import gregtech.api.unification.material.properties.BlastProperty

event_manager.listen { MaterialEvent event ->
    TJMaterials.PahoehoeLava = Material.builder(10000, resource(getPackId(), "pahoehoe_lava"))
            .fluid(FluidStorageKeys.LIQUID, FluidState.LIQUID)
            .color(0x964B00)
            .flags(MaterialFlags.GLOWING)
            .build()
    TJMaterials.StarMetalAlloy = Material.builder(10001, resource(getPackId(), "star_metal_alloy"))
            .ingot(3)
            .color(0x050A30)
            .iconSet(MaterialIconSet.SHINY)
            .liquid(new FluidBuilder().temperature(7000))
            .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_DOUBLE_PLATE)
            .blast(b -> b.temp(7000, BlastProperty.GasTier.HIGH)
                    .blastStats(8000, 1716)
                    .vacuumStats(8000, 438))
            .build()
    Materials.Protactinium.addFlags(MaterialFlags.GENERATE_FRAME)
}