package com.faiyaz.dummy_news_app.ui.Settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsUI() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text="Settings",
            fontSize = 32.sp
        )
        Column(
            modifier=Modifier.padding(16.dp)
        ) {
            BackGroundThemeOption()
            BackGroundColorPicker()
        }
    }
}

@Composable
fun BackGroundThemeOption(){


        Card(modifier=Modifier.padding(bottom=16.dp).fillMaxWidth()) {
            Text(
                text = "App background?",
                modifier=Modifier.padding(16.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically,modifier=Modifier.padding(end=16.dp)) {
                CheckBoxOption(title = "DarkMode", isSelected = false)
                CheckBoxOption(title = "White", isSelected = false)
                CheckBoxOption(title = "System", isSelected = true)

            }
        }


}
@Composable
fun BackGroundColorPicker(){
    Card(modifier=Modifier.padding(bottom=16.dp).fillMaxWidth()) {
        Text(
            text="App Theme",
            modifier=Modifier.padding(16.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically,modifier=Modifier.padding(end=16.dp)) {
            CheckBoxOption(title = "Red", isSelected = false)
            CheckBoxOption(title = "Green", isSelected = false)
            CheckBoxOption(title = "Blue", isSelected = true)

        }
    }
}
@Composable
fun CheckBoxOption(
    title:String="Option",
    isSelected:Boolean=false
){
    var checked by remember { mutableStateOf(isSelected) }
    Column(modifier=Modifier.padding(8.dp)) {
        Text(
            text = title
        )
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }

}
@Preview(showBackground = true)
@Composable
fun SettingsUIPreview() {
    SettingsUI()
}
