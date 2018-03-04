package com.lcm.sea.starwars;

import com.lcm.sea.starwars.client.render.RenderBB8;
import com.lcm.sea.starwars.common.CommandDimTravel;
import com.lcm.sea.starwars.common.dimensions.DimensionSetup;
import com.lcm.sea.starwars.common.mobs.EntityBB8;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = StarWars.MODID, name = StarWars.NAME, version = StarWars.VERSION, dependencies = "required:forge@[14.23.1.2574,); required-after:lucraftcore@[1.12-2.0.4,)", acceptedMinecraftVersions = "1.12, 1.12.1, 1.12.2")
public class StarWars
{
    public static final String MODID = "starwars";
    public static final String NAME = "Star Wars";
    public static final String VERSION = "1.1";

    public static FMLCommonHandler FML = FMLCommonHandler.instance();

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        DimensionSetup.init();

        if(FML.getSide().isClient())
        {
            RenderingRegistry.registerEntityRenderingHandler(EntityBB8.class, new RenderBB8());
        }
    }

    @EventHandler
    public static void serverStart(FMLServerStartingEvent e)
    {
        e.registerServerCommand(new CommandDimTravel());
    }
}
