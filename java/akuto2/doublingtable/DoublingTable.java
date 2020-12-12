package akuto2.doublingtable;

import akuto2.doublingtable.blocks.BlockDoublingFurnace;
import akuto2.doublingtable.blocks.BlockDoublingTable;
import akuto2.doublingtable.blocks.ItemBlockDoublingFurnace;
import akuto2.doublingtable.blocks.ItemBlockDoublingTable;
import akuto2.doublingtable.creativetab.CreativeTabDoublingTable;
import akuto2.doublingtable.enchantments.DoublingTableEnchantments;
import akuto2.doublingtable.event.CommonEventHandler;
import akuto2.doublingtable.gui.GuiHandler;
import akuto2.doublingtable.item.ItemCommpressedExpCore;
import akuto2.doublingtable.item.ItemCraftRod;
import akuto2.doublingtable.item.ItemDoublingCraftRod;
import akuto2.doublingtable.item.ItemExpBoost1;
import akuto2.doublingtable.item.ItemExpBoost10;
import akuto2.doublingtable.item.ItemExpBoost11;
import akuto2.doublingtable.item.ItemExpBoost2;
import akuto2.doublingtable.item.ItemExpBoost3;
import akuto2.doublingtable.item.ItemExpBoost4;
import akuto2.doublingtable.item.ItemExpBoost5;
import akuto2.doublingtable.item.ItemExpBoost6;
import akuto2.doublingtable.item.ItemExpBoost7;
import akuto2.doublingtable.item.ItemExpBoost8;
import akuto2.doublingtable.item.ItemExpBoost9;
import akuto2.doublingtable.item.ItemUEXPBoost;
import akuto2.doublingtable.proxy.CommonProxy;
import akuto2.doublingtable.utils.DoublingTableConfig;
import akuto2.doublingtable.utils.ModInfo;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "DoublingTable", name = "DoublingTable", version = "1.2.5", useMetadata = true, guiFactory = "Akuto2.utils.DoublingTableGuiFactory")
public class DoublingTable {
	@Instance("DoublingTable")
	public static DoublingTable instance;
	@Metadata("DoublingTable")
	public static ModMetadata meta;
	@SidedProxy(clientSide = "Akuto2.proxy.ClientProxy", serverSide = "Akuto2.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static final CreativeTabs tabDoublingTable = new CreativeTabDoublingTable("DoublingTable");
	public static Block doublingTable;
	public static Block doublingFurnace;
	public static Block doublingFurnaceOn;
	public static Item craftRod;
	public static Item doublingCraftRod;
	public static Item expBoost1;
	public static Item expBoost2;
	public static Item expBoost3;
	public static Item expBoost4;
	public static Item expBoost5;
	public static Item expBoost6;
	public static Item expBoost7;
	public static Item expBoost8;
	public static Item expBoost9;
	public static Item expBoost10;
	public static Item expBoost11;
	public static Item uexpBoost;
	public static Item expCore;
	public static Item compressedexpCore;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModInfo.registerInfo(meta);
		DoublingTableConfig.initConfig(event);
		DoublingTableEnchantments.Initialize();
		doublingTable = new BlockDoublingTable().setBlockName("doublingTable").setStepSound(Block.soundTypeWood).setHardness(2.5F);
		doublingFurnace = new BlockDoublingFurnace(false).setBlockName("doublingFurnace").setCreativeTab(tabDoublingTable);
		doublingFurnaceOn = new BlockDoublingFurnace(true).setBlockName("doublingFurnaceOn");
		craftRod = new ItemCraftRod().setUnlocalizedName("craftRod").setCreativeTab(tabDoublingTable).setTextureName("doublingtable:craftrod");
		doublingCraftRod = new ItemDoublingCraftRod().setUnlocalizedName("doublingCraftRod").setCreativeTab(tabDoublingTable).setTextureName("doublingtable:doublingcraftrod");
		expBoost1 = new ItemExpBoost1().setUnlocalizedName("expBoost1").setTextureName("doublingtable:expboost1");
		expBoost2 = new ItemExpBoost2().setUnlocalizedName("expBoost2").setTextureName("doublingtable:expboost2");
		expBoost3 = new ItemExpBoost3().setUnlocalizedName("expBoost3").setTextureName("doublingtable:expboost3");
		expBoost4 = new ItemExpBoost4().setUnlocalizedName("expBoost4").setTextureName("doublingtable:expboost4");
		expBoost5 = new ItemExpBoost5().setUnlocalizedName("expBoost5").setTextureName("doublingtable:expboost5");
		expBoost6 = new ItemExpBoost6().setUnlocalizedName("expBoost6").setTextureName("doublingtable:expboost6");
		expBoost7 = new ItemExpBoost7().setUnlocalizedName("expBoost7").setTextureName("doublingtable:expboost7");
		expBoost8 = new ItemExpBoost8().setUnlocalizedName("expBoost8").setTextureName("doublingtable:expboost8");
		expBoost9 = new ItemExpBoost9().setUnlocalizedName("expBoost9").setTextureName("doublingtable:expboost9");
		expBoost10 = new ItemExpBoost10().setUnlocalizedName("expBoost10").setTextureName("doublingtable:expboost10");
		expBoost11 = new ItemExpBoost11().setUnlocalizedName("expBoost11").setTextureName("doublingtable:expboost11");
		uexpBoost = new ItemUEXPBoost().setUnlocalizedName("uexpBoost").setTextureName("doublingtable:uexpBoost");
		expCore = new Item().setUnlocalizedName("expCore").setTextureName("doublingtable:expCore").setCreativeTab(tabDoublingTable);
		compressedexpCore = new ItemCommpressedExpCore().setUnlocalizedName("compressedexpCore");

		GameRegistry.registerBlock(doublingTable, ItemBlockDoublingTable.class, "doublingTable");
		GameRegistry.registerBlock(doublingFurnace, ItemBlockDoublingFurnace.class, "doublingFurnace");
		GameRegistry.registerBlock(doublingFurnaceOn, "doublingFurnaceOn");
		GameRegistry.registerItem(craftRod, "craftRod");
		GameRegistry.registerItem(doublingCraftRod, "doublingCraftRod");
		GameRegistry.registerItem(expBoost1, "expBoost1");
		GameRegistry.registerItem(expBoost2, "expBoost2");
		GameRegistry.registerItem(expBoost3, "expBoost3");
		GameRegistry.registerItem(expBoost4, "expBoost4");
		GameRegistry.registerItem(expBoost5, "expBoost5");
		GameRegistry.registerItem(expBoost6, "expBoost6");
		GameRegistry.registerItem(expBoost7, "expBoost7");
		GameRegistry.registerItem(expBoost8, "expBoost8");
		GameRegistry.registerItem(expBoost9, "expBoost9");
		GameRegistry.registerItem(expBoost10, "expBoost10");
		GameRegistry.registerItem(expBoost11, "expBoost11");
		GameRegistry.registerItem(uexpBoost, "uexpBoost");
		GameRegistry.registerItem(expCore, "expCore");
		GameRegistry.registerItem(compressedexpCore, "compressedexpCore");
	}

	@EventHandler
	public void load(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
		FMLCommonHandler.instance().bus().register(new CommonEventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		// TileEntity登録
		proxy.registerTileEntity();

		// エンチャントの追加
		new DoublingTableEnchantments();

		// レシピの追加
		GameRegistry.addRecipe(new ItemStack(doublingTable, 1, 0), "xxx", "xyx", "xxx", 'x', new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE), 'y', Blocks.crafting_table);
		GameRegistry.addRecipe(new ItemStack(doublingTable, 1, 1), "xxx", "xyx", "xxx", 'x', Blocks.cobblestone, 'y', new ItemStack(doublingTable, 1, 0));
		GameRegistry.addRecipe(new ItemStack(doublingTable, 1, 2), "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(doublingTable, 1, 1));
		GameRegistry.addRecipe(new ItemStack(doublingTable, 1, 3), "xxx", "xyx", "xxx", 'x', Items.gold_ingot, 'y', new ItemStack(doublingTable, 1, 2));
		GameRegistry.addRecipe(new ItemStack(doublingTable, 1, 4), "xxx", "xyx", "xxx", 'x', Items.diamond, 'y', new ItemStack(doublingTable, 1, 3));
		GameRegistry.addRecipe(new ItemStack(doublingTable, 1, 5), "xxx", "xyx", "xxx", 'x', Items.emerald, 'y', new ItemStack(doublingTable, 1, 4));
		GameRegistry.addRecipe(new ItemStack(doublingTable, 1, 6), "xxx", "xyx", "xxx", 'x', new ItemStack(Items.dye, 1, 4), 'y', new ItemStack(doublingTable, 1, 2));
		GameRegistry.addRecipe(new ItemStack(doublingTable, 1, 7), "xxx", "xyx", "xxx", 'x', Items.redstone, 'y', new ItemStack(doublingTable, 1, 2));
		GameRegistry.addRecipe(new ItemStack(doublingFurnace, 1, 0), "xxx", "xyx", "xxx", 'x', new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE), 'y', Blocks.furnace);
		GameRegistry.addRecipe(new ItemStack(doublingFurnace, 1, 1), "xxx", "xyx", "xxx", 'x', Blocks.cobblestone, 'y', new ItemStack(doublingFurnace, 1, 0));
		GameRegistry.addRecipe(new ItemStack(doublingFurnace, 1, 2), "xxx", "xyx", "xxx", 'x', Items.iron_ingot, 'y', new ItemStack(doublingFurnace, 1, 1));
		GameRegistry.addRecipe(new ItemStack(doublingFurnace, 1, 3), "xxx", "xyx", "xxx", 'x', Items.gold_ingot, 'y', new ItemStack(doublingFurnace, 1, 2));
		GameRegistry.addRecipe(new ItemStack(doublingFurnace, 1, 4), "xxx", "xyx", "xxx", 'x', Items.diamond, 'y', new ItemStack(doublingFurnace, 1, 3));
		GameRegistry.addRecipe(new ItemStack(doublingFurnace, 1, 5), "xxx", "xyx", "xxx", 'x', Items.emerald, 'y', new ItemStack(doublingFurnace, 1, 4));
		GameRegistry.addRecipe(new ItemStack(doublingFurnace, 1, 6), "xxx", "xyx", "xxx", 'x', new ItemStack(Items.dye, 1, 4), 'y', new ItemStack(doublingFurnace, 1, 2));
		GameRegistry.addRecipe(new ItemStack(doublingFurnace, 1, 7), "xxx", "xyx", "xxx", 'x', Items.redstone, 'y', new ItemStack(doublingFurnace, 1, 2));
		GameRegistry.addRecipe(new ItemStack(craftRod, 1), "  x", " y ", "z  ", 'x', Items.ender_pearl, 'y', Blocks.crafting_table, 'z', Items.stick);
		GameRegistry.addRecipe(new ItemStack(doublingCraftRod, 1, 0), "wwx", "wyw", "zww", 'x', Items.ender_pearl, 'y', new ItemStack(doublingTable, 1, 0), 'z', Items.stick, 'w', new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addRecipe(new ItemStack(doublingCraftRod, 1, 1), "wwx", "wyw", "zww", 'x', Items.ender_pearl, 'y', new ItemStack(doublingTable, 1, 1), 'z', Items.stick, 'w', Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(doublingCraftRod, 1, 2), "wwx", "wyw", "zww", 'x', Items.ender_pearl, 'y', new ItemStack(doublingTable, 1, 2), 'z', Items.stick, 'w', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(doublingCraftRod, 1, 3), "wwx", "wyw", "zww", 'x', Items.ender_pearl, 'y', new ItemStack(doublingTable, 1, 3), 'z', Items.stick, 'w', Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(doublingCraftRod, 1, 4), "wwx", "wyw", "zww", 'x', Items.ender_pearl, 'y', new ItemStack(doublingTable, 1, 4), 'z', Items.stick, 'w', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(doublingCraftRod, 1, 5), "wwx", "wyw", "zww", 'x', Items.ender_pearl, 'y', new ItemStack(doublingTable, 1, 5), 'z', Items.stick, 'w', Items.emerald);
		GameRegistry.addRecipe(new ItemStack(doublingCraftRod, 1, 5), "wwx", "wyw", "zww", 'x', Items.ender_pearl, 'y', new ItemStack(doublingTable, 1, 2), 'z', Items.stick, 'w', new ItemStack(Items.dye, 1, 4));
		GameRegistry.addRecipe(new ItemStack(doublingCraftRod, 1, 5), "wwx", "wyw", "zww", 'x', Items.ender_pearl, 'y', new ItemStack(doublingTable, 1, 2), 'z', Items.stick, 'w', Items.redstone);
		GameRegistry.addShapedRecipe(new ItemStack(doublingCraftRod, 1, 0), " x", "y ", 'x', new ItemStack(doublingTable, 1, 0), 'y', craftRod);
		GameRegistry.addShapedRecipe(new ItemStack(doublingCraftRod, 1, 1), " x", "y ", 'x', new ItemStack(doublingTable, 1, 1), 'y', new ItemStack(doublingCraftRod, 1, 0));
		GameRegistry.addShapedRecipe(new ItemStack(doublingCraftRod, 1, 2), " x", "y ", 'x', new ItemStack(doublingTable, 1, 2), 'y', new ItemStack(doublingCraftRod, 1, 1));
		GameRegistry.addShapedRecipe(new ItemStack(doublingCraftRod, 1, 3), " x", "y ", 'x', new ItemStack(doublingTable, 1, 3), 'y', new ItemStack(doublingCraftRod, 1, 2));
		GameRegistry.addShapedRecipe(new ItemStack(doublingCraftRod, 1, 4), " x", "y ", 'x', new ItemStack(doublingTable, 1, 4), 'y', new ItemStack(doublingCraftRod, 1, 3));
		GameRegistry.addShapedRecipe(new ItemStack(doublingCraftRod, 1, 5), " x", "y ", 'x', new ItemStack(doublingTable, 1, 5), 'y', new ItemStack(doublingCraftRod, 1, 4));
		GameRegistry.addShapedRecipe(new ItemStack(doublingCraftRod, 1, 2), " x", "y ", 'x', new ItemStack(doublingTable, 1, 6), 'y', new ItemStack(doublingCraftRod, 1, 2));
		GameRegistry.addShapedRecipe(new ItemStack(doublingCraftRod, 1, 2), " x", "y ", 'x', new ItemStack(doublingTable, 1, 7), 'y', new ItemStack(doublingCraftRod, 1, 2));
		GameRegistry.addRecipe(new ItemStack(Items.experience_bottle, 4), "x", "y", 'x', Items.diamond, 'y', Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(expBoost1), "  x", " y ", "x  ", 'x', Items.experience_bottle, 'y', Items.stick);
		GameRegistry.addRecipe(new ItemStack(expBoost2), "z x", " y ", "x z", 'x', expBoost1, 'y', Items.stick);
		GameRegistry.addRecipe(new ItemStack(expBoost3), "z x", " y ", "x z", 'x', expBoost2, 'y', Blocks.coal_block, 'z', Items.coal);
		GameRegistry.addRecipe(new ItemStack(expBoost4), "z x", " y ", "x z", 'x', expBoost3, 'y', Blocks.redstone_block, 'z', Items.redstone);
		GameRegistry.addRecipe(new ItemStack(expBoost5), "z x", " y ", "x z", 'x', expBoost4, 'y', Blocks.iron_block, 'z', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(expBoost6), "z x", " y ", "x z", 'x', expBoost5, 'y', Blocks.gold_block, 'z', Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(expBoost7), "z x", " y ", "x z", 'x', expBoost6, 'y', Blocks.diamond_block, 'z', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(expBoost8), "z x", " y ", "x z", 'x', expBoost7, 'y', Blocks.emerald_block, 'z', Items.emerald);
		GameRegistry.addRecipe(new ItemStack(expBoost9), "z x", " y ", "x z", 'x', expBoost8, 'y', Items.blaze_rod, 'z', Items.magma_cream);
		GameRegistry.addRecipe(new ItemStack(expBoost10), "z x", " y ", "x z", 'x', expBoost9, 'y', Items.ender_pearl, 'z', Items.ender_eye);
		GameRegistry.addRecipe(new ItemStack(expBoost11), "z x", " y ", "x z", 'x', expBoost10, 'y', Items.nether_star, 'z', Blocks.dragon_egg);
		GameRegistry.addRecipe(new ItemStack(uexpBoost), "x x", " y ", "x x", 'x', expBoost11, 'y', new ItemStack(compressedexpCore, 1, 5));
		GameRegistry.addRecipe(new ItemStack(compressedexpCore, 1, 0), "xxx", "xxx", "xxx", 'x', expCore);
		GameRegistry.addRecipe(new ItemStack(compressedexpCore, 1, 1), "xxx", "xxx", "xxx", 'x', new ItemStack(compressedexpCore, 1, 0));
		GameRegistry.addRecipe(new ItemStack(compressedexpCore, 1, 2), "xxx", "xxx", "xxx", 'x', new ItemStack(compressedexpCore, 1, 1));
		GameRegistry.addRecipe(new ItemStack(compressedexpCore, 1, 3), "xxx", "xxx", "xxx", 'x', new ItemStack(compressedexpCore, 1, 2));
		GameRegistry.addRecipe(new ItemStack(compressedexpCore, 1, 4), "xxx", "xxx", "xxx", 'x', new ItemStack(compressedexpCore, 1, 3));
		GameRegistry.addRecipe(new ItemStack(compressedexpCore, 1, 5), "xxx", "xxx", "xxx", 'x', new ItemStack(compressedexpCore, 1, 4));
		GameRegistry.addRecipe(new ItemStack(Blocks.dragon_egg), "zxz" ,"xyx", "zxz", 'x', Blocks.diamond_block, 'y', Items.egg, 'z', Items.nether_star);
	}
}