package akuto2.utils;

import akuto2.ObjHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabDoublingTable extends CreativeTabs{
	public CreativeTabDoublingTable(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ObjHandler.doublingTable);
	}

	@Override
	public String getTranslatedTabLabel() {
		return "DoublingTable";
	}
}
