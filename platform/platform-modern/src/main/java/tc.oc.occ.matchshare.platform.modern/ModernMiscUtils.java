package tc.oc.occ.matchshare.platform.modern;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import tc.oc.occ.matchshare.util.MiscUtils;
import tc.oc.pgm.util.platform.Supports;

import java.time.Duration;

import static tc.oc.pgm.util.platform.Supports.Variant.PAPER;

@Supports(value = PAPER, minVersion = "1.20.6")
public class ModernMiscUtils implements MiscUtils {

    @Override
    public void showFakeItems(Plugin plugin, Player viewer, Location location, ItemStack item, int count, Duration duration) {
        // todo
    }
}
