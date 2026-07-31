import classes.TJMaterials
import gregtech.api.fluids.FluidState
import gregtech.api.fluids.store.FluidStorageKeys
import gregtech.api.unification.material.Material
import gregtech.api.unification.material.Materials
import gregtech.api.unification.material.event.MaterialEvent
import gregtech.api.unification.material.info.MaterialFlags

event_manager.listen { MaterialEvent event ->
    TJMaterials.PahoehoeLava = Material.builder(0, resource(getPackId(), "pahoehoe_lava"))
            .fluid(FluidStorageKeys.LIQUID, FluidState.LIQUID)
            .color(0x964B00)
            .flags(MaterialFlags.GLOWING)
            .build()
    Materials.Protactinium.addFlags(MaterialFlags.GENERATE_FRAME)
}