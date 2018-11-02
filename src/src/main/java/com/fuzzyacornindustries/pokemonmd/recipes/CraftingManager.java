package com.fuzzyacornindustries.pokemonmd.recipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.EnumPotionID;
import com.fuzzyacornindustries.pokemonmd.library.LibraryClayColors;
import com.fuzzyacornindustries.pokemonmd.library.LibraryDye;
import com.fuzzyacornindustries.pokemonmd.library.LibraryWoolColors;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingManager
{
	public static void mainRegistry()
	{
		addCraftingRecipes();
		addSmeltingRecipes();
	}

	public static void addCraftingRecipes()
	{
		/* *********** Void Scissors *********** */
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.voidScissors, 1), new Object[]{"O O", "X X", " Q ", 'Q', Blocks.quartz_block, 'X', PokemonMDItem.xelNagaCircuit, 'O', Blocks.obsidian});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 2), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.diamond_helmet});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 4), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.diamond_chestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 3), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.diamond_leggings});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 1), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.diamond_boots});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 3), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.iron_helmet});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 5), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.iron_chestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 4), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.iron_leggings});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.iron_boots});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 3), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.chainmail_helmet});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 5), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.chainmail_chestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 4), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.chainmail_leggings});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.chainmail_boots});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 3), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.golden_helmet});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 5), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.golden_chestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 4), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.golden_leggings});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 2), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.golden_boots});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 4), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.leather_helmet});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 6), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.leather_chestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 5), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.leather_leggings});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 3), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.leather_boots});

		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.silkscreenAlloy, 3), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), PokemonMDItem.silkscreenHelmet});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.silkscreenAlloy, 5), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), PokemonMDItem.silkscreenChestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.silkscreenAlloy, 4), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), PokemonMDItem.silkscreenLeggings});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.silkscreenAlloy, 2), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), PokemonMDItem.silkscreenBoots});

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 7), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Blocks.chest});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 7), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.diamond_horse_armor});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 7), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.golden_horse_armor});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 7), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.iron_horse_armor});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 7), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.saddle});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.bucket});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 3), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.compass});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 3), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.clock});


		/* *********** Mystic Tech *********** */
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.xelNagaShard, 8), new Object[]{PokemonMDBlock.xelNagaTechBlock});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.xelNagaCircuit, 1), new Object[]{"QVQ", "#X#", "QVQ", '#', Items.glowstone_dust, 'V', PokemonMDBlock.voidGlass, 'Q', Items.quartz, 'X', PokemonMDItem.xelNagaShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.xelNagaCircuit, 1), new Object[]{"Q#Q", "VXV", "Q#Q", '#', Items.glowstone_dust, 'V', PokemonMDBlock.voidGlass, 'Q', Items.quartz, 'X', PokemonMDItem.xelNagaShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.xelNagaCircuit, 1), new Object[]{"QVQ", "#X#", "QVQ", '#', Items.glowstone_dust, 'V', PokemonMDBlock.voidGlass, 'Q', PokemonMDItem.tiberiumShard, 'X', PokemonMDItem.xelNagaShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.xelNagaCircuit, 1), new Object[]{"Q#Q", "VXV", "Q#Q", '#', Items.glowstone_dust, 'V', PokemonMDBlock.voidGlass, 'Q', PokemonMDItem.tiberiumShard, 'X', PokemonMDItem.xelNagaShard});

		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.xelNagaTechBlock, 1), new Object[]{"###", "# #", "###", '#', PokemonMDItem.xelNagaShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.voidGlass, 4), new Object[]{" # ", "#X#", " # ", '#', Blocks.glass, 'X', PokemonMDItem.xelNagaShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.xelNagaDynamo, 1), new Object[]{"QOQ", "CTC", "QOQ", 'Q', Blocks.quartz_block, 'O', Blocks.obsidian, 'C', PokemonMDItem.xelNagaCircuit, 'T', PokemonMDBlock.xelNagaTechBlock});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.xelNagaDynamo, 1), new Object[]{"TOT", "CXC", "TOT", 'T', PokemonMDBlock.tiberiumBlock, 'O', Blocks.obsidian, 'C', PokemonMDItem.xelNagaCircuit, 'X', PokemonMDBlock.xelNagaTechBlock});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.xelNagaPylon, 1), new Object[]{"VVV", "ODO", "QCQ", 'Q', Blocks.quartz_block, 'O', Blocks.obsidian, 'C', PokemonMDItem.xelNagaCircuit, 'V', PokemonMDBlock.voidGlass, 'D', PokemonMDBlock.xelNagaDynamo});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.xelNagaPylon, 1), new Object[]{"VVV", "ODO", "TCT", 'T', PokemonMDBlock.tiberiumBlock, 'O', Blocks.obsidian, 'C', PokemonMDItem.xelNagaCircuit, 'V', PokemonMDBlock.voidGlass, 'D', PokemonMDBlock.xelNagaDynamo});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.verdantPurifier, 1), new Object[]{"VCV", "QTQ", "OOO", 'V', PokemonMDBlock.voidGlass, 'C', PokemonMDItem.xelNagaCircuit, 'Q', Blocks.quartz_block, 'T', PokemonMDBlock.xelNagaTechBlock, 'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.verdantPurifier, 1), new Object[]{"VCV", "TXT", "OOO", 'V', PokemonMDBlock.voidGlass, 'C', PokemonMDItem.xelNagaCircuit, 'T', PokemonMDBlock.tiberiumBlock, 'X', PokemonMDBlock.xelNagaTechBlock, 'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.vespeneCondenser, 1), new Object[]{"CQC", "QEQ", "ODO", 'C', PokemonMDItem.xelNagaCircuit, 'Q', Blocks.quartz_block, 'E', Blocks.emerald_block, 'O', Blocks.obsidian, 'D', PokemonMDBlock.xelNagaDynamo});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.vespeneCondenser, 1), new Object[]{"CTC", "TET", "ODO", 'C', PokemonMDItem.xelNagaCircuit, 'T', PokemonMDBlock.tiberiumBlock, 'E', Blocks.emerald_block, 'O', Blocks.obsidian, 'D', PokemonMDBlock.xelNagaDynamo});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.tabletManufactory, 1), new Object[]{"COC", "CTC", "CQC", 'C', PokemonMDItem.xelNagaCircuit, 'Q', Blocks.quartz_block, 'O', Blocks.obsidian, 'T', PokemonMDBlock.xelNagaTechBlock});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.tabletManufactory, 1), new Object[]{"COC", "CXC", "CTC", 'C', PokemonMDItem.xelNagaCircuit, 'T', PokemonMDBlock.tiberiumBlock, 'O', Blocks.obsidian, 'X', PokemonMDBlock.xelNagaTechBlock});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.warpTech, 1), new Object[]{"XVX", "QEQ", "XVX", 'X', PokemonMDItem.xelNagaCircuit, 'V', PokemonMDBlock.voidGlass, 'Q', Items.quartz, 'E', Items.ender_pearl});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.warpTech, 1), new Object[]{"XVX", "TET", "XVX", 'X', PokemonMDItem.xelNagaCircuit, 'V', PokemonMDBlock.voidGlass, 'T', PokemonMDItem.tiberiumShard, 'E', Items.ender_pearl});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.teleportBarrel, 1), new Object[]{"VQG", " WX", "VQG", 'X', PokemonMDItem.xelNagaCircuit, 'V', PokemonMDBlock.voidGlass, 'Q', Items.quartz, 'G', Items.glowstone_dust, 'W', PokemonMDItem.warpTech});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.teleportBarrel, 1), new Object[]{"VTG", " WX", "VTG", 'X', PokemonMDItem.xelNagaCircuit, 'V', PokemonMDBlock.voidGlass, 'T', PokemonMDItem.tiberiumShard, 'G', Items.glowstone_dust, 'W', PokemonMDItem.warpTech});


		/* *********** Silkscreen Alloy *********** */
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenMesh, 1), new Object[]{" # ", "#A#", " # ", '#', Items.string, 'A', PokemonMDItem.aurumDust});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenAxe, 1), new Object[]{"## ", "#S ", " S ", '#', PokemonMDItem.silkscreenAlloy, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenHoe, 1), new Object[]{"## ", " S ", " S ", '#', PokemonMDItem.silkscreenAlloy, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenPickaxe, 1), new Object[]{"###", " S ", " S ", '#', PokemonMDItem.silkscreenAlloy, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenShovel, 1), new Object[]{" # ", " S ", " S ", '#', PokemonMDItem.silkscreenAlloy, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenSword, 1), new Object[]{" # ", " # ", " S ", '#', PokemonMDItem.silkscreenAlloy, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.spiderkissSword, 1), new Object[]{" S", "S#", '#', PokemonMDItem.silkscreenSword, 'S', Items.spider_eye});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.spiderkissSword, 1), new Object[]{"E# ", "E# ", " S ", '#', PokemonMDItem.silkscreenAlloy, 'S', Items.stick, 'E', Items.spider_eye});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenBoots, 1), new Object[]{"# #", "# #", '#', PokemonMDItem.silkscreenAlloy});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenChestplate, 1), new Object[]{"# #", "###", "###", '#', PokemonMDItem.silkscreenAlloy});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenHelmet, 1), new Object[]{"###", "# #", '#', PokemonMDItem.silkscreenAlloy});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenLeggings, 1), new Object[]{"###", "# #", "# #", '#', PokemonMDItem.silkscreenAlloy});


		/* *********** Challenger Set *********** */
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.challengerAlloy, 1), new Object[]{" A ", "RIL", " A ", 'A', PokemonMDItem.aurumDust, 'R', Blocks.redstone_block, 'I', Items.iron_ingot, 'L', Blocks.lapis_block});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.challengerBlock, 1), new Object[]{"CCC", "CCC", "CCC", 'C', PokemonMDItem.challengerAlloy});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.challengerAlloy, 9), new Object[]{PokemonMDBlock.challengerBlock});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.challengerBoots, 1), new Object[]{"# #", "# #", '#', PokemonMDItem.challengerAlloy});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.challengerChestplate, 1), new Object[]{"# #", "###", "###", '#', PokemonMDItem.challengerAlloy});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.challengerHelmet, 1), new Object[]{"###", "# #", '#', PokemonMDItem.challengerAlloy});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.challengerLeggings, 1), new Object[]{"###", "# #", "# #", '#', PokemonMDItem.challengerAlloy});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.khopeshOfBlight, 1), new Object[]{" ##", "  #", "B# ", '#', PokemonMDItem.challengerAlloy, 'B', Items.blaze_rod});


		/* *********** Tiberium *********** */
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.tiberiumShard, 9), new Object[]{PokemonMDBlock.tiberiumBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.richTiberiumShard, 9), new Object[]{PokemonMDBlock.richTiberiumBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.neoTiberiumShard, 9), new Object[]{PokemonMDBlock.neoTiberiumBlock});

		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.tiberiumBlock, 1), new Object[]{"TTT", "TTT", "TTT", 'T', PokemonMDItem.tiberiumShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.richTiberiumBlock, 1), new Object[]{"TTT", "TTT", "TTT", 'T', PokemonMDItem.richTiberiumShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.neoTiberiumBlock, 1), new Object[]{"TTT", "TTT", "TTT", 'T', PokemonMDItem.neoTiberiumShard});

		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.tiberiumBricks, 2), new Object[]{"NTN", 'T', PokemonMDItem.tiberiumShard, 'N', Blocks.nether_brick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.tiberiumBricks, 2), new Object[]{"N", "T", "N", 'T', PokemonMDItem.tiberiumShard, 'N', Blocks.nether_brick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.richTiberiumBricks, 4), new Object[]{" N ", "NTN", " N ", 'T', PokemonMDItem.richTiberiumShard, 'N', Blocks.nether_brick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.neoTiberiumBricks, 8), new Object[]{"NNN", "NTN", "NNN", 'T', PokemonMDItem.neoTiberiumShard, 'N', Blocks.nether_brick});


		/* *********** Tamable *********** */
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.firecrackerLittenSummon, 1), new Object[]{"FEF", "GAG", "TBT", 'F', Items.fireworks, 'E', Items.ender_eye, 'B', Items.blaze_powder, 'T', Blocks.tnt, 'A', PokemonMDItem.blessingOfArceus, 'G', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.firecrackerLittenSummon, 1), new Object[]{"OOO", "OFO", "OOO", 'O', PokemonMDItem.oranianBerry, 'F', PokemonMDItem.firecrackerLittenKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.firecrackerLittenSummon, 1), new Object[]{PokemonMDItem.reviveSeed, PokemonMDItem.firecrackerLittenKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.foxfireZoruaSummon, 1), new Object[]{"BRB", "RAR", "BWB", 'W', PokemonMDItem.willOfTheAncients, 'B', Items.blaze_powder, 'R', PokemonMDItem.rawstettaBerry, 'A', PokemonMDItem.blessingOfArceus});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.foxfireZoruaSummon, 1), new Object[]{"OOO", "OFO", "OOO", 'O', PokemonMDItem.oranianBerry, 'F', PokemonMDItem.foxfireZoruaKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.foxfireZoruaSummon, 1), new Object[]{PokemonMDItem.reviveSeed, PokemonMDItem.foxfireZoruaKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.ionianNinetalesSummon, 1), new Object[]{"BBB", "EWE", "RAR", 'W', PokemonMDItem.willOfTheAncients, 'B', Items.blaze_powder, 'E', Items.ender_eye, 'R', PokemonMDItem.rawstettaBerry, 'A', PokemonMDItem.blessingOfArceus});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.ionianNinetalesSummon, 1), new Object[]{"OOO", "OIO", "OOO", 'O', PokemonMDItem.oranianBerry, 'I', PokemonMDItem.ionianNinetalesKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.ionianNinetalesSummon, 1), new Object[]{PokemonMDItem.reviveSeed, PokemonMDItem.ionianNinetalesKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.okamiEspeonSummon, 1), new Object[]{"GBG", "DSD", "BAB", 'G', Items.gold_ingot, 'D', Items.diamond, 'S', Items.diamond_sword, 'B', Items.blaze_rod, 'A', PokemonMDItem.blessingOfArceus});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.okamiEspeonSummon, 1), new Object[]{"OOO", "OSO", "OOO", 'O', PokemonMDItem.oranianBerry, 'S', PokemonMDItem.okamiEspeonKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.okamiEspeonSummon, 1), new Object[]{PokemonMDItem.reviveSeed, PokemonMDItem.okamiEspeonKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.okamiSylveonSummon, 1), new Object[]{"GOG", "DSD", "PAP", 'G', new ItemStack(Blocks.stained_hardened_clay, 1, LibraryClayColors.GREEN), 'O', Blocks.obsidian, 'D', Items.diamond, 'S', Items.diamond_sword, 'P', new ItemStack(Blocks.wool, 1, LibraryWoolColors.PINK), 'A', PokemonMDItem.blessingOfArceus});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.okamiSylveonSummon, 1), new Object[]{"OOO", "OSO", "OOO", 'O', PokemonMDItem.oranianBerry, 'S', PokemonMDItem.okamiSylveonKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.okamiSylveonSummon, 1), new Object[]{PokemonMDItem.reviveSeed, PokemonMDItem.okamiSylveonKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.okamiUmbreonSummon, 1), new Object[]{"GGG", "ISI", "GAG", 'I', Items.iron_ingot, 'S', Items.iron_sword, 'G', Items.glowstone_dust, 'A', PokemonMDItem.blessingOfArceus});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.okamiUmbreonSummon, 1), new Object[]{"OOO", "OSO", "OOO", 'O', PokemonMDItem.oranianBerry, 'S', PokemonMDItem.okamiUmbreonKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.okamiUmbreonSummon, 1), new Object[]{PokemonMDItem.reviveSeed, PokemonMDItem.okamiUmbreonKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.essenceRecaller, 1), new Object[]{" I ", "FEF", " I ", 'I', Items.iron_ingot, 'F', PokemonMDItem.dreamFeather, 'E', Items.ender_pearl});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.attackOrderer, 1), new Object[]{"ATA", " I ", " I ", 'I', Items.iron_ingot, 'A', PokemonMDItem.aurumDust, 'T', PokemonMDItem.tiberiumShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.attackOrderer, 1), new Object[]{"ATA", " I ", " I ", 'I', Items.iron_ingot, 'A', PokemonMDItem.aurumDust, 'T', PokemonMDItem.richTiberiumShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.attackOrderer, 1), new Object[]{"ATA", " I ", " I ", 'I', Items.iron_ingot, 'A', PokemonMDItem.aurumDust, 'T', PokemonMDItem.neoTiberiumShard});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.reviveSeed, 1), new Object[]{"AAA", "AOA", "AAA", 'A', PokemonMDItem.aurumDust, 'O', PokemonMDItem.oranianBerry});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.attackBoost, 1), new Object[]{"AAA", "BHB", "SSS", 'H', PokemonMDItem.huntersCharge, 'B', Blocks.redstone_block, 'S', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_SWIFTNESS_II.id()), 'A', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_STRENGTH_II.id())});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.lifeBoost, 1), new Object[]{"HHH", "VBV", "RRR", 'V', PokemonMDItem.verdantCharge, 'B', Blocks.redstone_block, 'H', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_HEALING_II.id()), 'R', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_REGEN_II.id())});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.lifeBoost, 1), new Object[]{"RRR", "VBV", "RRR", 'V', PokemonMDItem.verdantCharge, 'B', Blocks.redstone_block, 'R', PokemonMDItem.reviveSeed});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.firagaEssence, 1), new Object[]{"FFF", "BLB", "FFF", 'L', PokemonMDItem.lifeBoost, 'B', Blocks.redstone_block, 'F', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_FIRERESIST_EXT.id())});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.firagaEssence, 1), new Object[]{"FFF", "VVV", "FFF", 'V', PokemonMDItem.vespeneCrystal, 'F', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_FIRERESIST_EXT.id())});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.watergaEssence, 1), new Object[]{"WWW", "BLB", "WWW", 'L', PokemonMDItem.lifeBoost, 'B', Blocks.redstone_block, 'W', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_WATER_BREATHING_EXT.id())});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.watergaEssence, 1), new Object[]{"WWW", "VVV", "WWW", 'V', PokemonMDItem.vespeneCrystal, 'W', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_WATER_BREATHING_EXT.id())});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.watergaEssence, 1), new Object[]{"PPP", "BLB", "PPP", 'L', PokemonMDItem.lifeBoost, 'B', Blocks.redstone_block, 'P', PokemonMDItem.passhauraBerry});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.watergaEssence, 1), new Object[]{"PPP", "VVV", "PPP", 'V', PokemonMDItem.vespeneCrystal, 'P', PokemonMDItem.passhauraBerry});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.gravigaEssence, 1), new Object[]{"SSS", "BLB", "SSS", 'L', PokemonMDItem.lifeBoost, 'B', Blocks.redstone_block, 'S', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_SWIFTNESS_II.id())});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.gravigaEssence, 1), new Object[]{"SSS", "VVV", "SSS", 'V', PokemonMDItem.vespeneCrystal, 'S', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_SWIFTNESS_II.id())});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.quakagaEssence, 1), new Object[]{"III", "BLB", "III", 'L', PokemonMDItem.lifeBoost, 'B', Blocks.redstone_block, 'I', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_INVISIBILITY_EXT.id())});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.quakagaEssence, 1), new Object[]{"III", "VVV", "III", 'V', PokemonMDItem.vespeneCrystal, 'I', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_INVISIBILITY_EXT.id())});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.biogaEssence, 1), new Object[]{"PPP", "VLV", "PPP", 'L', PokemonMDItem.lifeBoost, 'V', PokemonMDItem.verdantCharge, 'P', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_POISON_II.id())});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.biogaEssence, 1), new Object[]{"CPC", "VVV", "PCP", 'V', PokemonMDItem.vespeneCrystal, 'C', PokemonMDItem.verdantCharge, 'P', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_POISON_II.id())});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.biogaEssence, 1), new Object[]{"PPP", "BLB", "PPP", 'L', PokemonMDItem.lifeBoost, 'B', Blocks.redstone_block, 'P', PokemonMDItem.pechitaBerry});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.biogaEssence, 1), new Object[]{"PPP", "VVV", "PPP", 'V', PokemonMDItem.vespeneCrystal, 'P', PokemonMDItem.pechitaBerry});


		/* *********** Turrets *********** */
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.mysticInitializer, 1), new Object[]{"XS", "QS", " S", 'X', PokemonMDItem.xelNagaCircuit, 'S', PokemonMDItem.xelNagaShard, 'Q', Items.quartz});

		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.prototurret, 1), new Object[]{" G ", "TXS", " Q ", 'X', PokemonMDItem.xelNagaCircuit, 'S', PokemonMDItem.xelNagaShard, 'Q', Items.quartz, 'G', Items.glowstone_dust, 'T', PokemonMDItem.teleportBarrel});


		/* *********** Hunter's Items *********** */
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.huntersCharm, 1), new Object[]{"BFL", "SAS", "LGB", 'A', PokemonMDItem.aurumRod, 'B', Items.bone, 'F', Items.flint, 'L', new ItemStack(Items.dye, 1, LibraryDye.LAPIS_LAZULI), 'S', Items.string, 'G', Items.gunpowder});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.huntersCharge, 1), new Object[]{"FLG", "LSL", "GLF", 'S', PokemonMDItem.silkscreenMesh, 'G', Items.gunpowder, 'F', Items.flint, 'L', new ItemStack(Items.dye, 1, LibraryDye.LAPIS_LAZULI)});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.bowofkindred, 1), new Object[]{"FHL", "HCL", "FHL", 'H', PokemonMDItem.huntersCharm, 'F', Items.flint, 'L', new ItemStack(Items.dye, 1, LibraryDye.LAPIS_LAZULI), 'C', PokemonMDItem.huntersCharge});

		GameRegistry.addRecipe(new EnchantmentRecipes(new ItemStack(PokemonMDItem.bowofkindred, 1), createRecipeList(new Object[]{new ItemStack(PokemonMDItem.bowofkindred, 1, OreDictionary.WILDCARD_VALUE), PokemonMDItem.huntersCharge})));


		/* *********** Miscellaneous *********** */
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.goldenChaff, 4), new Object[]{" S ", "SAS", " S ", 'A', PokemonMDItem.aurumDust, 'S', Items.wheat_seeds});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.goldenChaff, 4), new Object[]{" S ", "SAS", " S ", 'A', PokemonMDItem.aurumDust, 'S', Items.pumpkin_seeds});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.goldenChaff, 4), new Object[]{" S ", "SAS", " S ", 'A', PokemonMDItem.aurumDust, 'S', Items.melon_seeds});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.aurumRod, 1), new Object[]{"#", "#", "#", '#', PokemonMDItem.aurumDust});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.aurumRod, 1), new Object[]{"###", '#', PokemonMDItem.aurumDust});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.infernoFuelRod, 1), new Object[]{"P", "G", "R", 'R', PokemonMDItem.aurumRod, 'P', Items.paper, 'G', Items.gunpowder});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.infernoFuelRod, 1), new Object[]{"PGR", 'R', PokemonMDItem.aurumRod, 'P', Items.paper, 'G', Items.gunpowder});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.abyssalLiquidCrystal, 1), new Object[]{"GAG", "SES", " B ", 'A', PokemonMDItem.aurumRod, 'G', Items.glowstone_dust, 'S', Items.slime_ball, 'E', Items.ender_eye, 'B', new ItemStack(Items.potionitem, 1, 0)});

		GameRegistry.addRecipe(new ItemStack(PokemonMDBlock.packedAurumDust, 1), new Object[]{"AAA", "AAA", "AAA", 'A', PokemonMDItem.aurumDust});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.aurumDust, 9), new Object[]{PokemonMDBlock.packedAurumDust});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.willOfTheAncients, 1), new Object[]{" S ", "DWD", "EBE", 'E', Items.ender_eye, 'W', Items.writable_book, 'D', PokemonMDItem.aurumDust, 'S', Items.spider_eye});

		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.dreamFeather, 1), new Object[]{Items.feather, Items.glowstone_dust, PokemonMDItem.aurumDust});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItem.clayTablet, 1), new Object[]{"X", "H", 'X', PokemonMDItem.xelNagaShard, 'H', Blocks.hardened_clay});

		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.verdantCharge, 1), new Object[]{Items.wheat_seeds, Items.gunpowder, PokemonMDItem.aurumDust, new ItemStack(Items.dye, 1, LibraryDye.BONE_MEAL)});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.verdantGoo, 1), new Object[]{Items.wheat_seeds, Items.slime_ball, PokemonMDItem.aurumDust, new ItemStack(Items.dye, 1, LibraryDye.BONE_MEAL)});


		/* *********** Tablet Manufactory Recipes *********** */
		RecipesTabletManufactory.addRecipe(new ItemStack(PokemonMDItem.bioCapacitor), "TCT", "SVS", "TT ", 'C', PokemonMDItem.clayTablet, 'V', PokemonMDItem.vespeneCrystal, 'T', PokemonMDItem.tiberiumShard, 'S', Items.spider_eye);
		RecipesTabletManufactory.addRecipe(new ItemStack(PokemonMDItem.bioraCapacitor), "TCT", "SVS", "TT ", 'C', PokemonMDItem.bioCapacitor, 'V', PokemonMDItem.vespeneFuelRod, 'T', PokemonMDItem.richTiberiumShard, 'S', Items.spider_eye);
		RecipesTabletManufactory.addRecipe(new ItemStack(PokemonMDItem.biogaCapacitor), "TCT", "SVS", "TT ", 'C', PokemonMDItem.bioraCapacitor, 'V', PokemonMDItem.vespeneFuelRod, 'T', PokemonMDItem.neoTiberiumShard, 'S', Items.spider_eye);

		RecipesTabletManufactory.addRecipe(new ItemStack(PokemonMDItem.fireCapacitor), "TCT", "BVB", "TT ", 'C', PokemonMDItem.clayTablet, 'V', PokemonMDItem.vespeneCrystal, 'T', PokemonMDItem.tiberiumShard, 'B', Items.blaze_powder);
		RecipesTabletManufactory.addRecipe(new ItemStack(PokemonMDItem.firaCapacitor), "TCT", "BVB", "TT ", 'C', PokemonMDItem.fireCapacitor, 'V', PokemonMDItem.vespeneFuelRod, 'T', PokemonMDItem.richTiberiumShard, 'B', Items.blaze_powder);
		RecipesTabletManufactory.addRecipe(new ItemStack(PokemonMDItem.firagaCapacitor), "TCT", "BVB", "TT ", 'C', PokemonMDItem.firaCapacitor, 'V', PokemonMDItem.vespeneFuelRod, 'T', PokemonMDItem.neoTiberiumShard, 'B', Items.blaze_powder);

		RecipesTabletManufactory.addRecipe(new ItemStack(PokemonMDItem.barrierDefender), "TCT", "IVI", "TT ", 'C', PokemonMDItem.clayTablet, 'V', PokemonMDItem.vespeneFuelRod, 'T', PokemonMDItem.richTiberiumShard, 'I', Items.iron_ingot);
		RecipesTabletManufactory.addRecipe(new ItemStack(PokemonMDItem.regenUtility), "TCT", "XVX", "TT ", 'C', PokemonMDItem.clayTablet, 'V', PokemonMDItem.vespeneFuelRod, 'T', PokemonMDItem.neoTiberiumShard, 'X', PokemonMDItem.xelNagaCircuit);
		RecipesTabletManufactory.addRecipe(new ItemStack(PokemonMDItem.chaosCapacitor), "TCT", "DED", "TT ", 'C', PokemonMDItem.clayTablet, 'E', PokemonMDItem.emeraldOfChaos, 'T', PokemonMDItem.neoTiberiumShard, 'D', Items.diamond);

		RecipesTabletManufactory.addRecipe(new ItemStack(PokemonMDItem.xelNagaShard), "TOT", "GVG", "TT ", 'O', Blocks.obsidian, 'V', PokemonMDItem.vespeneCrystal, 'T', PokemonMDItem.tiberiumShard, 'G', Items.glowstone_dust);

		//RecipesTabletManufactory.addRecipe(output, inputList);

		/* *********** Battlegear Recipes *********** *//*
		if(PokemonMDMain.isBG2Enabled)
		{
			ItemStack woodenSpear = GameRegistry.findItemStack("battlegear2", "spear." + ToolMaterial.WOOD.name().toLowerCase(Locale.ENGLISH), 1);

			GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenDagger, 1), new Object[]{"#", "S", '#', PokemonMDItem.silkscreenAlloy, 'S', Items.stick});
			GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenWaraxe, 1), new Object[]{"# #", "#S#", " S ", '#', PokemonMDItem.silkscreenAlloy, 'S', Items.stick});
			GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenMace, 1), new Object[]{" ##", " ##", "S  ", '#', PokemonMDItem.silkscreenAlloy, 'S', Items.stick});

			if(woodenSpear != null)
			{
				GameRegistry.addRecipe(new ItemStack(PokemonMDItem.silkscreenSpear, 1), new Object[]{" #", "S ", '#', PokemonMDItem.silkscreenAlloy, 'S', woodenSpear});
			}

			GameRegistry.addRecipe(new ItemStack(PokemonMDItem.spiderkissDagger, 1), new Object[]{"S", "#", '#', PokemonMDItem.silkscreenDagger, 'S', Items.spider_eye});
			GameRegistry.addRecipe(new ItemStack(PokemonMDItem.spiderkissWaraxe, 1), new Object[]{"S S", "S#S", '#', PokemonMDItem.silkscreenWaraxe, 'S', Items.spider_eye});
			GameRegistry.addRecipe(new ItemStack(PokemonMDItem.spiderkissSpear, 1), new Object[]{" S ", "S#S", '#', PokemonMDItem.silkscreenSpear, 'S', Items.spider_eye});
			GameRegistry.addRecipe(new ItemStack(PokemonMDItem.spiderkissMace, 1), new Object[]{" S ", "S#S", '#', PokemonMDItem.silkscreenMace, 'S', Items.spider_eye});
		}


		/* *********** Zelda Sword Skills Recipes *********** *//*
		if(PokemonMDMain.isZeldaSwordSkillsEnabled)
		{
			ItemStack hylianShield = GameRegistry.findItemStack("zeldaswordskills", "zss.shield_hylian", 1);
			ItemStack kokiriHat = GameRegistry.findItemStack("zeldaswordskills", "zss.hero_tunic_helm", 1);
			ItemStack kokiriTunic = GameRegistry.findItemStack("zeldaswordskills", "zss.hero_tunic_chest", 1);
			ItemStack kokiriTrousers = GameRegistry.findItemStack("zeldaswordskills", "zss.hero_tunic_legs", 1);
			ItemStack kokiriBoots = GameRegistry.findItemStack("zeldaswordskills", "zss.hero_tunic_boots", 1);
			ItemStack kokiriSword = GameRegistry.findItemStack("zeldaswordskills", "zss.sword_kokiri", 1);
			ItemStack ordonSword = GameRegistry.findItemStack("zeldaswordskills", "zss.sword_ordon", 1);
			ItemStack boomerang = GameRegistry.findItemStack("zeldaswordskills", "zss.boomerang", 1);
			ItemStack silverGauntlets = GameRegistry.findItemStack("zeldaswordskills", "zss.gauntlets_silver", 1);
			ItemStack redPotion = GameRegistry.findItemStack("zeldaswordskills", "zss.potion_red", 1);
			ItemStack greenPotion = GameRegistry.findItemStack("zeldaswordskills", "zss.potion_green", 1);

			if(hylianShield != null)
				GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 9), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), hylianShield});

			if(kokiriHat != null)
				GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 6), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), kokiriHat});

			if(kokiriTunic != null)
				GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 9), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), kokiriTunic});

			if(kokiriTrousers != null)
				GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 8), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), kokiriTrousers});

			if(kokiriBoots != null)
				GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 5), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), kokiriBoots});

			if(kokiriSword != null)
				GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), kokiriSword});

			if(ordonSword != null)
				GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 4), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), ordonSword});

			if(boomerang != null)
				GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 9), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), boomerang});

			if(silverGauntlets != null)
				GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 18), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), silverGauntlets});

			if(redPotion != null)
				GameRegistry.addRecipe(new ItemStack(PokemonMDItem.lifeBoost, 1), new Object[]{"RRR", "VBV", "RRR", 'V', PokemonMDItem.verdantCharge, 'B', Blocks.redstone_block, 'R', redPotion});

			if(greenPotion != null)
				GameRegistry.addRecipe(new ItemStack(PokemonMDItem.lifeBoost, 1), new Object[]{"GGG", "VBV", "GGG", 'V', PokemonMDItem.verdantCharge, 'B', Blocks.redstone_block, 'G', greenPotion});
		}


		/* *********** Galacticraft Recipes *********** *//*
		if(PokemonMDMain.isGalacticraftEnabled)
		{	
			ItemStack oxygenGear = GameRegistry.findItemStack("GalacticraftCore", "item.oxygenGear", 1);
			ItemStack oxygenConcentrator = GameRegistry.findItemStack("GalacticraftCore", "item.oxygenConcentrator", 1);
			ItemStack oxygenMask = GameRegistry.findItemStack("GalacticraftCore", "item.oxygenMask", 1);
			ItemStack heavyOxygenTank = GameRegistry.findItemStack("GalacticraftCore", "item.oxygenTankHeavyFull", 1);

			if(oxygenGear != null && oxygenConcentrator != null)
				GameRegistry.addShapelessRecipe(oxygenConcentrator, new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), oxygenGear});

			if(oxygenMask != null)
				GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_helmet, 1), new Object[]{new ItemStack(PokemonMDItem.voidScissors, 1, OreDictionary.WILDCARD_VALUE), oxygenMask});

			if(heavyOxygenTank != null)
				GameRegistry.addRecipe(new ItemStack(PokemonMDItem.cometEssence, 1), new Object[]{"VWV", "BOB", "WVW", 'V', PokemonMDItem.verdantCharge, 'B', Blocks.redstone_block, 'O', heavyOxygenTank, 'W', new ItemStack(Items.potionitem, 1, EnumPotionID.POTION_WATER_BREATHING_EXT.id())});
		}


		/* *********** Food Plus Recipes *********** *//*
		if(PokemonMDMain.isFoodPlusEnabled)
		{
			ItemStack tomatoSeed = GameRegistry.findItemStack("FoodPlus", "tomato_seed", 1);
			ItemStack strawberrySeed = GameRegistry.findItemStack("FoodPlus", "strawberry_seed", 1);

			if(tomatoSeed != null)
			{
				GameRegistry.addRecipe(new ItemStack(PokemonMDItem.goldenChaff, 1), new Object[]{" S ", "SAS", " S ", 'A', PokemonMDItem.aurumDust, 'S', tomatoSeed});
				GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.verdantCharge, 1), new Object[]{tomatoSeed, Items.gunpowder, PokemonMDItem.aurumDust, new ItemStack(Items.dye, 1, LibraryDye.BONE_MEAL)});
				GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.verdantGoo, 1), new Object[]{tomatoSeed, Items.slime_ball, PokemonMDItem.aurumDust, new ItemStack(Items.dye, 1, LibraryDye.BONE_MEAL)});
			}

			if(strawberrySeed != null)
			{
				GameRegistry.addRecipe(new ItemStack(PokemonMDItem.goldenChaff, 1), new Object[]{" S ", "SAS", " S ", 'A', PokemonMDItem.aurumDust, 'S', strawberrySeed});
				GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.verdantCharge, 1), new Object[]{strawberrySeed, Items.gunpowder, PokemonMDItem.aurumDust, new ItemStack(Items.dye, 1, LibraryDye.BONE_MEAL)});
				GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItem.verdantGoo, 1), new Object[]{strawberrySeed, Items.slime_ball, PokemonMDItem.aurumDust, new ItemStack(Items.dye, 1, LibraryDye.BONE_MEAL)});
			}
		}*/
	}

	public static void addSmeltingRecipes()
	{
		GameRegistry.addSmelting(PokemonMDItem.aurumDust, new ItemStack(Items.gold_nugget), 0.2F);
		GameRegistry.addSmelting(PokemonMDBlock.packedAurumDust, new ItemStack(Items.gold_ingot), 1.0F);
	}

	public static List createRecipeList(Object ... param)
	{
		ArrayList arraylist = new ArrayList();
		Object[] aobject = param;
		int i = param.length;

		for (int j = 0; j < i; ++j)
		{
			Object object1 = aobject[j];

			if (object1 instanceof ItemStack)
			{
				arraylist.add(((ItemStack)object1).copy());
			}
			else if (object1 instanceof Item)
			{
				arraylist.add(new ItemStack((Item)object1));
			}
			else
			{
				if (!(object1 instanceof Block))
				{
					throw new RuntimeException("Invalid shapeless recipy!");
				}

				arraylist.add(new ItemStack((Block)object1));
			}
		}

		return arraylist;
	}
}