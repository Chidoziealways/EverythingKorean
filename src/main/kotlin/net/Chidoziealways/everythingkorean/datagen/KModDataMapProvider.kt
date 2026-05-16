package net.Chidoziealways.everythingkorean.datagen

import net.Chidoziealways.everythingkorean.item.KModItems
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.DataMapProvider
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps
import java.util.concurrent.CompletableFuture

class KModDataMapProvider(packOutput: PackOutput, lookupProvider: CompletableFuture<HolderLookup.Provider>): DataMapProvider(packOutput, lookupProvider) {
    override fun gather(p0: HolderLookup.Provider) {
        builder(NeoForgeDataMaps.COMPOSTABLES)
            .add(KModItems.RAMYEON.builtInRegistryHolder(), Compostable(1f, true), false)
            .add(KModItems.KIMCHI.builtInRegistryHolder(), Compostable(1f, true), false)
            .add(KModItems.TTEOKBOKKI.builtInRegistryHolder(), Compostable(1f, true), false)
    }
}