package com.example.androidmodifiedallparts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidmodifiedallparts.ui.theme.BlueGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Ex1_1(Modified.NULL)
            val customModifier: Modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
                .border(2.dp, Color.Green, shape = CircleShape)
                .background(BlueGreen, shape = CircleShape)
                .padding(150.dp)
//            Ex2()
            Ex2(customModifier)
        }
    }
}

enum class Modified {
    DEFAULT, CUSTOM, NULL
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
fun Ex1_1(choice: Modified) {
//    val choice = Modified.NULL
    var modifier: Modifier = Modifier
    var horizontal = Alignment.Start
    var modifierOut: Modifier = Modifier
    when (choice) {
        Modified.DEFAULT -> {
            horizontal = Alignment.CenterHorizontally
            modifier = Modifier
                .padding(top = 400.dp)
                .border(width = 3.dp, color = Color.Red)
                .padding(20.dp)
            modifierOut = Modifier
                .fillMaxWidth()
        }

        Modified.CUSTOM -> {
            horizontal = Alignment.CenterHorizontally
            modifier = Modifier
                .padding(top = 400.dp)
                .border(width = 3.dp, color = Color.Red)
                .padding(20.dp)
                .background(color = Color.Yellow)
                .border(width = 3.dp, color = Color.Red)
                .padding(5.dp)
            modifierOut = Modifier
                .fillMaxWidth()
        }

        Modified.NULL -> {
        }
    }
    Column(
        horizontalAlignment = horizontal,
        modifier = modifierOut
    ) {
        Column(
            horizontalAlignment = horizontal,
            modifier = modifier
        ) {
            Text(
                text = "Привет",
                fontSize = 20.sp
            )
        }
    }
}


//@Preview(showSystemUi = true)
@Composable
fun Ex2(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(top = 20.dp, start = 150.dp)

) {
    Text(
        text = "Привет",
        modifier = modifier
    )
}