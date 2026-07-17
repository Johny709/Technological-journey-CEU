import gregtech.api.unification.material.Materials
import gregtech.api.unification.material.event.MaterialEvent
import gregtech.api.unification.material.info.MaterialFlags

event_manager.listen { MaterialEvent event ->
    Materials.Protactinium.addFlags(MaterialFlags.GENERATE_FRAME)
}