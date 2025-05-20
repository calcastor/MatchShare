package tc.oc.occ.matchshare.platform.modern;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import tc.oc.occ.matchshare.util.MiscUtils;

import java.time.Duration;
import java.util.UUID;

public class ModernMiscUtils implements MiscUtils {
    @Override
    public void dummy() {}

    @Override
    public void sendPacket(Player bukkitPlayer, Object packet) {
    }

    @Override
    public void showFakeItems(Plugin plugin, Player viewer, Location location, ItemStack item, int count, Duration duration) {
    }

    @Override
    public void scheduleEntityDestroy(Plugin plugin, UUID viewerUuid, Duration delay, int[] entityIds) {
    }
}
