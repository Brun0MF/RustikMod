package fm.brunomf.rustik.blocks;


import fm.brunomf.rustik.Rustik;
import fm.brunomf.rustik.item.ModItemGroup;
import fm.brunomf.rustik.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {


    //  Instanciar Bloco
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, Rustik.MOD_ID);




    //  Registrar/Criar Bloco
    public static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block){
        RegistryObject toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //  Registrar/Criar item do bloco
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(),
                new Item.Properties().tab(ModItemGroup.RUSTIK)));
    }


    //  Criar registo
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }




    //  Blocos
   /* public static final RegistryObject<Block> TRAP = registryBlock("trap",()-> new MobAlarm(BlockBehaviour.Properties.of(Material.STONE)
            .explosionResistance(0.6f).strength(1.5f,1f).sound(SoundType.ANVIL)));
    */




}
