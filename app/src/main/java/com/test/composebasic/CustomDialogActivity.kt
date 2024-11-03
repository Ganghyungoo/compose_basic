package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.test.composebasic.ui.theme.ComposeBasicTheme

class CustomDialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CustomDialogExample("Android")
                }
            }
        }
    }
}

@Composable
fun CustomDialogExample(name: String, modifier: Modifier = Modifier) {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = {
            openDialog = true
        }) {
            Text("다이얼로그 열기")
        }
        Text("카운터: $counter")
    }

    if (openDialog) {
        Dialog(onDismissRequest = {
            // 단계 1: 디스미스 처리를 합니다.
            openDialog = false
        }) {
            Surface(
                shape = RoundedCornerShape(32.dp)
            ) {
                // 단계 2: 컬럼을 만들고 설명을 적어봅시다.

                // 단계 3: 컬럼 안에 로우를 만들어 수평 방향으로 버튼을 배열합니다.
                // 버튼은 +1, -1, 취소로 구성하겠습니다.

                // +1은 counter를 증가시키고 -1은 감소, 취소는 다이얼로그를 닫습니다.
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(text = "버튼을 클릭해주세요")
                    Text(text = "+1을 누르면 더하기\n-1을 누르면 뺴기")
                    Spacer(modifier = Modifier.size(10.dp))
                    Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Button(onClick = {
                            openDialog = false
                        }) {
                            Text(text = "취소")
                        }
                        Button(onClick = {
                            counter++
                            openDialog = false
                        }) {
                            Text(text = "더하기(+)")
                        }
                        Button(onClick = {
                            counter--
                            openDialog = false
                        }) {
                            Text(text = "빼기(-)")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview22() {
    ComposeBasicTheme {
        CustomDialogExample("Android")
    }
}