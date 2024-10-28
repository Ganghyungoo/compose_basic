package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.composebasic.ui.theme.ComposeBasicTheme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                TextFieldExample("Android")
            }
        }
    }
}

@Composable
fun TextFieldExample(name: String, modifier: Modifier = Modifier) {
/*    var text by remember { mutableStateOf("ㅋㅋㅋ") }
    Column {
        TextField(value = "$text", onValueChange = {text = it} )
        Text(text = "$text")
    }*/

//라벨 추가 및 destruction 사용버젼
/*    val (text, changeText) = remember { mutableStateOf("ㅋㅋㅋ") }
    Column {
        TextField(value = "$text", onValueChange = changeText, label = {Text(text = "입력칸")}  )
        Text(text = "$text")
    }*/

//아웃라인 활용 방법
    val (text, changeText) = remember { mutableStateOf("ㅋㅋㅋ") }
    Column(modifier = Modifier.padding(5.dp)) {
        OutlinedTextField(value = "$text", onValueChange = changeText, label = {Text(text = "입력칸")}  )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "$text")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview12() {
    ComposeBasicTheme {
        TextFieldExample("Android")
    }
}