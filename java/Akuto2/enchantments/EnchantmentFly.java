package Akuto2.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentFly extends Enchantment{
	public EnchantmentFly(int effectId, int weight, EnumEnchantmentType type) {
		super(effectId, weight, type);
		setName("doublingtable.fly");
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public int getMinEnchantability(int par1) {
		return 15;
	}

	@Override
	public int getMaxEnchantability(int par1) {
		return super.getMinEnchantability(par1) + 50;
	}
}
