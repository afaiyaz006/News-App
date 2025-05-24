package com.faiyaz.dummy_news_app.ui.Settings

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import java.util.Locale

fun setAppLocale(context: Context, languageCode: String) {
    val locale = Locale(languageCode) // e.g., "en" for English, "fr" for French
    Locale.setDefault(locale)

    val config = Configuration(context.resources.configuration)

    // Update locale based on Android version
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        config.setLocale(locale)
        // For Android 13+ (API 33+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.getSystemService(Context.LOCALE_SERVICE)?.let {
                (it as android.app.LocaleManager).applicationLocales =
                    android.os.LocaleList(locale)
            }
        } else {
            config.setLocales(LocaleList(locale))
        }
    } else {
        @Suppress("DEPRECATION")
        config.locale = locale
    }

    // Update the resources with the new configuration
    context.resources.updateConfiguration(config, context.resources.displayMetrics)

//    // If the context is an Activity, recreate it to apply the new locale
//    if (context is Activity) {
//        context.recreate()
//    }
}