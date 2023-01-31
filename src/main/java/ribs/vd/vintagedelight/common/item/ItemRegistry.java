package ribs.vd.vintagedelight.common.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ribs.vd.vintagedelight.VintageDelight;
import ribs.vd.vintagedelight.common.block.VDBlocks;
import ribs.vd.vintagedelight.common.item.food.VDFood;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.item.HotCocoaItem;
import vectorwing.farmersdelight.common.item.MelonJuiceItem;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VintageDelight.MOD_ID);
    public static final RegistryObject<Item> PEANUT = ITEMS.register("peanut", () -> new ItemNameBlockItem(VDBlocks.PEANUT_CROP.get(), new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB).food(VDFood.PEANUT)));
    public static final RegistryObject<Item> GRUBOBERRY = ITEMS.register("grubo_berry", () -> new Item(new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB).food(VDFood.GRUBOBERRY)));

    public static final RegistryObject<Item> JALAPENO = ITEMS.register("jalapeno", () -> new Item(new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB).food(VDFood.JALAPENO)));
    public static final RegistryObject<Item> SOYBEAN = ITEMS.register("soybean", () -> new Item(new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB).food(VDFood.SOYBEAN)));
    public static final RegistryObject<Item> SOYBEANS = ITEMS.register("soybeans", () -> new Item(new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB).food(VDFood.SOYBEANS)));

    public static final RegistryObject<Item> HOPS = ITEMS.register("hops", () -> new Item(new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB)));
    public static final RegistryObject<Item> SOYBEAN_SEEDS = ITEMS.register("soybean_seeds", () -> new ItemNameBlockItem(VDBlocks.SOYBEAN_CROP.get(), new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB)));
    public static final RegistryObject<Item> JALAPENO_SEEDS = ITEMS.register("jalapeno_seeds", () -> new ItemNameBlockItem(VDBlocks.JALAPENO_CROP.get(), new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB)));
    public static final RegistryObject<Item> GRUBOBERRY_PIPS = ITEMS.register("grubo_berry_pips", () -> new ItemNameBlockItem(VDBlocks.GRUBO_BERRY_BUSH.get(), new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB)));


    public static final RegistryObject<Item> ROASTEDPEANUT = ITEMS.register("roasted_peanut", () -> new Item(new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB).food(VDFood.ROASTEDPEANUT)));
    public static final RegistryObject<Item> NUTPASTE = ITEMS.register("nut_paste", () -> new Item(new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB).food(VDFood.NUTPASTE)));
    public static final RegistryObject<Item> PICKLEDSOYBEAN = ITEMS.register("pickled_soybean", () -> new Item(new Item.Properties().tab(VDCreativeModeTab.VINTAGETAB).food(VDFood.PICKLEDSOYBEAN)));








    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
