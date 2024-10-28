package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
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

//박스의 일반적인 사용
/*    Box(modifier = Modifier.size(100.dp)) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.align(Alignment.Center)
        )
    }*/

//박스안에 두개의 컴포넌트 배치
/*    Box(modifier = Modifier.size(100.dp)) {
        Text(
            text = "강현구",
            modifier = Modifier.align(Alignment.TopEnd)
            )
        Text(
            text = "강현구",
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }*/

//2개의 박스를 박스안에 배치하기
/*    Box(modifier = Modifier.size(100.dp)){
        Box(modifier = Modifier
            .size(70.dp)
            .align(Alignment.TopStart)
            .background(Color.Black))
        Box(modifier = Modifier
            .size(70.dp)
            .align(Alignment.BottomEnd)
            .background(Color.Magenta))
    }*/

//부모 박스의 modifier를 제거하고 콘텐트 사이즈만큼 보여준다
//또한 첫번쨰 자식 Box의 사이즈를 matchParentSize로 설정한다
//다음엔 fillMaxSize()로 설정해본다
    Box {
        Box (modifier = Modifier.fillMaxSize().align(Alignment.TopStart).background(Color.Cyan))
        Box (modifier = Modifier.size(70.dp).align(Alignment.TopStart).background(Color.Red))

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    ComposeBasicTheme {
        BoxExample("World")
    }
}