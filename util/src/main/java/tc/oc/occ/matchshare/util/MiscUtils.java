package tc.oc.occ.matchshare.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import tc.oc.pgm.util.platform.Platform;

import java.time.Duration;

public interface MiscUtils {
    MiscUtils MISC_UTILS = Platform.get(MiscUtils.class);

    void showFakeItems(
            Plugin plugin,
            Player viewer,
            Location location,
            ItemStack item,
            int count,
            Duration duration);
}
