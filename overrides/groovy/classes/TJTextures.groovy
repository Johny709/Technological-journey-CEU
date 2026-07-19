import gregtech.client.renderer.texture.cube.SimpleCubeRenderer
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.relauncher.Side

@EventBusSubscriber(modid = "groovyscript", value = Side.CLIENT)
class TJTextures {
    public static final SimpleCubeRenderer DRACONIC_CASING = new SimpleCubeRenderer('blocks/draconiccasing')
    public static final SimpleCubeRenderer CHAOS_CASING = new SimpleCubeRenderer('blocks/chaoticcasing')
    public static final SimpleCubeRenderer AWAKENED_CASING = new SimpleCubeRenderer('blocks/awakenedcasing')
    public static final SimpleCubeRenderer SOUL_CASING = new SimpleCubeRenderer('blocks/soulcasing')
}