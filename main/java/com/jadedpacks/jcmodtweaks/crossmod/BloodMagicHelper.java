package com.jadedpacks.jcmodtweaks.crossmod;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import WayofTime.alchemicalWizardry.api.alchemy.AlchemyRecipeRegistry;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;

import com.jadedpacks.jadedbase.helpers.OreDictionaryTweaks;
import com.jadedpacks.jadedbase.helpers.RecipeRemover;
import com.jadedpacks.jadedbase.helpers.Parts;
import com.jadedpacks.jadedbase.helpers.Basic;
import com.jadedpacks.jadedbase.helpers.Wood;
import com.jadedpacks.jcmodtweaks.JCModTweaks;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;


public class BloodMagicHelper {

	public static void preInit(){

	}

	public static void init()	{}

	public static void postInit()
	{
		addRecipes();
		addAltarRecipe();
		AlchemyRecipe();

	}

	public static void addAltarRecipe	()


	{
		if (Loader.isModLoaded("exnihilo"))
		{
			AltarRecipeRegistry.registerAltarRecipe(Parts.spawnSheep, Parts.wool, 2, 5000, 2, 2, false);
			AltarRecipeRegistry.registerAltarRecipe(Parts.spawnMCow, Parts.mycelium, 3, 7000, 2, 2, false);
			AltarRecipeRegistry.registerAltarRecipe(Parts.spawnPig, Parts.wool2, 2, 7000, 2, 2, false);
			AltarRecipeRegistry.registerAltarRecipe(Parts.lifeshard, Parts.bloodshard, 3, 35000, 2, 2, false);
		}
		if (Parts.manabucket !=null) {
			AltarRecipeRegistry.registerAltarRecipe(Parts.manabucket, Parts.lifebucket, 2, 2000, 2, 2, false);
		}

		if (Parts.voidSeed !=null)
		{
			AltarRecipeRegistry.registerAltarRecipe(Parts.spawnGuardian, Parts.voidSeed, 2, 7000, 2, 2, false);
		}
		JCModTweaks.log.info("Jaded added spawn recipes");
	}

	public static void AlchemyRecipe()
	{
		if (Loader.isModLoaded("exnihilo"))
		{
			AlchemyRecipeRegistry.registerRecipe(Parts.spawnChicken, 2, new ItemStack[]{(Parts.flesh),(Parts.flesh), (Parts.diamond), (Parts.feather), (Parts.leather)}, 2);
			AlchemyRecipeRegistry.registerRecipe(Parts.spawnCow, 2, new ItemStack[]{(Parts.leather),(Parts.leather), (Parts.diamond), (Parts.leather)}, 2);
			AlchemyRecipeRegistry.registerRecipe(Parts.soulshard, 2, new ItemStack[]{(Parts.bloodshard),(Parts.bloodshard), (Parts.lifeshard), (Parts.bloodshard)}, 2);
		}
		AlchemyRecipeRegistry.registerRecipe(Parts.blazerod, 2, new ItemStack[]{(Parts.blazepowder),(Parts.blazepowder), (Parts.blazepowder), (Parts.blazepowder)}, 2);

		if (Parts.hearts !=null)
		{
			AlchemyRecipeRegistry.registerRecipe(Parts.hearts, 2, new ItemStack[]{(Parts.flesh),(Parts.flesh), (Parts.bone), (Parts.diamond)}, 2);
		}

		JCModTweaks.log.info("Jaded made an alchemy lab");
	}

	private static void addRecipes() {

		if (Loader.isModLoaded("exnihilo"))
		{
			if (Parts.knife !=null)
			{
				RecipeRemover.removeAnyRecipe(Parts.knife);
			}
			if (Parts.altar !=null)
			{
				RecipeRemover.removeAnyRecipe(Parts.altar);
			}

			GameRegistry.addRecipe(new ShapedOreRecipe((Parts.knife),
					"GGG",
					"XFG",
					"FXG",
					'F', Parts.flint,
					'G', "blockGlass"
					));

			if (Parts.searedbrick !=null){
				GameRegistry.addRecipe(new ShapedOreRecipe((Parts.altar),
						"SXS",
						"SFS",
						"TLT",
						'S', "stone",
						'F', Parts.furnace,
						'T', Parts.searedbrick,
						'L', Parts.flint
						));
			}
		}
		JCModTweaks.log.info("BloodMagic Tweaks Loaded");
	}
}
