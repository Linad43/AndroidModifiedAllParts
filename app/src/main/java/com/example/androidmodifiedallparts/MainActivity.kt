package com.example.androidmodifiedallparts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidmodifiedallparts.ui.theme.BlueGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val customModifier = Modifier
//                .border(width = 3.dp, color = Color.Red)
//                .padding(2.dp)
//                .background(color = Color.Yellow)
//            Ex1(customModifier)
            val customModifier: Modifier = Modifier
                .padding(0.dp)
                .border(2.dp, Color.Green, shape = RoundedCornerShape(1000.dp))
                .background(BlueGreen, shape = RoundedCornerShape(1000.dp))
                .padding(150.dp)
            Ex2(customModifier)
        }
    }
}

@Composable
fun Ex1(
    modifier: Modifier = Modifier
        .padding(top = 400.dp, start = 150.dp)
        .border(width = 3.dp, color = Color.Red)
        .padding(20.dp),
) {
    var defaultModifier = Modifier
        .padding(top = 400.dp, start = 150.dp)
        .border(width = 3.dp, color = Color.Red)
        .padding(20.dp)
    if (modifier == Modifier) {
        defaultModifier = modifier
    } else {
        defaultModifier = defaultModifier.then(modifier)
    }
    Text(
        text = "Привет",
        modifier = defaultModifier
    )
}

//@Preview(showSystemUi = true)
@Composable
fun Ex2(
    modifier: Modifier = Modifier
        .padding(top = 20.dp, start = 150.dp)
) {
    Text(
        text = "Привет",
        modifier = modifier
    )
}