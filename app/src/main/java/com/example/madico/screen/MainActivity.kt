package com.example.madico.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.madico.ui.theme.MadicoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MadicoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box (modifier = Modifier
                        .padding(innerPadding).fillMaxSize()){
                        singupSceen()

                    }

                }
            }
        }
    }
}

