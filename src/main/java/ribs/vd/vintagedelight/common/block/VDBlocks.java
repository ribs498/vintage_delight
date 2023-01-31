package ribs.vd.vintagedelight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ribs.vd.vintagedelight.VintageDelight;
import ribs.vd.vintagedelight.common.block.custom.*;
import ribs.vd.vintagedelight.common.item.ItemRegistry;
import ribs.vd.vintagedelight.common.item.VDCreativeModeTab;
import ribs.vd.vintagedelight.common.world.feature.tree.HopTreeGrower;
import ribs.vd.vintagedelight.common.world.feature.tree.MagicVineGrower;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Supplier;

public class VDBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, VintageDelight.MOD_ID);

    public static final RegistryObject<Block> SOYBEAN_CROP = BLOCKS.register("soybean_crop",
            () -> new SoyBeanCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> WILDSOYBEANS = registerBlock("wild_soybeans",
            () -> new FlowerBlock(MobEffects.GLOWING, 5,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block> POTTED_WILDSOYBEANS = BLOCKS.register("potted_wild_soybeans",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), VDBlocks.WILDSOYBEANS,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> WILDJALEPENOS = registerBlock("wild_jalapenos",
            () -> new FlowerBlock(MobEffects.FIRE_RESISTANCE, 5,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block> POTTED_WILDJALEPENOS = BLOCKS.register("potted_wild_jalapenos",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), VDBlocks.WILDJALEPENOS,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> WILDPEANUTS = registerBlock("wild_peanuts",
            () -> new FlowerBlock(MobEffects.REGENERATION, 5,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block> POTTED_WILDPEANUTS = BLOCKS.register("potted_wild_peanuts",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), VDBlocks.WILDPEANUTS,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)));

    public static final RegistryObject<Block> JALAPENO_CROP = BLOCKS.register("jalapeno_crop",
            () -> new SoyBeanCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> PEANUT_CROP = BLOCKS.register("peanut_crop",
            () -> new PeanutCropBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES)));

    public static final RegistryObject<Block> GRUBO_BERRY_BUSH = BLOCKS.register("grubo_berry_bush",
            () -> new GruboBerryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));

    public static final RegistryObject<Block> MAGIC_VINE = registerBlock("magic_vine", () -> new VDMagicVine(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
            .requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);


    public static final RegistryObject<Block> BEAN_POD = registerBlock("bean_pod",
            () -> new Block(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(3f).requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);

    public static final RegistryObject<Block> HOP_LOG = registerBlock("hop_log", () -> new VDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block> HOP_WOOD = registerBlock("hop_wood", () -> new VDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block> STRIPPED_HOP_LOG = registerBlock("stripped_hop_log", () -> new VDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block> STRIPPED_HOP_WOOD = registerBlock("stripped_hop_wood", () -> new VDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);

    public static final RegistryObject<Block> HOP_PLANKS = registerBlock("hop_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops())
    {@Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            }, VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block> HOP_LEAVES = registerBlock("hop_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block>HOP_STAIRS = registerBlock("hop_stairs",
            () -> new StairBlock(() -> VDBlocks.HOP_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).strength(4f).requiresCorrectToolForDrops()),
            VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block> HOP_SLAB = registerBlock("hop_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                    .strength(4f).requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block> HOP_DOOR = registerBlock("hop_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                    .strength(4f).requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block> HOP_TRAPDOOR = registerBlock("hop_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)
                    .strength(4f).requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);

    public static final RegistryObject<Block> HOP_FENCE = registerBlock("hop_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)
                    .strength(4f).requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);
    public static final RegistryObject<Block> HOP_FENCE_GATE = registerBlock("hop_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)
                    .strength(4f).requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);

    public static final RegistryObject<Block> HOP_BUTTON = registerBlock("hop_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
                    .strength(4f).requiresCorrectToolForDrops()) {
                @Override
                protected SoundEvent getSound(boolean pIsOn) {
                    return null;
                }
            }, VDCreativeModeTab.VINTAGETAB);

    public static final RegistryObject<Block> HOP_PRESSURE_PLATE = registerBlock("hop_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)
                    .strength(4f).requiresCorrectToolForDrops()), VDCreativeModeTab.VINTAGETAB);

    public static final RegistryObject<Block> HOP_SAPLING = registerBlock("hop_sapling",
            () -> new SaplingBlock(new HopTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), VDCreativeModeTab.VINTAGETAB);

    public static final RegistryObject<Block> MAGIC_BEAN = registerBlock("magic_bean",
            () -> new SaplingBlock(new MagicVineGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), VDCreativeModeTab.VINTAGETAB);



    public static final RegistryObject<Block> POTTED_HOP_SAPLING = BLOCKS.register("potted_hop_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), VDBlocks.HOP_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> BREWER = registerBlock("brewer",
            () -> new BrewerBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion()), VDCreativeModeTab.VINTAGETAB);




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

