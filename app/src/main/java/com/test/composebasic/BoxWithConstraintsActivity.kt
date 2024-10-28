package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.composebasic.ui.theme.ComposeBasicTheme

class BoxWithConstraintsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                BoxWithConstraintsExample()

            }
        }
    }
}

@Composable
fun Outer() {
        Column() {
            BoxWithConstraintsExample(Modifier.widthIn(min = 40.dp,max = 300.dp).heightIn(min = 100.dp, max = 150.dp))
        }
}

@Composable
private fun BoxWithConstraintsExample(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier = modifier) {
        if (maxHeight > 35.dp){
            Text(text = "여기 있습니다", modifier = Modifier.align(Alignment.BottomCenter))
        }
        Text(
            text = "maxW:$maxWidth maxH:$maxHeight minW:$minWidth minH:$minHeight",
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    ComposeBasicTheme {
        Outer()
    }
}