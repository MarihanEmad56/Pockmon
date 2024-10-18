package com.example.test4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.test4.ui.theme.PockmonList
import com.example.test4.ui.theme.Test4Theme
import androidx.compose.ui.Modifier // Import Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test4Theme {
                Surface(modifier = Modifier.fillMaxSize()) { // Use Modifier directly
                    PockmonList() // Call your list here
                }
            }
        }
    }
}
