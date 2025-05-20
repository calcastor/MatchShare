package tc.oc.occ.matchshare.util;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import tc.oc.pgm.util.platform.Platform;

import java.time.Duration;
import java.util.UUID;

public interface MiscUtils {
    MiscUtils MISC_UTILS = Platform.get(MiscUtils.class);

    void sendPacket(Player bukkitPlayer, Object packet);

    void scheduleEntityDestroy(Plugin plugin, UUID viewerUuid, Duration delay, int[] entityIds);

    void showFakeItems(
            Plugin plugin,
            Player viewer,
            Location location,
            ItemStack item,
            int count,
            Duration duration);

    float getBlockStrength(Block block);
}
