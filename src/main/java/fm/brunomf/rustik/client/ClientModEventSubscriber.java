package fm.brunomf.rustik.client;

import fm.brunomf.rustik.Rustik;
import fm.brunomf.rustik.client.renderer.entity.BoarRenderer;
import fm.brunomf.rustik.client.renderer.entity.BulletRenderer;
import fm.brunomf.rustik.entity.ModEntityType;
import fm.brunomf.rustik.entity.custom.Boar;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Rustik.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityType.BULLET.get(), BulletRenderer::new);
        event.registerEntityRenderer(ModEntityType.BOAR.get(), BoarRenderer::new);

    }


    public static void CommonSetup(FMLCommonSetupEvent event){
        event.enqueueWork(()-> SpawnPlacements.register(ModEntityType.BOAR.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,Boar::canSpawn));

    }


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntityType.BOAR.get(), Boar.createAttributes().build());
    }
}
