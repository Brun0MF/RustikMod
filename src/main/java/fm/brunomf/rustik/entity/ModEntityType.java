package fm.brunomf.rustik.entity;

import fm.brunomf.rustik.Rustik;
import fm.brunomf.rustik.entity.custom.Boar;
import fm.brunomf.rustik.entity.projectile.Bullet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Rustik.MOD_ID);

    public static final RegistryObject<EntityType<Bullet>> BULLET =ENTITIES.register("bullet",()-> Builder.<Bullet>of(Bullet::new, MobCategory.MISC).sized(0.1F,0.1F)
            .clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(Rustik.MOD_ID,"bullet").toString()));

    public static final RegistryObject<EntityType<Boar>> BOAR = ENTITIES.register("boar",
            () -> EntityType.Builder.of(Boar::new,MobCategory.CREATURE).sized(0.9F,0.9F)
                    .clientTrackingRange(10).build(new ResourceLocation(Rustik.MOD_ID,"boar").toString()));

    public static void register(IEventBus eventBus){
        ENTITIES.register(eventBus);
    }
}
