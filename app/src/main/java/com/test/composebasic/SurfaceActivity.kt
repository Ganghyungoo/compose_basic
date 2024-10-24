package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.composebasic.ui.theme.ComposeBasicTheme

class SurfaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                SurfaceExample("Android")

            }
        }
    }
}

@Composable
fun SurfaceExample(name: String) {
//Surface에 elevation 설정
/*    Surface(
        modifier = Modifier.padding(5.dp),
        shadowElevation = 5.dp,
    ){
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }*/

//Bolder 설정
/*    Surface(
        border = BorderStroke(
            width = 2.dp,
            color = Color.Magenta
        ),
        modifier = Modifier.padding(5.dp),
        shadowElevation = 5.dp,
    ){
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }*/

//Shape 설정
/*    Surface(
        border = BorderStroke(
            width = 2.dp,
            color = Color.Magenta
        ),
        modifier = Modifier.padding(5.dp),
        shadowElevation = 5.dp,
        shape = CircleShape
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp),
        )
    }*/

//Color 설정
//MaterialTheme.color에서 색상을 설정하면 자동으로 contentColor가 자동으로 선택된다.
    Surface(
        border = BorderStroke(
            width = 2.dp,
            color = Color.Magenta
        ),
        modifier = Modifier.padding(5.dp),
        shadowElevation = 5.dp,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.error
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp),
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    ComposeBasicTheme {
        SurfaceExample("Android")
    }
}