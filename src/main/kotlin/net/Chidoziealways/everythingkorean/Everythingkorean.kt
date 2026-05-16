package net.Chidoziealways.everythingkorean

import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.Chidoziealways.everythingkorean.item.KModCreativeModeTabs
import net.Chidoziealways.everythingkorean.item.KModItems
import net.minecraft.client.Minecraft
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import net.neoforged.fml.loading.FMLEnvironment
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.Marker
import org.apache.logging.log4j.MarkerManager
import org.spongepowered.asm.launch.MixinBootstrap
import thedarkcolour.kotlinforforge.common.KotlinMod
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runForDist

/**
 * Main mod class.
 *
 * An example for blocks is in the `blocks` package of this mod.
 */
const val KOREAN_MOD_ID: String = "everythingkorean"
private var LOGGER: Logger? = null
private var EVERYTHINGJAPANESE: Marker? = null
@KotlinMod(KOREAN_MOD_ID)
object Everythingkorean {

    // the logger for our mod

    init {
        LOGGER = LogManager.getLogger(Everythingkorean::class.java)
        EVERYTHINGJAPANESE = MarkerManager.getMarker("EVERYTHINGKOREAN")

        // Register the KDeferredRegister to the mod-specific event bus
        MOD_BUS.register(this)
        MixinBootstrap.init()
        KModBlocks.register(MOD_BUS)
        KModItems.register(MOD_BUS)
        KModCreativeModeTabs.register(MOD_BUS)

        val obj = runForDist(clientTarget = {
            MOD_BUS.addListener(::onClientSetup)
            Minecraft.getInstance()
        }, serverTarget = {
            MOD_BUS.addListener(::onServerSetup)
            "test"
        })

        println(obj)
    }

    /**
     * This is used for initializing client specific
     * things such as renderers and keymaps
     * Fired on the mod specific event bus.
     */
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER!!.log(Level.INFO, "Initializing client...")
    }

    /**
     * Fired on the global Forge bus.
     */
    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        LOGGER!!.log(Level.INFO, "Server starting...")
    }

    @SubscribeEvent
    fun onCommonSetup(event: FMLCommonSetupEvent) {
        LOGGER!!.log(Level.INFO, "Hello! This is working!")
    }

    fun logInfo(message: Any?) {
        LOGGER!!.info(message.toString())
    }

    fun logError(message: Any?) {
        LOGGER!!.error(message.toString())
    }

    fun logDebug(message: Any?) {
        LOGGER!!.debug(message.toString())
    }
}
