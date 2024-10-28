package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.composebasic.ui.theme.ComposeBasicTheme

class CheckboxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CheckBoxExample("Android")
                }
            }
        }
    }
}

@Composable
fun CheckBoxExample(name: String, modifier: Modifier = Modifier) {

//컴포저블 함수는 언제든지 다시 호출 될 수 있고 다시 그려질 수 있기 때문에 mutableStateOff형태의 값을 remember에 담아서 값을 연결시켜줘야한다.
    /*    val checked = remember { mutableStateOf(false) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked.value, onCheckedChange = { checked.value = !checked.value })

            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }*/

//위임된 속성(delegated properties)로 변경하여 직관적으로 사용하기
/*    var checked by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = { checked = !checked })
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }*/

//비구조화를 활용해서 destruction으로 상태를 받아서 시용한다
    var (checked,setter) = remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = setter )
        Text(
            text = "Hello $name!",
            modifier = Modifier.clickable {
                setter(!checked)
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview11() {
    ComposeBasicTheme {
        CheckBoxExample("Android")
    }
}