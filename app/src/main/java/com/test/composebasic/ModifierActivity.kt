package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.composebasic.ui.theme.ComposeBasicTheme

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme

                ModifierExample(onButtonClick = {})

            }
        }
    }
}

@Composable
fun ModifierExample(onButtonClick: () -> Unit) {
//기본적인 modifier설정 방법
/*    Button(
        onClick = onButtonClick,
        modifier = Modifier
            .height(100.dp)
            .width(200.dp),
        shape = RoundedCornerShape(0.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Search")
    }*/

//width, height 손쉬운 설정 방법
/*    Button(
            onClick = onButtonClick,
    modifier = Modifier.size(200.dp, 100.dp),
    shape = RoundedCornerShape(0.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Search")
    }*/

//버튼의 padding을 추가하는 법
/*    Button(
        onClick = onButtonClick,
        modifier = Modifier.size(200.dp, 100.dp).padding(10.dp),
        shape = RoundedCornerShape(0.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Search")
    }*/

//modifier에 clickable 설정
/*    Button(
        enabled = false,
        onClick = onButtonClick,
        modifier = Modifier.size(200.dp, 100.dp).padding(10.dp),
        shape = RoundedCornerShape(0.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            color = Color.Black,
            text = "Search",
            modifier = Modifier.clickable {

            }
        )
    }*/

//offset설정 방법
    Button(
        onClick = onButtonClick,
        modifier = Modifier.size(200.dp, 100.dp).padding(10.dp),
        shape = RoundedCornerShape(0.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing).background(Color.Black))
        Text(
            text = "Search",
            modifier = Modifier.offset(x = 10.dp)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    ComposeBasicTheme {
        ModifierExample(onButtonClick = {})
    }
}