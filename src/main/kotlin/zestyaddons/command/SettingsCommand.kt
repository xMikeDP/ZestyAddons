package zestyaddons.command

import net.minecraft.command.ICommandSender
import zestyaddons.ZestyAddons

class SettingsCommand : ClientCommandBase("zesty") {
    override fun processCommand(sender: ICommandSender?, args: Array<out String>?) {
        ZestyAddons.config.openGui()
    }
}