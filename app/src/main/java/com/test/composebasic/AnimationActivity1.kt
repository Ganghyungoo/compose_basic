package com.test.composebasic

import android.graphics.Color.LTGRAY
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.composebasic.ui.theme.ComposeBasicTheme

class AnimationActivity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting3("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    var helloWorldVisible by remember { mutableStateOf(true) }
    var isRed by remember { mutableStateOf(false) }

    //val backgroundColor = Color(LTGRAY)


    val colorState by animateColorAsState(targetValue = if (isRed) Color.Red else Color.White)
    // 단계 4: `backgroundColor`를 `animateColorAsState`로
    // 변경하세요.
    // `targetValue`는 `isRed`에 따라 `Color`를 설정합니다.

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(colorState)
    ) {

        AnimatedVisibility(
            visible = helloWorldVisible,
            enter = expandVertically()
        ) {
            Text(text = "Hello World!")
        }

        // 단계 1: `Text`를 `AnimatedVisibility`로 감싸고 `visible`을
        // `helloWorldVisible`로 지정해봅시다.

        // 단계 2: `enter` 파라미터를 바꾸어봅시다.
        // 예:
        // `expandHorizontally()`
        // `scaleIn()`
        // `slideInHorizontally()`
        // `fadeIn()`

        // 단계 3: `enter` 값을 덧셈으로 결합해봅시다.
        // `exit`도 적절한 값을 설정해봅시다.
        Row(
            Modifier.selectable(
                selected = helloWorldVisible,
                onClick = {
                    helloWorldVisible = true
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = helloWorldVisible,
                onClick = { helloWorldVisible = true }
            )
            Text(
                text = "Hello World 보이기"
            )
        }

        Row(
            Modifier.selectable(
                selected = !helloWorldVisible,
                onClick = {
                    helloWorldVisible = false
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !helloWorldVisible,
                onClick = { helloWorldVisible = false }
            )
            Text(
                text = "Hello World 감추기"
            )
        }

        Text(text = "배경 색을 바꾸어봅시다.")

        Row(
            Modifier.selectable(
                selected = !isRed,
                onClick = {
                    isRed = false
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !isRed,
                onClick = { isRed = false }
            )
            Text(
                text = "흰색"
            )
        }

        Row(
            Modifier.selectable(
                selected = isRed,
                onClick = {
                    isRed = true
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isRed,
                onClick = { isRed = true }
            )
            Text(
                text = "빨간색"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview24() {
    ComposeBasicTheme {
        Greeting3("Android")
    }
}