package akuto2.utils;

import net.minecraftforge.fml.common.ModMetadata;

public class ModInfo {
	public static void registerInfo(ModMetadata metadata) {
		metadata.modId = "DoublingTable";
		metadata.name = "DoublingTable";
		metadata.description = "Let's make a lot of items!";
		metadata.version = "2.0.3";
		metadata.url = "https://minecraft.curseforge.com/projects/doublingtable";
		metadata.authorList.add("Akuto2");
		metadata.autogenerated = false;
	}
}
