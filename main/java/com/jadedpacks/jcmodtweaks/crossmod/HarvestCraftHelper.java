package com.jadedpacks.jcmodtweaks.crossmod;

import mantle.utils.RecipeRemover;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.jadedpacks.jadedbase.helpers.OreDictionaryTweaks;
import com.jadedpacks.jadedbase.helpers.Parts;
import com.jadedpacks.jadedbase.helpers.Basic;
import com.jadedpacks.jadedbase.helpers.Wood;
import com.jadedpacks.jcmodtweaks.JCModTweaks;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class HarvestCraftHelper {




	public static void preInit(){}

	public static void init()
	{	}

	public static void postInit() {
		addRecipes();
	}

	private static void addRecipes()

	{
		if (Parts.claywater !=null && (Parts.freshwater !=null))
		{
			RecipeRemover.removeAnyRecipe(Parts.fwater);
			RecipeRemover.removeAnyRecipe(Parts.freshwater);
			GameRegistry.addRecipe(Parts.freshwater,
					"F",
					'F', Parts.claywater
					);

			GameRegistry.addRecipe(Parts.freshwater,
					"B",
					'B', Parts.bucketwater
					);

		}

		if (Loader.isModLoaded("Botania"))
		{
			if (OreDictionary.getOres("listAllgrain").size() > 0)
			{
				GameRegistry.addRecipe(new ShapelessOreRecipe(Parts.flour, Parts.woodmortar,"listAllgrain"));
			}
			else
			{
				GameRegistry.addRecipe(Parts.flour,
						"MG",
						'M', Parts.woodmortar,
						'G', Parts.wheat
						);
			}
		}

		if (OreDictionary.getOres("toolMortarandpestle").size() > 0)
		{
			GameRegistry.addRecipe(new ShapelessOreRecipe(Parts.flour,"toolMortarandpestle","cropPotato"));
		}
		JCModTweaks.log.info("Harvestcraft Tweaks Loaded");
	}
}

