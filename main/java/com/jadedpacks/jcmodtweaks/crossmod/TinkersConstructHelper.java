package com.jadedpacks.jcmodtweaks.crossmod;



import com.jadedpacks.jadedbase.helpers.Parts;
import com.jadedpacks.jadedbase.helpers.RecipeRemover;
import com.jadedpacks.jcmodtweaks.JCModTweaks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.DryingRackRecipes;
import tconstruct.library.crafting.LiquidCasting;
import tconstruct.library.crafting.DryingRackRecipes.DryingRecipe;



import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class TinkersConstructHelper {


	public static void preInit(){		}

	public static void init(){
	}
	public static void postInit() {
		addRecipes();
	}


	private static void addRecipes() {


		GameRegistry.addRecipe(new ShapedOreRecipe(Parts.heart6,
				"EH",
				"CX",

				'E', "gemEmerald",
				'H', Parts.heart5,
				'C', Parts.heart4
				));

		GameRegistry.addRecipe(new ShapedOreRecipe(Parts.heart2,
				"EH",
				"CX",

				'E', "tincanister",
				'H', Parts.heart1,
				'C', Parts.heart
				));

		GameRegistry.addRecipe(new ShapedOreRecipe(Parts.heart4,
				"EH",
				"CX",

				'E', "ingotGold",
				'H', Parts.heart3,
				'C', Parts.heart2
				));


		if (Loader.isModLoaded("harvestcraft"))
		{
			//needs an item or block not an itemstack
			DryingRackRecipes.addDryingRecipe(Parts.apple, 100, Parts.raisins);
			DryingRackRecipes.addDryingRecipe(Parts.lemon, 100, Parts.raisins);
			DryingRackRecipes.addDryingRecipe(Parts.grape, 100, Parts.raisins);
			DryingRackRecipes.addDryingRecipe(Parts.strawberry, 100, Parts.raisins);
		}

		if (Loader.isModLoaded("ExtraUtilities"))
		{
			//remove default spike recipes
			RecipeRemover.removeShapedRecipe(Parts.spikegold);
			RecipeRemover.removeShapedRecipe(Parts.spikediamond);
			RecipeRemover.removeShapedRecipe(Parts.spikeiron);
			//add smeltery spike recipes
			LiquidCasting tableCasting = TConstructRegistry.instance.getTableCasting();
			tableCasting.addCastingRecipe(Parts.superwand, Parts.tcardite, Parts.builderswand, true, 80);
			tableCasting.addCastingRecipe(Parts.spikeiron1, Parts.tciron, Parts.spikebase, true, 80);
			tableCasting.addCastingRecipe(Parts.spikegold1, Parts.tcgold, Parts.spikeiron1, true, 80);
			tableCasting.addCastingRecipe(Parts.spikediamond1, Parts.tcardite, Parts.spikegold1, true, 80);
			JCModTweaks.log.info("Jaded made spikes need a smeltery");

		}
		if (Loader.isModLoaded("appliedenergistics2"))
		{
			LiquidCasting tableCasting = TConstructRegistry.instance.getTableCasting();
			tableCasting.addCastingRecipe(Parts.press1, Parts.tclead, null, true, 80);
			tableCasting.addCastingRecipe(Parts.press2, Parts.tctin, null, true, 80);
			tableCasting.addCastingRecipe(Parts.press3, Parts.tccopper, null, true, 80);
			tableCasting.addCastingRecipe(Parts.press4, Parts.tcnickel, null, true, 80);
		}

		if (Loader.isModLoaded("harvestcraft") && (Loader.isModLoaded("IguanaTweaksTConstruct")))

		{
			RecipeRemover.removeAnyRecipe(Parts.pot);
			RecipeRemover.removeAnyRecipe(Parts.saucepan);
			LiquidCasting tableCasting = TConstructRegistry.instance.getTableCasting();
			tableCasting.addCastingRecipe(Parts.pot, Parts.moltenaluminumbrass, Parts.clayBucket, true, 80);
			tableCasting.addCastingRecipe(Parts.saucepan, Parts.moltenaluminum, Parts.rawclayBucket, true, 80);
			JCModTweaks.log.info("Jaded made harvestcraft tools require a smeltery");

			if (OreDictionary.getOres("gearWood").size() > 0)
			{
				ItemStack gearWood = new ItemStack (GameRegistry.findItem("appliedenergistics2", "item.ItemMultiMaterial"), 1, 40);
				tableCasting.addCastingRecipe(Parts.gearCast, Parts.moltenaluminumbrass, gearWood, true, 80);
			}
			else
				JCModTweaks.log.info("No Wood Gear");
		}
		JCModTweaks.log.info("JCTinker Tweaks Loaded");
	}

}



