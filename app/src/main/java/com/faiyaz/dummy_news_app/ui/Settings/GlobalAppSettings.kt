package com.faiyaz.dummy_news_app.ui.Settings

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
    English,
    French,
    Russia

}
data class SettingsUIState(
    val mode: ThemeMode = ThemeMode.SYSTEM,
    val appThemeColor: AppThemeColor = AppThemeColor.BLUE,
    val appLanguage: Languages = Languages.English
)
object AppSettings {
    private var _settingsState = SettingsUIState()

    val settingsState: SettingsUIState
        get() = _settingsState

    fun setThemeMode(mode: ThemeMode) {
        _settingsState = _settingsState.copy(mode = mode)
    }

    fun setAppThemeColor(color: AppThemeColor) {
        _settingsState = _settingsState.copy(appThemeColor = color)
    }

    fun setLanguage(language: Languages){
        _settingsState = _settingsState.copy(appLanguage = language)
    }
}
