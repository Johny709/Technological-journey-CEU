import classes.TJMaterials
import gregtech.api.unification.OreDictUnifier
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.common.items.MetaItems

// celestial manipulator
crafting.shapedBuilder()
        .row('RCR')
        .row('PFP')
        .row('PGP')
        .key('R', OreDictUnifier.get(OrePrefix.block, Materials.Redstone))
        .key('C', item('minecraft:clock'))
        .key('P', OreDictUnifier.get(OrePrefix.plate, TJMaterials.StarMetalAlloy))
        .key('F', MetaItems.FIELD_GENERATOR_LuV.getStackForm())
        .key('G', OreDictUnifier.get(OrePrefix.gear, Materials.NeodymiumMagnetic))
        .output(item('draconicevolution:celestial_manipulator'))
        .replace()
        .register()