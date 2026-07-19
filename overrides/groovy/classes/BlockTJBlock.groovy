
import groovyjarjarantlr4.v4.runtime.misc.NotNull
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.EntityLiving
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess

class BlockTJBlock extends Block {

    BlockTJBlock() {
        super(Material.IRON)
    }

    @Override
    boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos, @NotNull EntityLiving.SpawnPlacementType type) {
        return false
    }
}