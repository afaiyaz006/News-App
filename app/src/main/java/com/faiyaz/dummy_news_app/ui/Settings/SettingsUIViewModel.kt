package com.faiyaz.dummy_news_app.ui.Settings

import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faiyaz.dummy_news_app.di.AppContainer
import kotlinx.coroutines.launch
import java.util.Locale


class SettingsViewModel(
    private var appContainer: AppContainer
) : ViewModel() {

    var currentLanguage = AppSettings.settingsState.appLanguage

    fun setThemeMode(mode: ThemeMode) {
        viewModelScope.launch {
            AppSettings.setThemeMode(mode)
        }
    }

    fun setLanguage(language: Languages) {
//        viewModelScope.launch {
//            AppSettings.setLocale(language)
//
//        }
        AppSettings.setLocale(language)
        appContainer.setLocale(Locale(language.name))
    }
}
