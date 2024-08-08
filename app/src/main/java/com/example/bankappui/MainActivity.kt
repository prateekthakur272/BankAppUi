package com.example.bankappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankappui.ui.theme.BankAppUiTheme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankAppUiTheme {
                SetBarColor(color = androidx.compose.material3.MaterialTheme.colorScheme.background)
                androidx.compose.material3.Surface {
                    com.example.bankappui.HomeScreen()
                }
            }
        }
    }
}

@Composable
fun SetBarColor(color: Color){
    val system = rememberSystemUiController();
    SideEffect {
        system.setStatusBarColor(color)
    }
}

@Composable
fun HomeScreen(){
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ){
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            WalletSection()
            CardsSection()
        }
    }
}