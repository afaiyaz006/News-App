package com.faiyaz.dummy_news_app.ui.Settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class SettingsViewModel : ViewModel() {

    fun setThemeMode(mode: ThemeMode) {
        viewModelScope.launch {
            AppSettings.setThemeMode(mode)
        }
    }

    fun setAppThemeColor(color: AppThemeColor) {
        viewModelScope.launch {
            AppSettings.setAppThemeColor(color)
        }
    }

}
