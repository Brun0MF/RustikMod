package fm.brunomf.rustik.client;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import fm.brunomf.rustik.Rustik;
import fm.brunomf.rustik.entity.ModEntityType;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.ZombieEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;




@Mod.EventBusSubscriber(modid = Rustik.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

    public static final AttributeModifier AM = new AttributeModifier("attributemodifier",5d, AttributeModifier.Operation.ADDITION);

    public static Multimap<Attribute,AttributeModifier> EntityModify(){
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create();
        map.put(Attributes.MOVEMENT_SPEED,AM);
        return map;
    }



    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void biomeLoading(BiomeLoadingEvent event){

        if(event.getCategory() != Biome.BiomeCategory.DESERT
                && event.getCategory() != Biome.BiomeCategory.NETHER
                && event.getCategory() != Biome.BiomeCategory.OCEAN
                && event.getCategory() != Biome.BiomeCategory.RIVER
                && event.getCategory() != Biome.BiomeCategory.UNDERGROUND
                && event.getCategory() != Biome.BiomeCategory.THEEND) {

            event.getSpawns().addSpawn(MobCategory.CREATURE,
                    new MobSpawnSettings.SpawnerData(ModEntityType.BOAR.get(), 10, 1, 8));
        }

        }

        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public void entityJoinWorld(EntityJoinWorldEvent event){

            Entity entity = event.getEntity();
            if (entity.isAlive() && entity instanceof Zombie) {
                Zombie zombie = (Zombie) entity;
                zombie.getAttributes().addTransientAttributeModifiers(EntityModify());
                //event.setCanceled(true);
            }



        }



    }

