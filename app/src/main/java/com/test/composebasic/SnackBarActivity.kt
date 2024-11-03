package com.test.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.composebasic.ui.theme.ComposeBasicTheme
import kotlinx.coroutines.launch

class SnackBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SnackBarExample("Android")
                }
            }
        }
    }
}

@Composable
fun SnackBarExample(name: String, modifier: Modifier = Modifier) {
    var counter by remember { mutableStateOf(0) }

    val coroutineScope = rememberCoroutineScope()
    // 단계 3: couroutineScope를 만듭시다.
    // `rememberCoroutineScope`를 사용합니다.

    // 단계 1: scaffoldState를 만들고 Scaffold에 설정합시다.
    // scaffoldState를 만들기 위해 `rememberScaffoldState`를 사용합니다.
    val snackBarHostState = remember {
        SnackbarHostState()
    }
    Scaffold (
        snackbarHost  = { SnackbarHost(snackBarHostState) },
        content = { innerPadding ->
            Button(onClick = {
                counter++
                coroutineScope.launch {
                    snackBarHostState.showSnackbar(
                        message = "카운트 증가:$counter",
                        actionLabel = "닫기",
                        duration = SnackbarDuration.Short
                    )
                }
            },Modifier.padding(innerPadding)) {
                Text("더하기")
            }
        }
    )



        // 단계 2: "더하기" 버튼을 만들어 봅시다.
        // action에서 counter를 증가시킵시다.

        // 단계 4: 버튼의 onClick에서 `coroutineScope.launch`를
        // 사용합니다.

        // 단계 5: 스낵바를 사용하기 위해 `scaffoldState.snackbarHostState.showSnackbar`
        // 사용합니다.

        // `message`에 카운터를 출력합시다.
        // `actionLabel`를 "닫기"로 지정합시다.
        // `duration`에 `SnackbarDuration.Short`를 사용합니다.

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview23() {
    ComposeBasicTheme {
        SnackBarExample("Android")
    }
}