package com.jadedpacks.jcmodtweaks;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;



import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jadedpacks.jadedbase.helpers.OreDictionaryTweaks;
import com.jadedpacks.jadedbase.helpers.RecipeRemover;
import com.jadedpacks.jadedbase.helpers.Parts;
import com.jadedpacks.jadedbase.helpers.Basic;
import com.jadedpacks.jadedbase.helpers.Wood;
import com.jadedpacks.jcmodtweaks.crossmod.BloodMagicHelper;
import com.jadedpacks.jcmodtweaks.crossmod.BotaniaHelper;
import com.jadedpacks.jcmodtweaks.crossmod.CustomNpcsHelper;
import com.jadedpacks.jcmodtweaks.crossmod.ExNihiloHelper;
import com.jadedpacks.jcmodtweaks.crossmod.HarvestCraftHelper;
import com.jadedpacks.jcmodtweaks.crossmod.MFRHelper;
import com.jadedpacks.jcmodtweaks.crossmod.ThaumcraftHelper;
import com.jadedpacks.jcmodtweaks.crossmod.ThermalExpansionHelper;
import com.jadedpacks.jcmodtweaks.crossmod.TinkersConstructHelper;

import forestry.api.arboriculture.IWoodItemAccess;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.ItemStackHolderInjector;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;

@Mod(modid = JCModTweaks.MODID, version = JCModTweaks.VERSION, name = JCModTweaks.NAME,  dependencies = "required-after:Forge@[10.13.3.1384,11.14);" +
		"after:JCBase;")

public class JCModTweaks {
	public static final String MODID = "JCModTweaks";
	public static final String NAME = "JCModTweaks";
	public static final String VERSION = "1.0.1";
	public static final Logger log = LogManager.getLogger(MODID);

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{		
		if (Loader.isModLoaded("ThermalExpansion"))
		{
			ThermalExpansionHelper.preInit();
		}
		if (Loader.isModLoaded("Thaumcraft"))
		{
			ThaumcraftHelper.preInit();
		}
		if (Loader.isModLoaded("TConstruct"))
		{
			TinkersConstructHelper.preInit();
		}
		if (Loader.isModLoaded("MineFactoryReloaded"))
		{
			MFRHelper.preInit();
		}
		if (Loader.isModLoaded("Botania"))
		{
			BotaniaHelper.preInit();
		}
		if (Loader.isModLoaded("AWWayofTime"))
		{
			BloodMagicHelper.preInit();
		}
		if (Loader.isModLoaded("harvestcraft"))
		{
			HarvestCraftHelper.preInit();
		}
		
		if (Loader.isModLoaded("customnpcs"))
		{
			CustomNpcsHelper.preInit();
		}
		if(Loader.isModLoaded("exnihilo"))
		{
			ExNihiloHelper.preInit();
		}
	}
	@Mod.EventHandler
	public void init (FMLInitializationEvent event)

	{
		
		if (Loader.isModLoaded("ThermalExpansion"))
		{
			ThermalExpansionHelper.init();
		}
		if (Loader.isModLoaded("Thaumcraft"))
		{
			ThaumcraftHelper.init();
		}
		if (Loader.isModLoaded("TConstruct"))
		{
			TinkersConstructHelper.init();
		}
		if (Loader.isModLoaded("MineFactoryReloaded"))
		{
			MFRHelper.init();
		}
		if (Loader.isModLoaded("Botania"))
		{
			BotaniaHelper.init();
		}
		if (Loader.isModLoaded("AWWayofTime"))
		{
			BloodMagicHelper.init();
		}
		if (Loader.isModLoaded("harvestcraft"))
		{
			HarvestCraftHelper.init();
		}
		
		if (Loader.isModLoaded("customnpcs"))
		{
			CustomNpcsHelper.init();
		}
		if(Loader.isModLoaded("exnihilo"))
		{
			ExNihiloHelper.init();
		}
		

	}

	@Mod.EventHandler
	public void postInit (FMLPostInitializationEvent event)

	{
		
		if (Loader.isModLoaded("ThermalExpansion"))
		{
			ThermalExpansionHelper.postInit();
		}
		if (Loader.isModLoaded("Thaumcraft"))
		{
			ThaumcraftHelper.postInit();
		}
		if (Loader.isModLoaded("TConstruct"))
		{
			TinkersConstructHelper.postInit();
		}
		if (Loader.isModLoaded("MineFactoryReloaded"))
		{
			MFRHelper.postInit();
		}
		if (Loader.isModLoaded("Botania"))
		{
			BotaniaHelper.postInit();
		}
		if (Loader.isModLoaded("AWWayofTime"))
		{
			BloodMagicHelper.postInit();
		}
		if (Loader.isModLoaded("harvestcraft"))
		{
			HarvestCraftHelper.postInit();
		}
		if (Loader.isModLoaded("customnpcs"))
		{
			CustomNpcsHelper.postInit();
		}
		if(Loader.isModLoaded("exnihilo"))
		{
			ExNihiloHelper.postInit();
		}
	}

	@Mod.EventHandler
	public void loadComplete(FMLLoadCompleteEvent event)

	{
		if (Loader.isModLoaded("ThermalExpansion"))
		{
			ThermalExpansionHelper.loadComplete();
		}

	}
}


