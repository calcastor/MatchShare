package tc.oc.occ.matchshare.platform.modern;

import net.minecraft.network.protocol.Packet;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftBlockType;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import tc.oc.occ.matchshare.util.MiscUtils;
import tc.oc.pgm.util.platform.Supports;

import java.time.Duration;
import java.util.UUID;

import static tc.oc.pgm.util.platform.Supports.Variant.PAPER;

@Supports(value = PAPER, minVersion = "1.20.6")
public class ModernMiscUtils implements MiscUtils {

    @Override
    public void sendPacket(Player bukkitPlayer, Object packet) {
        if (bukkitPlayer.isOnline()) {
            var nmsPlayer = ((CraftPlayer) bukkitPlayer).getHandle();
            nmsPlayer.connection.sendPacket((Packet) packet);
        }
    }

    @Override
    public void scheduleEntityDestroy(Plugin plugin, UUID viewerUuid, Duration delay, int[] entityIds) {
        // todo
    }

    @Override
    public void showFakeItems(Plugin plugin, Player viewer, Location location, ItemStack item, int count, Duration duration) {
        // todo
    }

    @Override
    public float getBlockStrength(Block block) {
        return (((CraftBlockType<?>) block)).getHardness();
    }
}
