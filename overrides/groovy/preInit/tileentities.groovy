
import classes.MetaTileEntityPrimitiveAlloySmelter
import classes.TJMetaTileEntities
import gregtech.api.metatileentity.registry.MTEManager
import gregtech.common.metatileentities.MetaTileEntities

event_manager.listen { MTEManager.MTERegistryEvent event ->
    log.info('Registering TJ Tile Entities')
    TJMetaTileEntities.PRIMITIVE_ALLOY_SMELTER = MetaTileEntities.registerMetaTileEntity(0, new MetaTileEntityPrimitiveAlloySmelter(resource(getPackId(), 'primitive_alloy_smelter')))
}



