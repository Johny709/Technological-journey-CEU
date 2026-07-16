import classes.MetaTileEntityArmorInfuser
import classes.MetaTileEntityChaosReplicator
import classes.MetaTileEntityHeatExchanger
import classes.MetaTileEntityIndustrialPrimitiveBlastFurnace
import classes.MetaTileEntityPrimitiveAlloySmelter
import classes.MetaTileEntityTJCokeOven
import classes.TJMetaTileEntities
import gregtech.api.metatileentity.registry.MTEManager
import gregtech.common.metatileentities.MetaTileEntities

event_manager.listen { MTEManager.MTERegistryEvent event ->
    log.info('Registering TJ Tile Entities')
    TJMetaTileEntities.PRIMITIVE_ALLOY_SMELTER = MetaTileEntities.registerMetaTileEntity(0, new MetaTileEntityPrimitiveAlloySmelter(resource(getPackId(), 'primitive_alloy_smelter')))
    TJMetaTileEntities.COKE_OVEN = MetaTileEntities.registerMetaTileEntity(1, new MetaTileEntityTJCokeOven(resource(getPackId(), 'coke_oven')))
    TJMetaTileEntities.INDUSTRIAL_PRIMITIVE_BLAST_FURNACE = MetaTileEntities.registerMetaTileEntity(2, new MetaTileEntityIndustrialPrimitiveBlastFurnace(resource(getPackId(), 'industrial_primitive_blast_furnace')))
    TJMetaTileEntities.HEAT_EXCHANGER = MetaTileEntities.registerMetaTileEntity(3, new MetaTileEntityHeatExchanger(resource(getPackId(), "heat_exchanger")))
    TJMetaTileEntities.ARMOR_INFUSER = MetaTileEntities.registerMetaTileEntity(4, new MetaTileEntityArmorInfuser(resource(getPackId(), 'armor_infuser')))
    TJMetaTileEntities.CHAOS_REPLICATOR = MetaTileEntities.registerMetaTileEntity(5, new MetaTileEntityChaosReplicator(resource(getPackId(), 'chaos_replicator')))
}



