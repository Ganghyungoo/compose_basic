package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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

class SlotApiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SlotApiExample()
                }
            }
        }
    }
}

@Composable
private fun CheckCoxWithText(checkState: Boolean, onChanged:() -> Unit, content: @Composable RowScope.() -> Unit){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onChanged() }.fillMaxWidth()
    ) {
        Checkbox(checked = checkState, onCheckedChange = {onChanged()} )
        content()
    }

}

@Composable
fun SlotApiExample() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Column {
        CheckCoxWithText(checkState = checked1, {checked1 = !checked1}){
            Text(text = "강현구1")
        }
        CheckCoxWithText(checkState = checked2, {checked2 = !checked2}){
            Text(text = "강현구2")
        }
    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview14() {
    ComposeBasicTheme {
        SlotApiExample()
    }
}