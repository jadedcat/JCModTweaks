package com.jadedpacks.jcmodtweaks.crossmod;



import com.jadedpacks.jadedbase.helpers.Parts;
import com.jadedpacks.jadedbase.helpers.RecipeRemover;
import com.jadedpacks.jcmodtweaks.JCModTweaks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;



import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.ItemStackHolderInjector;

public class ThermalExpansionHelper {
	public static void preInit(){}

	public static void init()

	{
		ItemStackHolderInjector.INSTANCE.inject();
		JCModTweaks.log.info("Jaded is now fiddling with ThermalExpansion, do not blame TeamCoFH for unexpected explosions");
		removeRecipes();
		addRecipes();
	}

	public static void postInit(){
		ItemStackHolderInjector.INSTANCE.inject();
		addSolarFlux();

	}

	private static void addSolarFlux() {

		if (Parts.mirror !=null&& (Parts.mirror2 !=null))
		{
			RecipeRemover.removeAnyRecipe(Parts.mirror);
			RecipeRemover.removeAnyRecipe(Parts.mirror2);
			GameRegistry.addRecipe(new ShapedOreRecipe(Parts.mirror,
					"III",
					"XSX",
					'I', "blockGlass",
					'S', "ingotSilver"
					));
			JCModTweaks.log.info("Jaded is rearranging solar panels for maximum sunlight or pain, one or the other, possibly both");

		}
		else
		{
			JCModTweaks.log.info("Mirror is missing");
		}

	}

	private static void removeRecipes() {

		if (Loader.isModLoaded("Forestry"))
		{
			if (Parts.copperBlock !=null && (Parts.tinBlock !=null));
			{
				RecipeRemover.removeAnyRecipe(Parts.copperBlock);
				RecipeRemover.removeAnyRecipe(Parts.tinBlock);
				JCModTweaks.log.info("Jaded is removing Forestry storage blocks because people wanted the other textures");
			}
		}

	}
	private static void addRecipes() {



		//IMC Recipes
		NBTTagCompound toSend = new NBTTagCompound();

		//mithril ore
		toSend.setInteger("energy", 2000);
		toSend.setTag("input", new NBTTagCompound());
		toSend.setTag("output", new NBTTagCompound());
		toSend.setTag("fluid", new NBTTagCompound());
		Parts.platinumOre.writeToNBT(toSend.getCompoundTag("input"));
		Parts.mithrilOre.writeToNBT(toSend.getCompoundTag("output"));
		Parts.temana.writeToNBT(toSend.getCompoundTag("fluid"));
		FMLInterModComms.sendMessage("ThermalExpansion", "TransposerFillRecipe", toSend);
		toSend = new NBTTagCompound();



		if (Parts.platDust !=null)
		{

			toSend.setTag("primaryInput", new NBTTagCompound());
			toSend.setTag("secondaryInput", new NBTTagCompound());
			toSend.setTag("primaryOutput", new NBTTagCompound());
			toSend.setTag("secondaryOutput", new NBTTagCompound());
			toSend.setInteger("secondaryChance", 10);
			toSend.setInteger("energy", 2000);
			Parts.silverOre.writeToNBT(toSend.getCompoundTag("primaryInput"));
			Parts.platDust.writeToNBT(toSend.getCompoundTag("secondaryInput"));
			Parts.platinumIngot.writeToNBT(toSend.getCompoundTag("primaryOutput"));
			Parts.mithrilOre.writeToNBT(toSend.getCompoundTag("secondaryOutput"));
			FMLInterModComms.sendMessage("ThermalExpansion", "SmelterRecipe", toSend);
			toSend = new NBTTagCompound();
		}

		JCModTweaks.log.info("Jaded is adding mystical metals");
		JCModTweaks.log.info("JadedTweaks Thermal Expansion tweaks loaded");

	}

	public static void loadComplete() {

		if (Loader.isModLoaded("TConstruct"))
		{
			if (Parts.gearCopper !=null)
			{
				RecipeRemover.removeAnyRecipe(Parts.gearCopper);
			}
			RecipeRemover.removeAnyRecipe(Parts.gearIron);
			if (Parts.gearTin !=null)
			{
				RecipeRemover.removeAnyRecipe(Parts.gearTin);
			}
			RecipeRemover.removeAnyRecipe(Parts.gearGold);
			RecipeRemover.removeAnyRecipe(Parts.gearSilver);
			if (Parts.gearCopper !=null)
			{
				RecipeRemover.removeAnyRecipe(Parts.gearBronze);
			}
			RecipeRemover.removeAnyRecipe(Parts.gearNickel);
			RecipeRemover.removeAnyRecipe(Parts.gearPlatinum);
			RecipeRemover.removeAnyRecipe(Parts.gearMithril);
			RecipeRemover.removeAnyRecipe(Parts.gearElectrum);
			RecipeRemover.removeAnyRecipe(Parts.gearInvar);
			RecipeRemover.removeAnyRecipe(Parts.gearSignalum);
			RecipeRemover.removeAnyRecipe(Parts.gearLumium);
			RecipeRemover.removeAnyRecipe(Parts.gearEnderium);
			JCModTweaks.log.info("Jaded says use the smeltery for gear making");
		}


	}



}


