package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.composebasic.ui.theme.ComposeBasicTheme

class RowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                RowExample("Android")

            }
        }
    }
}

@Composable
fun RowExample(name: String, modifier: Modifier = Modifier) {

/*    Row(modifier = Modifier.height(40.dp)) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.align(Alignment.Bottom)
        )
        Text(
            text = "Hello $name!",
            modifier = Modifier.align(Alignment.Bottom)
        )
    }*/

//row 자체에 vertical 제약을 거는 방식이 있으며 개별적으로 align 설정이 가능함
/*    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.height(40.dp)) {
        Text(text = "Hello $name!",)
        Text(text = "Hello $name!",)
    }*/

//horizontalArrangement로 weight설정이 가능함
/*    Row(
        horizontalArrangement = Arrangement.Center, //SpaceAround,SpaceBetween,SpaceEvenly
        modifier = Modifier.size(200.dp,40.dp)
    ) {
        Text(text = "강현구")
        Text(text = "강현구")
        Text(
            modifier = Modifier.align(Alignment.Bottom),
            text = "강현구"
        )
    }*/

//개별적인 weight로 크기 설정 가능함.
    Row(
        horizontalArrangement = Arrangement.Center, //SpaceAround,SpaceBetween,SpaceEvenly
        modifier = Modifier.size(200.dp,40.dp)
    ) {
        Text(
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.Top).weight(3f).background(Color.Magenta),
            text = "강 현구",

        )
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "추가",
            modifier.background(Color.Red).align(Alignment.CenterVertically).weight(1f)
        )
        Text(
            modifier = Modifier.align(Alignment.Bottom).weight(3f).background(Color.Blue),
            text = "강 현구"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    ComposeBasicTheme {
        RowExample("Android")
    }
}