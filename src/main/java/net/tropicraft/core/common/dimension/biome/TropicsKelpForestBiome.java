package net.tropicraft.core.common.dimension.biome;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidWithNoiseConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.tropicraft.core.common.dimension.config.TropicsBuilderConfigs;
import net.tropicraft.core.common.entity.TropicraftEntities;

public class TropicsKelpForestBiome extends TropicraftBiome {

    protected TropicsKelpForestBiome() {
        super(new Biome.Builder()
                .surfaceBuilder(SurfaceBuilder.DEFAULT, TropicsBuilderConfigs.PURIFIED_SAND_CONFIG.get())
                .precipitation(RainType.RAIN)
                .category(Category.OCEAN)
                .depth(-1.5F)
                .scale(0.3F)
                .temperature(2.0F)
                .downfall(1.25F)
                .parent(null));
    }
    
    @Override
    public void addFeatures() {
        super.addFeatures();

        DefaultTropicsFeatures.addUnderwaterCarvers(this);

        // KELP!
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.KELP, IFeatureConfig.NO_FEATURE_CONFIG, Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED, new TopSolidWithNoiseConfig(120, 80, 1, Heightmap.Type.OCEAN_FLOOR_WG)));
        
        DefaultTropicsFeatures.addUnderwaterCarvers(this);
        DefaultTropicsFeatures.addUndergroundSeagrass(this);
        DefaultTropicsFeatures.addUndergroundPickles(this);

        addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(TropicraftEntities.MARLIN.get(), 10, 1, 4));
        addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(TropicraftEntities.STARFISH.get(), 4, 1, 4));
        addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(TropicraftEntities.SEA_URCHIN.get(), 4, 1, 4));
        addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(TropicraftEntities.DOLPHIN.get(), 3, 4, 7));
        addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(TropicraftEntities.SEAHORSE.get(), 6, 6, 12));
        addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(TropicraftEntities.SEA_TURTLE.get(), 6, 3, 8));
        addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(TropicraftEntities.TROPICAL_FISH.get(), 20, 4, 8));
        addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(TropicraftEntities.EAGLE_RAY.get(), 6, 1, 1));
        addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(TropicraftEntities.HAMMERHEAD.get(), 2, 1, 1));
    }
}
