package net.ZuperZV.Tool_Forge.screen;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Tool_Forge.MOD_ID);

    public static final RegistryObject<MenuType<ToolStationMenu>> TOOL_STATION_MENU =
            registerMenuType(ToolStationMenu::new, "tool_station_menu");

    public static final RegistryObject<MenuType<DeepslateFurnaceMenu>> DEEPSLATE_FURNACE_MENU =
            registerMenuType(DeepslateFurnaceMenu::new, "deepslate_furnace_menu");


    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
