package ribs.vd.vintagedelight;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import ribs.vd.vintagedelight.common.block.VDBlocks;
import ribs.vd.vintagedelight.common.block.entity.ModBlockEntities;
import ribs.vd.vintagedelight.common.item.ItemRegistry;
import ribs.vd.vintagedelight.common.networking.ModMessages;
import ribs.vd.vintagedelight.common.recipe.VDRecipes;
import ribs.vd.vintagedelight.common.screen.BrewerScreen;
import ribs.vd.vintagedelight.common.screen.ModMenuTypes;
import ribs.vd.vintagedelight.common.world.feature.ModConfiguredFeatures;
import ribs.vd.vintagedelight.common.world.feature.ModPlacedFeatures;

@Mod(VintageDelight.MOD_ID)
public class VintageDelight
{

    public static final String MOD_ID = "vintagedelight";
    private static final Logger LOGGER = LogUtils.getLogger();
    public VintageDelight()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        VDBlocks.register(modEventBus);
        ItemRegistry.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        VDRecipes.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModMessages.register();
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VDBlocks.WILDSOYBEANS.getId(), VDBlocks.POTTED_WILDSOYBEANS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VDBlocks.WILDJALEPENOS.getId(), VDBlocks.POTTED_WILDJALEPENOS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VDBlocks.WILDPEANUTS.getId(), VDBlocks.POTTED_WILDPEANUTS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VDBlocks.HOP_SAPLING.getId(), VDBlocks.POTTED_HOP_SAPLING);
        });
    }



    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(VDBlocks.GRUBO_BERRY_BUSH.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(VDBlocks.SOYBEAN_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(VDBlocks.JALAPENO_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(VDBlocks.PEANUT_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(VDBlocks.HOP_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(VDBlocks.HOP_TRAPDOOR.get(), RenderType.cutout());

            MenuScreens.register(ModMenuTypes.BREWER_MENU.get(), BrewerScreen::new);
        }
    }
}
