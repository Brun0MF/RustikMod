package fm.brunomf.rustik.item;

import fm.brunomf.rustik.Rustik;
import fm.brunomf.rustik.entity.ModEntityType;
import fm.brunomf.rustik.item.custom.BulletItem;
import fm.brunomf.rustik.item.custom.RifleItem;
import jdk.jfr.Category;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModItems {

    //  Criar DefferedRegister
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Rustik.MOD_ID);


    //  Adicionar Registo
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


    //  Items
    public static final RegistryObject<Item> RIFLE = ITEMS.register("rifle",()-> new RifleItem(new Item.Properties().tab(ModItemGroup.RUSTIK)
            .durability(200)));

    //Adicionar capacidade de partir vidro e encantamento Projétil de Alta Energia(destroi alguns blocos a mais e dá mais dano)


    public static final RegistryObject<Item> BULLET = ITEMS.register("bullet",()-> new BulletItem(new Item.Properties().tab(ModItemGroup.RUSTIK),5));

    public static final RegistryObject<Item> IRONBALL = ITEMS.register("ironball",()-> new Item(new Item.Properties().tab(ModItemGroup.RUSTIK)));

    public static final RegistryObject<Item> IRONBARREL = ITEMS.register("ironbarrel",()-> new Item(new Item.Properties().tab(ModItemGroup.RUSTIK)));

    public static final RegistryObject<Item> PIECEOFLEATHER = ITEMS.register("pieceofleather",()-> new Item(new Item.Properties().tab(ModItemGroup.RUSTIK)));

    public static final RegistryObject<Item> SWEETFRUITJUICE = ITEMS.register("sweetfruitjuice",()-> new Item(new Item.Properties().tab(ModItemGroup.RUSTIK)
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(3).effect(()->new MobEffectInstance(MobEffects.CONFUSION,400,2),100)
                    .effect(()->new MobEffectInstance(MobEffects.REGENERATION,300,1),100).alwaysEat().build()).stacksTo(1)
    ));

    public static final RegistryObject<Item> GLOWFRUITJUICE = ITEMS.register("glowfruitjuice",()-> new Item(new Item.Properties().tab(ModItemGroup.RUSTIK)
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(3).effect(()->new MobEffectInstance(MobEffects.CONFUSION,400,2),100)
                    .effect(()->new MobEffectInstance(MobEffects.ABSORPTION,300,1),100)
                    .effect(()->new MobEffectInstance(MobEffects.GLOWING,300,0),100)
                    .alwaysEat().build()).stacksTo(1)
    ));

    public static final RegistryObject<ForgeSpawnEggItem> BOAR_EGG = ITEMS.register("boarspawnegg",()-> new ForgeSpawnEggItem(ModEntityType.BOAR, 0xffffff,0xffffff,new Item.Properties().tab(ModItemGroup.RUSTIK)));

    public static final RegistryObject<Item> AZALEAFLOWER = ITEMS.register("azaleaflower",()-> new Item(new Item.Properties().tab(ModItemGroup.RUSTIK)));

    public static final RegistryObject<Item> LEAF = ITEMS.register("leaf",()-> new Item(new Item.Properties().tab(ModItemGroup.RUSTIK)
            .food(new FoodProperties.Builder().nutrition(1).saturationMod(1).effect(()->new MobEffectInstance(MobEffects.CONFUSION,100,0),100)
                    .effect(()->new MobEffectInstance(MobEffects.HUNGER,500,0),100).build()).stacksTo(8)
    ));

}
