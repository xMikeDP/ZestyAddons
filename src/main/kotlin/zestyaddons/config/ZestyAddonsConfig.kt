package zestyaddons.config

import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.HUD
import cc.polyfrost.oneconfig.config.annotations.Switch
import cc.polyfrost.oneconfig.config.annotations.Text
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType

object ZestyAddonsConfig : Config(Mod("ZestyAddons", ModType.SKYBLOCK), "zestyaddons-config.json") {

    @Switch(
        name = "Testing",
        description = "just testing stuf",
        category = "General",
        subcategory = "General"
    )
    var testTesting = false

    @Text(
        name = "test text",
        description = "/zesty help zaza",
        category = "zesty stuff",
        subcategory = "zesty stuff",
        secure = false
    )
    var dynamicCommandString = ""

//    @HUD(
//        name = "some hud",
//        category = "HUD",
//        subcategory = "General"
//    )
//    var someHud: someHud = someHud()

    fun init() {
        initialize()
    }

}
