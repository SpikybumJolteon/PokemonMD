package com.fuzzyacornindustries.pokemonmd.block;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class PokemonMDBlock
{
	public static void mainRegistry()
	{
		initializeItem();
		registerBlock();
	}

	public static Block colbertaBerryPlant;
	public static Block oranianBerryPlant;
	public static Block neoTiberiumBlock;
	public static Block neoTiberiumBricks;
	public static Block packedAurumDust;
	public static Block passhauraBerryPlant;
	public static Block pechitaBerryPlant;
	public static Block rawstettaBerryPlant;
	public static Block richTiberiumBlock;
	public static Block richTiberiumBricks;
	public static Block tiberiumBlock;
	public static Block tiberiumBricks;
	public static Block verdantPurifier;
	public static Block verdantPurifierActive;
	public static Block vespeneCondenser;
	public static Block vespeneCondenserActive;
	public static Block voidGlass;
	public static Block xelNagaDynamo;
	public static Block xelNagaPylon;
	public static Block xelNagaTechBlock;

	// Beta 1.1 Content
	public static Block challengerBlock;
	public static Block prototurret;
	public static Block tabletManufactory;
	public static Block tabletManufactoryActive;

	public static Block alchemenisizer;
	/*
	public static Block microFilter;
	public static Block microFilterActive;
	public static Block prototurret;
	public static Block vespeneCondenser;
	public static Block vespeneCondenserActive;
	 */
	public static void initializeItem()
	{
		colbertaBerryPlant = new BlockColbertaBerryPlant();
		oranianBerryPlant = new BlockOranianBerryPlant();
		passhauraBerryPlant = new BlockPasshauraBerryPlant();
		pechitaBerryPlant = new BlockPechitaBerryPlant();
		rawstettaBerryPlant = new BlockRawstettaBerryPlant();
		verdantPurifier = new BlockVerdantPurifier(false).setBlockName("verdantpurifier").setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);
		verdantPurifierActive = new BlockVerdantPurifier(true).setBlockName("verdantpurifieractive");
		voidGlass = new BlockVoidGlass();
		xelNagaDynamo = new BlockXelNagaDynamo();
		xelNagaPylon = new BlockXelNagaPylon();
		xelNagaTechBlock = new BlockXelNagaTechBlock();

		// Beta 1.0 Content
		neoTiberiumBlock = new BlockNeoTiberiumBlock();
		neoTiberiumBricks = new BlockNeoTiberiumBricks();
		packedAurumDust = new BlockPackedAurumDust();
		richTiberiumBlock = new BlockRichTiberiumBlock();
		richTiberiumBricks = new BlockRichTiberiumBricks();
		tiberiumBlock = new BlockTiberiumBlock();
		tiberiumBricks = new BlockTiberiumBricks();
		vespeneCondenser = new BlockVespeneCondenser(false).setBlockName("vespenecondenser").setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);
		vespeneCondenserActive = new BlockVespeneCondenser(true).setBlockName("vespenecondenseractive");
		
		// Beta 1.1 Content
		challengerBlock = new BlockChallengerBlock();
		prototurret = new BlockPrototurret();
		tabletManufactory= new BlockTabletManufactory(false).setBlockName("tabletmanufactory").setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);
		tabletManufactoryActive= new BlockTabletManufactory(true).setBlockName("tabletmanufactoryactive");

		alchemenisizer = new BlockAlchemenisizer();
		
		/*
		prototurret = new BlockPrototurret();
		//microFilter = new BlockMicroFilter(false).setBlockName("microfilter").setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);
		//microFilterActive = new BlockMicroFilter(true).setBlockName("microFilteractive");
		 */
	}

	public static void registerBlock()
	{
		GameRegistry.registerBlock(colbertaBerryPlant, colbertaBerryPlant.getUnlocalizedName());
		GameRegistry.registerBlock(oranianBerryPlant, oranianBerryPlant.getUnlocalizedName());
		GameRegistry.registerBlock(passhauraBerryPlant, passhauraBerryPlant.getUnlocalizedName());
		GameRegistry.registerBlock(pechitaBerryPlant, pechitaBerryPlant.getUnlocalizedName());
		GameRegistry.registerBlock(rawstettaBerryPlant, rawstettaBerryPlant.getUnlocalizedName());
		GameRegistry.registerBlock(verdantPurifier, ItemBlockVerdantPurifier.class, verdantPurifier.getUnlocalizedName());
		GameRegistry.registerBlock(verdantPurifierActive, verdantPurifierActive.getUnlocalizedName());
		GameRegistry.registerBlock(voidGlass, ItemBlockVoidGlass.class, voidGlass.getUnlocalizedName());
		GameRegistry.registerBlock(xelNagaDynamo, xelNagaDynamo.getUnlocalizedName());
		GameRegistry.registerBlock(xelNagaPylon, ItemBlockXelNagaPylon.class, xelNagaPylon.getUnlocalizedName());
		GameRegistry.registerBlock(xelNagaTechBlock, xelNagaTechBlock.getUnlocalizedName());

		// Beta 1.0 Content
		GameRegistry.registerBlock(neoTiberiumBlock, neoTiberiumBlock.getUnlocalizedName());
		GameRegistry.registerBlock(neoTiberiumBricks, ItemBlockNeoTiberiumBricks.class, neoTiberiumBricks.getUnlocalizedName());
		GameRegistry.registerBlock(packedAurumDust, packedAurumDust.getUnlocalizedName());
		GameRegistry.registerBlock(richTiberiumBlock, richTiberiumBlock.getUnlocalizedName());
		GameRegistry.registerBlock(richTiberiumBricks, ItemBlockRichTiberiumBricks.class, richTiberiumBricks.getUnlocalizedName());
		GameRegistry.registerBlock(tiberiumBlock, tiberiumBlock.getUnlocalizedName());
		GameRegistry.registerBlock(tiberiumBricks, ItemBlockTiberiumBricks.class, tiberiumBricks.getUnlocalizedName());
		GameRegistry.registerBlock(vespeneCondenser, ItemBlockVespeneCondenser.class, vespeneCondenser.getUnlocalizedName());
		GameRegistry.registerBlock(vespeneCondenserActive, vespeneCondenserActive.getUnlocalizedName());
		
		// Beta 1.1 Content
		GameRegistry.registerBlock(challengerBlock, ItemBlockChallengerBlock.class, challengerBlock.getUnlocalizedName());
		GameRegistry.registerBlock(prototurret, prototurret.getUnlocalizedName());
		GameRegistry.registerBlock(tabletManufactory, tabletManufactory.getUnlocalizedName());
		GameRegistry.registerBlock(tabletManufactoryActive, tabletManufactoryActive.getUnlocalizedName());

		GameRegistry.registerBlock(alchemenisizer, alchemenisizer.getUnlocalizedName());
		/*
		//GameRegistry.registerBlock(microFilter, microFilter.getUnlocalizedName());
		//GameRegistry.registerBlock(microFilterActive, microFilterActive.getUnlocalizedName());
		GameRegistry.registerBlock(prototurret, prototurret.getUnlocalizedName());
		 */
	}
}