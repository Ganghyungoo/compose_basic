package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.composebasic.ui.theme.ComposeBasicTheme

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                BoxExample("Android")

            }
        }
    }
}

@Composable
fun BoxExample(name: String) {
    Box(modifier = Modifier.size(100.dp)) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.align(Alignment.Center)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    ComposeBasicTheme {
        BoxExample("World")
    }
}