package ribs.vd.vintagedelight.common.block.entity;


import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ribs.vd.vintagedelight.VintageDelight;
import ribs.vd.vintagedelight.common.block.VDBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, VintageDelight.MOD_ID);

    public static final RegistryObject<BlockEntityType<BrewerBlockEntity>> BREWER =
            BLOCK_ENTITIES.register("brewer", () ->
                    BlockEntityType.Builder.of(BrewerBlockEntity::new,
                            VDBlocks.BREWER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}