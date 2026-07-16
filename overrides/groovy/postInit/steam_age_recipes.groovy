import classes.TJMetaTileEntities
import gregtech.api.unification.OreDictUnifier
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.common.blocks.BlockMetalCasing
import gregtech.common.blocks.MetaBlocks
import gregtech.common.metatileentities.MetaTileEntities

// steam motor
crafting.shapedBuilder()
        .row('SPR')
        .row('PRP')
        .row('IPS')
        .key('S', OreDictUnifier.get(OrePrefix.stick, Materials.Wood))
        .key('P', OreDictUnifier.get(OrePrefix.plate, Materials.Bronze))
        .key('R', OreDictUnifier.get(OrePrefix.stick, Materials.Iron))
        .key('I', OreDictUnifier.get(OrePrefix.ingot, Materials.Iron))
        .output(item('technological_journey:steammotor'))
        .register()
// steam piston
crafting.shapedBuilder()
        .row('GSS')
        .row('GMB')
        .row('PPP')
        .key('G', OreDictUnifier.get(OrePrefix.gearSmall, Materials.Iron))
        .key('S', OreDictUnifier.get(OrePrefix.stick, Materials.Wood))
        .key('M', item('technological_journey:steammotor'))
        .key('B', OreDictUnifier.get(OrePrefix.plate, Materials.Bronze))
        .key('P', OreDictUnifier.get(OrePrefix.plate, Materials.Iron))
        .output(item('technological_journey:steampiston'))
        .register()
// industrial primitive blast furnace
crafting.shapedBuilder()
        .row('BFB')
        .row('FEF')
        .row('BFB')
        .key('B', MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS))
        .key('F', item('minecraft:furnace'))
        .key('E', MetaTileEntities.PRIMITIVE_BLAST_FURNACE.getStackForm())
        .output(TJMetaTileEntities.INDUSTRIAL_PRIMITIVE_BLAST_FURNACE.getStackForm())
        .register()