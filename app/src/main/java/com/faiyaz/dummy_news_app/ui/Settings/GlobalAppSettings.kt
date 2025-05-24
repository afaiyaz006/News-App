package com.faiyaz.dummy_news_app.ui.Settings

import java.util.Locale

enum class ThemeMode {
    SYSTEM,
    DARK,
    LIGHT
}

enum class AppThemeColor {
    RED,
    GREEN,
    BLUE
}
enum class Languages{
    en,
    bn

}
data class SettingsUIState(
    val mode: ThemeMode = ThemeMode.SYSTEM,
    val appThemeColor: AppThemeColor = AppThemeColor.BLUE,
    val appLanguage: Languages = Languages.en
)
object AppSettings {
    private var _settingsState = SettingsUIState()

    val settingsState: SettingsUIState
        get() = _settingsState

    suspend fun setThemeMode(mode: ThemeMode) {
        _settingsState = _settingsState.copy(mode = mode)
    }
    fun setLocale(languages: Languages){
        _settingsState = _settingsState.copy(appLanguage = languages)
    }
    fun getLocale():String{
        return _settingsState.appLanguage.toString()
    }

}
