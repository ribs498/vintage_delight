package ribs.vd.vintagedelight.common.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class VDCreativeModeTab {
    public static final CreativeModeTab VINTAGETAB = new CreativeModeTab("vintage_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.SOYBEAN.get());
        }
    };
}
