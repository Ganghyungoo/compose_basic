package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.test.composebasic.ui.theme.ComposeBasicTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme

                ImageExample("Android")
                
            }
        }
    }
}

@Composable
fun ImageExample(name: String, modifier: Modifier = Modifier) {
    Column {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "이미지")

        Image(
            imageVector = Icons.Filled.Settings,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            contentDescription = "이미지2"
            )

        //코일 활용한 이미지 로딩 방법
        AsyncImage(
            model = "https://camo.githubusercontent.com/53484054ec800c883a2739932a36854fea7885626e5682e4358ff724d934d359/68747470733a2f2f666972656261736573746f726167652e676f6f676c65617069732e636f6d2f76302f622f6669746d6174652d65326230332e61707073706f742e636f6d2f6f2f6669746d6174655f696d616765732532466669746d6174655f6d61696e70686f746f2e706e673f616c743d6d6564696126746f6b656e3d66643431623462302d333033632d343034372d386334332d386365303961636637356565",
            contentDescription = "네트워크 이미지 로드",
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview9() {
    ComposeBasicTheme {
        ImageExample("Android")
    }
}