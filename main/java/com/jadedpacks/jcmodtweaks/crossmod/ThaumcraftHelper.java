package com.jadedpacks.jcmodtweaks.crossmod;




import java.util.ArrayList;

import com.jadedpacks.jadedbase.helpers.Parts;
import com.jadedpacks.jadedbase.helpers.RecipeRemover;

import cpw.mods.fml.common.Loader;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.api.research.ResearchPage.PageType;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.ItemStackHolderInjector;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;




public class ThaumcraftHelper {

	public static void preInit(){
	}

	public static void init()
	{
		ItemStackHolderInjector.INSTANCE.inject();
		removeRecipes();
		setupResearch();
		//initAspects();
		addAspects();
		addRecipes();
	}




	public static void addAspects(){

		ThaumcraftApi.registerObjectTag("listAllseed", (new AspectList()).add(Aspect.CROP, 4).add(Aspect.HARVEST, 3));
		ThaumcraftApi.registerObjectTag("listAlljuice", (new AspectList()).add(Aspect.WATER, 4).add(Aspect.VOID, 4).add(Aspect.COLD, 3));
		ThaumcraftApi.registerObjectTag("listAllsmoothie", (new AspectList()).add(Aspect.WATER, 4).add(Aspect.VOID, 4).add(Aspect.COLD, 3));
		ThaumcraftApi.registerObjectTag("listAllveggie", (new AspectList()).add(Aspect.EARTH, 4).add(Aspect.LIFE, 4).add(Aspect.CROP, 3));
		ThaumcraftApi.registerObjectTag("listAllfruit", (new AspectList()).add(Aspect.WATER, 4).add(Aspect.LIFE, 4).add(Aspect.EARTH, 3));
		ThaumcraftApi.registerObjectTag("itemSkull", (new AspectList()).add(Aspect.DEATH, 4).add(Aspect.UNDEAD, 4));
		ThaumcraftApi.registerObjectTag("nuggetArdite", (new AspectList()).add(Aspect.METAL, 4).add(Aspect.SOUL, 4).add(Aspect.FIRE, 3));
		ThaumcraftApi.registerObjectTag("nuggetCobalt", (new AspectList()).add(Aspect.METAL, 4).add(Aspect.SOUL, 4).add(Aspect.FIRE, 3));
		ThaumcraftApi.registerObjectTag("nuggetManyullyn", (new AspectList()).add(Aspect.METAL, 4).add(Aspect.SOUL, 4).add(Aspect.FIRE, 3));



	}

	private static void setupResearch() {

		if (Loader.isModLoaded("recallstones"))		//Only adds the recipes if recall stones are present
		{
			ResearchCategories.registerCategory("AGRIMANCY", new ResourceLocation("jcmodtweaks", "textures/aspects/purpura.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));

			(new JCResearchItem("RECALLSTONE", "AGRIMANCY", (new AspectList()).add(Aspect.MAGIC, 3).add(Aspect.MOTION, 2), 2, 0, 2,
					(Parts.recallStone))).setPages(new ResearchPage[]
							{ new ResearchPage("jcmodtweaks.research_page.RECALLSTONE"), new ResearchPage((IArcaneRecipe)
									ThaumcraftApi.addArcaneCraftingRecipe("RECALLSTONE", Parts.recallStone, (new AspectList()).add(Aspect.EARTH, 5).add(Aspect.ORDER, 3), "SES", "EDE", "SES", Character.valueOf('S'), Parts.stone, Character.valueOf('E'), Parts.epearl, Character.valueOf('D'), Parts.diamond)) }).setParents(new String[] { "RESEARCH" }).registerResearchItem();


			(new JCResearchItem("DIMENSIONSTONE", "AGRIMANCY", (new AspectList()).add(Aspect.ELDRITCH, 3).add(Aspect.MOTION, 2), 2, -1, 2,
					(Parts.dimensionStone))).setPages(new ResearchPage[]
							{ new ResearchPage("jcmodtweaks.research_page.DIMENSIONSTONE"), new ResearchPage((IArcaneRecipe)
									ThaumcraftApi.addArcaneCraftingRecipe("DIMENSIONSTONE", Parts.dimensionStone, (new AspectList()).add(Aspect.ENTROPY, 5).add(Aspect.ORDER, 3), "BEB", "ERE", "BEB", Character.valueOf('B'), Parts.blazerod, Character.valueOf('E'), Parts.epearl, Character.valueOf('R'), Parts.recallStone)) }).setParents(new String[] { "RECALLSTONE" }).registerResearchItem();

		}

		//add recipes for ore conversions


		if (Loader.isModLoaded("ThermalExpansion"))
		{
			(new JCResearchItem("MAGICORES", "AGRIMANCY", (new AspectList()).add(Aspect.METAL, 8).add(Aspect.ENTROPY, 5).add(Aspect.EXCHANGE, 4), 1, 0, 2,
					(Parts.fireOre))).setPages(new ResearchPage[]
							{ new ResearchPage("jcmodtweaks.research_page.MAGICORES"), new ResearchPage((CrucibleRecipe)
									ThaumcraftApi.addCrucibleRecipe("MAGICORES", Parts.airOre, Parts.stone, (new AspectList()).add(Aspect.AIR, 10).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("MAGICORES", Parts.waterOre, Parts.stone, (new AspectList()).add(Aspect.WATER, 10).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe)ThaumcraftApi.addCrucibleRecipe("MAGICORES", Parts.fireOre, Parts.stone, (new AspectList()).add(Aspect.FIRE, 10).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("MAGICORES", Parts.earthOre, Parts.stone, (new AspectList()).add(Aspect.EARTH, 10).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("MAGICORES", Parts.orderOre, Parts.stone, (new AspectList()).add(Aspect.ORDER, 10).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("MAGICORES", Parts.chaosOre, Parts.stone, (new AspectList()).add(Aspect.ENTROPY, 10).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("MAGICORES", Parts.mithrilOre, Parts.tinOre, (new AspectList()).add(Aspect.MAGIC, 5).add(Aspect.EXCHANGE, 3)))}).setParents(new String[] { "RESEARCH" }).registerResearchItem();
		}


		if (Parts.heart1 !=null && (Parts.heart3 !=null && (Parts.heart5 !=null && (Parts.necrotic !=null && (Parts.magnumtorch !=null)))))
		{
			(new JCResearchItem("PROTECTION", "AGRIMANCY", (new AspectList()).add(Aspect.LIFE, 8).add(Aspect.SOUL, 5).add(Aspect.ARMOR, 4), 3, 0, 2,
					(Parts.heart1))).setPages(new ResearchPage[]
							{ new ResearchPage("jcmodtweaks.research_page.PROTECTION"), new ResearchPage((CrucibleRecipe)
									ThaumcraftApi.addCrucibleRecipe("PROTECTION", Parts.heart1, Parts.diamond, (new AspectList()).add(Aspect.LIFE, 5).add(Aspect.SOUL, 3).add(Aspect.ARMOR, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("PROTECTION", Parts.heart3, Parts.goldingot, (new AspectList()).add(Aspect.LIFE, 5).add(Aspect.SOUL, 3).add(Aspect.ARMOR, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("PROTECTION", Parts.heart5, Parts.emerald, (new AspectList()).add(Aspect.LIFE, 5).add(Aspect.SOUL, 3).add(Aspect.ARMOR, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("PROTECTION", Parts.necrotic, Parts.bone, (new AspectList()).add(Aspect.LIFE, 5).add(Aspect.SOUL, 3).add(Aspect.ARMOR, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("PROTECTION", Parts.magnumtorch, Parts.blockDiamond, (new AspectList()).add(Aspect.LIGHT, 5).add(Aspect.SOUL, 3).add(Aspect.ARMOR, 3)))}).setParents(new String[] { "RESEARCH" }).registerResearchItem();

		}
		if (Loader.isModLoaded("ForbiddenMagic")&& (Loader.isModLoaded("harvestcraft")))
		{
			(new JCResearchItem("SINFULL", "AGRIMANCY", (new AspectList()).add(Aspect.LIFE, 8).add(Aspect.SOUL, 5).add(Aspect.ENERGY, 5), 0, 0, 2,
					(Parts.gluttonShard))).setPages(new ResearchPage[]
							{ new ResearchPage("jcmodtweaks.research_page.SINFULL"), new ResearchPage((CrucibleRecipe)
									ThaumcraftApi.addCrucibleRecipe("SINFULL", Parts.wrathShard, Parts.tnt, (new AspectList()).add(Aspect.ENTROPY, 5).add(Aspect.SOUL, 3).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("SINFULL", Parts.envyShard, Parts.stone, (new AspectList()).add(Aspect.GREED, 5).add(Aspect.SOUL, 3).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("SINFULL", Parts.taintShard, Parts.slimeball, (new AspectList()).add(Aspect.TAINT, 5).add(Aspect.SOUL, 3).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("SINFULL", Parts.prideShard, Parts.diamond, (new AspectList()).add(Aspect.GREED, 5).add(Aspect.SOUL, 3).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("SINFULL", Parts.lustShard, Parts.leather, (new AspectList()).add(Aspect.AURA, 5).add(Aspect.SOUL, 3).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("SINFULL", Parts.slothShard, Parts.bed, (new AspectList()).add(Aspect.BEAST, 5).add(Aspect.SOUL, 3).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("SINFULL", Parts.greedShard, Parts.goldingot, (new AspectList()).add(Aspect.GREED, 5).add(Aspect.SOUL, 3).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((CrucibleRecipe) ThaumcraftApi.addCrucibleRecipe("SINFULL", Parts.gluttonShard, Parts.beefwellington, (new AspectList()).add(Aspect.HUNGER, 5).add(Aspect.SOUL, 3).add(Aspect.EXCHANGE, 3)))}).setParents(new String[] { "RESEARCH" }).registerResearchItem();

		}

		if (Loader.isModLoaded("customnpcs"))
		{
			(new JCResearchItem("ULTIMATE", "AGRIMANCY", (new AspectList()).add(Aspect.BEAST, 20).add(Aspect.SOUL, 20).add(Aspect.ENERGY, 20), 1, -1, 2,
					(Parts.diamond))).setPages(new ResearchPage[]
							{ new ResearchPage("jcmodtweaks.research_page.ULTIMATE"), new ResearchPage((CrucibleRecipe)
									ThaumcraftApi.addCrucibleRecipe("ULTIMATE", Parts.goldcoin, Parts.goldingot, (new AspectList()).add(Aspect.MAGIC, 5).add(Aspect.GREED, 3).add(Aspect.EXCHANGE, 3))),
									new ResearchPage((IArcaneRecipe) ThaumcraftApi.addArcaneCraftingRecipe("ULTIMATE", Parts.ruby, (new AspectList()).add(Aspect.FIRE, 100).add(Aspect.ORDER, 50), "SES", "EFE", "SES", Character.valueOf('S'), Parts.stone, Character.valueOf('E'), Parts.epearl, Character.valueOf('F'), Parts.fireelement)),
									new ResearchPage((InfusionRecipe) ThaumcraftApi.addInfusionCraftingRecipe("ULTIMATE", Parts.ocarina, 2, (new AspectList()).add(Aspect.AURA, 100).add(Aspect.ORDER, 100), Parts.artifact, new ItemStack [] {Parts.npcmana, Parts.npcmana}))}).setParents(new String[] { "RESEARCH" }).registerResearchItem();
		}

	}




	private static void removeRecipes() {

		if (Loader.isModLoaded("recallstones"))
		{
			if (Parts.recallStone !=null && (Parts.dimensionStone !=null))
			{
				RecipeRemover.removeAnyRecipe(Parts.recallStone);
				RecipeRemover.removeAnyRecipe(Parts.dimensionStone);
			}
		}

	}
	private static void addRecipes() {}
	public static void postInit() {


	}
}
