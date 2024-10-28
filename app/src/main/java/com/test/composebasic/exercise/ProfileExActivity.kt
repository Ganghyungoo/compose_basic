package com.test.composebasic.exercise

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.test.composebasic.exercise.ProfileExActivity.Companion.data
import com.test.composebasic.exercise.ui.theme.ComposeBasicTheme

class ProfileExActivity : ComponentActivity() {
    companion object{
        val data = Profile(
            imageUrl = "https://camo.githubusercontent.com/5a8d6be7a73175b3f28f6de9a1dfa8c1d8066ae76e99ab9da7cbafac1f24b8c1/68747470733a2f2f666972656261736573746f726167652e676f6f676c65617069732e636f6d2f76302f622f6669746d6174652d65326230332e61707073706f742e636f6d2f6f2f6669746d6174655f696d616765732532466f6e626f6172645f312e706e673f616c743d6d6564696126746f6b656e3d36313766306664392d363164322d343366662d613638392d373665626138613562383336",
            imageDescription = "강현구의 이미지",
            description = "강현구가 하던 프로젝트의 온보딩 화면입니다 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ",
            author = "강현구의 온보딩1"
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
private fun ProfileInner(){
    Surface(modifier = Modifier.padding(5.dp), shadowElevation = 5.dp) {
        Row {
            AsyncImage(
                placeholder = ColorPainter(Color.Black),
                contentScale = ContentScale.Crop,
                model = data.imageUrl,
                contentDescription = data.imageDescription,
                modifier = Modifier.size(50.dp).align(Alignment.CenterVertically).clip(CircleShape)
            )

            Spacer(modifier = Modifier.size(10.dp))

            Column {
                Text(text = data.author)
                Text(text = data.description)
            }
        }
    }

}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Column {
        ProfileInner()
        ProfileInner()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview10() {
    ComposeBasicTheme {
        Greeting2("Android")
    }
}

data class Profile(
    val imageUrl: String,
    val imageDescription: String,
    val description: String,
    val author: String,
)