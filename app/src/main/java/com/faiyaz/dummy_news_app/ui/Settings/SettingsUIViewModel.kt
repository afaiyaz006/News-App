package com.faiyaz.dummy_news_app.ui.Settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel



class SettingsViewModel : ViewModel() {

    fun setThemeMode(mode: ThemeMode) {
        AppSettings.setThemeMode(mode)
    }

    fun setAppThemeColor(color: AppThemeColor) {
        AppSettings.setAppThemeColor(color)
    }

}
