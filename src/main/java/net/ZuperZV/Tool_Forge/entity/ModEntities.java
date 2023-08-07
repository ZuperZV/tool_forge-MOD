package net.ZuperZV.Tool_Forge.entity;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.entity.custom.SoulEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Tool_Forge.MOD_ID);

    public static final RegistryObject<EntityType<SoulEntity>> SOUL =
            ENTITY_TYPES.register("rhino", () -> EntityType.Builder.of(SoulEntity::new, MobCategory.MONSTER)
                    .sized(2.5f, 2.5f).build("soul"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
