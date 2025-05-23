package com.faiyaz.dummy_news_app.ui.Settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SettingsUI(
    settingsViewModel: SettingsViewModel
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        item {
            Text(
                text = "Settings",
                fontSize = 32.sp
            )
        }
        item {
            BackGroundThemeOption(
                defaultOption = AppSettings.settingsState.mode.toString(),
                onAppBackgroundChange = {
                    mode -> AppSettings.setThemeMode(mode)
                }
            )
        }
//        item {
//            BackGroundColorPicker(
//                defaultOption = AppSettings.settingsState.appThemeColor.toString(),
//                onAppThemeChanged = {
//                    theme -> AppSettings.setAppThemeColor(theme)
//                }
//            )
//        }
    }
}

@Composable
fun BackGroundThemeOption(
    defaultOption:String="DarkMode",
    onAppBackgroundChange:(ThemeMode)->Unit ={}
) {
    // State to hold the currently selected theme option
    var selectedThemeOption by remember { mutableStateOf(defaultOption) } // Default selected option

    Card(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "App background?",
            modifier = Modifier.padding(16.dp)
        )
        ThemeMode.entries.forEach { mode ->
            CheckBoxOption(
                title = mode.name.toString(),
                isSelected = selectedThemeOption == mode.name.toString(),
                onOptionSelected = {
                    selectedThemeOption = mode.name.toString()
                    onAppBackgroundChange(mode)
                }
            )
        }


    }
}

@Composable
fun BackGroundColorPicker(
    defaultOption: String ="Red",
    onAppThemeChanged:(AppThemeColor)->Unit ={}
) {
    // State to hold the currently selected color option
    var selectedColorOption by remember { mutableStateOf(defaultOption) } // Default selected option

    Card(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "App Theme",
            modifier = Modifier.padding(16.dp)
        )

        AppThemeColor.entries.forEach {
            colorTheme ->
            CheckBoxOption(
                    title = colorTheme.name.toString(),
                    isSelected = selectedColorOption==colorTheme.name.toString(),
                    onOptionSelected = {
                        selectedColorOption = colorTheme.name.toString()
                        onAppThemeChanged(colorTheme)
                    }
                )
        }


    }
}

@Composable
fun CheckBoxOption(
    title: String = "Option",
    isSelected: Boolean = false,
    onOptionSelected: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isSelected,
            onCheckedChange = { onOptionSelected() }
        )
        Text(
            text = title,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SettingsUIPreview() {
//    SettingsUI()
//}
