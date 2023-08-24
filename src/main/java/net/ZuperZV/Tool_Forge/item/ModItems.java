package net.ZuperZV.Tool_Forge.item;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.entity.ModEntities;
import net.ZuperZV.Tool_Forge.item.costom.ModArmorMaterials;
import net.ZuperZV.Tool_Forge.item.costom.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Tool_Forge.MOD_ID);

    public static final RegistryObject<Item> GILDED_NETHERITE_INGOT = ITEMS.register("gilded_netherite_ingot",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> GILDED_GOLD = ITEMS.register("gilded_gold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GILDED_GOLD_NUGGET = ITEMS.register("gilded_gold_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_GILDED_GOLD = ITEMS.register("raw_gilded_gold",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GILDED_NETHERITE_SWORD = ITEMS.register("gilded_netherite_sword",
            () -> new SwordItem(ModToolTiers.GILDED_NETERITE, 5, -3f, new Item.Properties().durability(2000).fireResistant() .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_NETHERITE_PICKAXE = ITEMS.register("gilded_netherite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GILDED_NETERITE, 2, 2f, new Item.Properties().durability(2000).fireResistant() .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_NETHERITE_SHOVEL = ITEMS.register("gilded_netherite_shovel",
            () -> new ShovelItem(ModToolTiers.GILDED_NETERITE, 2, 3, new Item.Properties().durability(2000).fireResistant() .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_NETHERITE_AXE = ITEMS.register("gilded_netherite_axe",
            () -> new AxeItem(ModToolTiers.GILDED_NETERITE, 2.5f, 2f, new Item.Properties().durability(2000).fireResistant() .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_NETHERITE_HOE = ITEMS.register("gilded_netherite_hoe",
            () -> new HoeItem(ModToolTiers.GILDED_NETERITE, 2, 1, new Item.Properties().durability(2000).fireResistant() .rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> GILDED_NETHERITE_HELMET = ITEMS.register("gilded_netherite_helmet",
            () -> new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.HELMET, new Item.Properties().fireResistant() .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_NETHERITE_CHESTPLATE = ITEMS.register("gilded_netherite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant() .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_NETHERITE_LEGGINGS = ITEMS.register("gilded_netherite_leggings",
            () -> new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant() .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GILDED_NETHERITE_BOOTS = ITEMS.register("gilded_netherite_boots",
            () -> new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant() .rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> SOUL_SPAWN_EGG = ITEMS.register("soul_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SOUL, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));

    public static final RegistryObject<Item> ECTOPLASM = ITEMS.register("ectoplasm",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> SOUL_SHARD = ITEMS.register("soul_shard",
            () -> new Item(new Item.Properties().stacksTo(1)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
