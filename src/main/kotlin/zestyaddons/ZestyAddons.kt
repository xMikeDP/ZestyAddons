package zestyaddons

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.client.ClientCommandHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent
import org.lwjgl.input.Keyboard
import zestyaddons.command.SettingsCommand
import zestyaddons.config.ZestyAddonsConfig
import java.io.File

@Mod(
    modid = ZestyAddons.MOD_ID,
    name = ZestyAddons.MOD_NAME,
    version = ZestyAddons.MOD_VERSION,
    clientSideOnly = true
)

class ZestyAddons {
    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        val directory = File(event.modConfigurationDirectory, "zestyaddons")
        directory.mkdirs()

        val cch = ClientCommandHandler.instance
        // REGISTER COMMANDS
        cch.registerCommand(SettingsCommand())
    }

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        config.init()
        // REGISTER CLASSES/ETC
        val mcBus = MinecraftForge.EVENT_BUS
        mcBus.register(this)

        keyBinds.forEach(ClientRegistry::registerKeyBinding)
    }

    @SubscribeEvent
    fun onTick(event: ClientTickEvent) {

    }

   @SubscribeEvent
   fun onKey(event: KeyInputEvent) {
       if(keyBinds[0].isPressed) config.openGui()
   }

    companion object {
        const val MOD_ID = "zestyaddons"
        const val MOD_NAME = "Zesty Addons"
        const val MOD_VERSION = "0.0.1"

        val mc: Minecraft = Minecraft.getMinecraft()
        var config = ZestyAddonsConfig
        var display: GuiScreen? = null

        val keyBinds = arrayOf(
            KeyBinding("Open Settings", Keyboard.KEY_RSHIFT, "Zesty Addons")
        )
    }

}