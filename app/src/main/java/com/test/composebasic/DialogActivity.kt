package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.composebasic.ui.theme.ComposeBasicTheme

class DialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DialogExample("Android")
                }
            }
        }
    }
}

@Composable
fun DialogExample(name: String, modifier: Modifier = Modifier) {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = !openDialog }) {
            Text("다이얼로그 열기")
        }
        Text("카운터: $counter")
    }

    if (openDialog) {
        AlertDialog(onDismissRequest = {
            // 단계 1: `openDialog`를 이용해 다이얼로그를 끌 수 있게 합니다.
            openDialog = false
        }, confirmButton = {
            // 단계 2: "더하기" 버튼을 만들고 `counter`를 증가시킵니다.
            // 다이얼로그도 끕니다.
            Button(
                onClick = {
                    counter++
                    openDialog = false
                }
            ) {
                Text(text = "더하기")
            }
        }, dismissButton = {
            // 단계 3: "취소" 버튼을 만들고 다이얼로그를 끕니다.
            Button(
                onClick = {
                    openDialog = false
                }
            ) {
                Text(text = "취소")
            }
        }, title = {
            // 단계 4: 타이틀을 만듭니다. "더하기" 정도로 해봅시다.
            Text(text = "카운트 추가 다이얼로그")
        }, text = {
            // 단계 5: 다이얼로그에서 설명할 문구를 출력합니다.
            Text(text = "더하기를 누르면 카운트가 추가됩니다")
        })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview21() {
    ComposeBasicTheme {
        DialogExample("Android")
    }
}