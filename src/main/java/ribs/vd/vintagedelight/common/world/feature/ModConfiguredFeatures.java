package ribs.vd.vintagedelight.common.world.feature;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangrovePropaguleBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.AboveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import ribs.vd.vintagedelight.VintageDelight;
import ribs.vd.vintagedelight.common.block.VDBlocks;

import java.util.List;
import java.util.Optional;


public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, VintageDelight.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> WILDSOYSBEANS = CONFIGURED_FEATURES.register("wild_soybeans",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(32, 16, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(VDBlocks.WILDSOYBEANS.get()))))));


    public static final RegistryObject<ConfiguredFeature<?, ?>> HOP =
            CONFIGURED_FEATURES.register("hop", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(VDBlocks.HOP_LOG.get()),
                            new FancyTrunkPlacer(3, 1, 1),
                            BlockStateProvider.simple(VDBlocks.HOP_LEAVES.get()),
                            new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 2),
                            new TwoLayersFeatureSize(4, 2, 5))
                            .build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> HOP_SPAWN =
            CONFIGURED_FEATURES.register("hop_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.HOP_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.HOP_CHECKED.getHolder().get())));


    public static final RegistryObject<ConfiguredFeature<?, ?>> VINE =
            CONFIGURED_FEATURES.register("vine", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(VDBlocks.MAGIC_VINE.get()),
                            new FancyTrunkPlacer(22, 1, 1),
                            BlockStateProvider.simple(VDBlocks.BEAN_POD.get()),
                            new FancyFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), 1),
                            new TwoLayersFeatureSize(1, 1, 1))
                            .build()));








    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
