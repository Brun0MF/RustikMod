package fm.brunomf.rustik;

import fm.brunomf.rustik.blocks.ModBlocks;
import fm.brunomf.rustik.entity.ModEntityType;
import fm.brunomf.rustik.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("rustik")
public class Rustik
{
    public final static String MOD_ID = "rustik";

    public Rustik() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Registar Items
        ModItems.register(eventBus);

        //Registar Blocos
        ModBlocks.register(eventBus);

        //Registar Entidades
        ModEntityType.register(eventBus);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

}
