package com.test.composebasic

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
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

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                ButtonExample(onButtonClick = {
                    Toast.makeText(this, "Send Clicked", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClick: () -> Unit) {
//일반 버튼
    /*    Button(onClick = onButtonClick) {
            Text(text = "Send")
        }*/

//버튼의 아이콘 설정 및 아이콘 space설정
    /*    Button(onClick = onButtonClick) {
            Icon(imageVector =  Icons.Filled.Send,
                contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing *//*30.dp*//* ))
        Text(text = "Send")
    }*/

//버튼의 enabled 설정
    /*    Button(onClick = onButtonClick,
            enabled = false) {
            Icon(imageVector =  Icons.Filled.Send,
                contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing *//*30.dp*//* ))
        Text(text = "Send")
    }*/

//버튼의 border Stroke 설정
/*    Button(
        onClick = onButtonClick,
        enabled = true,
        border = BorderStroke(10.dp, Color.Magenta)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(
                ButtonDefaults.IconSpacing *//*30.dp*//* ))
                        Text(text = "Send")
    }*/

//버튼의 circle Shape설정
/*    Button(
        onClick = onButtonClick,
        enabled = true,
        border = BorderStroke(10.dp, Color.Magenta,),
        shape = CircleShape //RoundedCornerShape(10.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(
                ButtonDefaults.IconSpacing *//*30.dp*//* ))
        Text(text = "Send")
    }*/

//버튼의 Padding Value설정
/*    Button(
        onClick = onButtonClick,
        enabled = true,
        border = BorderStroke(10.dp, Color.Magenta,),
        shape = CircleShape, //RoundedCornerShape(10.dp)
        contentPadding = PaddingValues(20.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(
                ButtonDefaults.IconSpacing *//*30.dp*//* ))
        Text(text = "Send")
    }*/

//버튼의 색상 변경
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.Black
        ),
        onClick = onButtonClick,
        enabled = true,
        border = BorderStroke(10.dp, Color.Magenta,),
        shape = CircleShape, //RoundedCornerShape(10.dp)
        contentPadding = PaddingValues(20.dp),
        modifier = Modifier.size(200.dp,100.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(
                ButtonDefaults.IconSpacing /*30.dp*/ ))
        Text(text = "Send")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ComposeBasicTheme {
        ButtonExample(onButtonClick = {})
    }
}