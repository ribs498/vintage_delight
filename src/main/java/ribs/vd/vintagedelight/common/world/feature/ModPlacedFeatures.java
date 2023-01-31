package ribs.vd.vintagedelight.common.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import ribs.vd.vintagedelight.VintageDelight;
import ribs.vd.vintagedelight.common.block.VDBlocks;

import java.util.List;
public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, VintageDelight.MOD_ID);


    public static final RegistryObject<PlacedFeature> HOP_CHECKED = PLACED_FEATURES.register("hop_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.HOP.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(VDBlocks.HOP_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> HOP_PLACED = PLACED_FEATURES.register("hop_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.HOP_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));


    public static final RegistryObject<PlacedFeature> WILD_SOYBEANS_PLACED = PLACED_FEATURES.register("wild_soybeans_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.WILDSOYSBEANS.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}