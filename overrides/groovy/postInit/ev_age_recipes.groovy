import gregtech.api.GTValues
import gregtech.common.metatileentities.MetaTileEntities

// memory card (items) 10 B
crafting.shapedBuilder()
        .row('   ')
        .row('PCP')
        .row('PHP')
        .key('P', item('enderio:item_alloy_ingot', 5))
        .key('C', ore('circuitIv'))
        .key('H', MetaTileEntities.HULL[GTValues.IV].getStackForm())
        .output(item('enderutilities:enderpart', 53))
        .replace()
        .register()