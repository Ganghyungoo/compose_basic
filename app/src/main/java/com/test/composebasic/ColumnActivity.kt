package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.composebasic.ui.theme.ComposeBasicTheme

class ColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColumnExample("Android")
                }
            }
        }
    }
}

@Composable
fun ColumnExample(name: String, modifier: Modifier = Modifier) {
/*        Column(modifier = Modifier.size(100.dp)) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }*/

//weight설정
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, //End, Start
        verticalArrangement = Arrangement.Center, //Bottom 등등...
        modifier = Modifier.size(100.dp)
    ) {
        Text(
            text = "Hello",
            modifier = modifier
        )
        Text(
            text = "Hello",
            modifier = modifier
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    ComposeBasicTheme {
        ColumnExample("Android")
    }
}