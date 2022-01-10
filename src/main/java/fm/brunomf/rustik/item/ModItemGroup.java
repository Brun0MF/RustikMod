package fm.brunomf.rustik.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {

    public static final CreativeModeTab RUSTIK = new CreativeModeTab("rustik") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RIFLE.get());
        }
    };

}
