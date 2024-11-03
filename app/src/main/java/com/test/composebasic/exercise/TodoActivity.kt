package com.test.composebasic.exercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.composebasic.exercise.ui.theme.ComposeBasicTheme

class TodoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopLevel()
                }
            }
        }
    }
}

@Composable
fun TopLevel() {
    val (text, setText) = remember { mutableStateOf("") }
    val toDoList = remember { mutableStateListOf<ToDoData>() }
    val onSummit: (String) -> Unit = {
        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
        toDoList.add(ToDoData(key, text))
        setText("")
    }
    // 단계 4: `onSubmit`, `onEdit`, `onToggle`, `onDelete`를
    // 만들어 `ToDo`에 연결합니다.
    val onToggle : (key: Int, isChecked: Boolean) -> Unit = { key, checked ->
        val i = toDoList.find { it.key == key } ?: toDoList.first()
        toDoList[toDoList.indexOf(i)] = i.copy(done = checked)
    }

    val onDelete: (key:Int) -> Unit = {key ->
        val i = toDoList.find { it.key == key } ?: toDoList.first()
        toDoList.remove(i)
    }

    val onEdit: (key:Int , content:String) -> Unit = {key, content ->
        val i = toDoList.find { it.key == key } ?: toDoList.first()
        toDoList.set(toDoList.indexOf(i),i.copy(text = content))
    }
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            ToDoInput(
                text = text,
                onTextChange = setText,
                onSubmit = onSummit
            )
            // 단계 3: `LazyColumn`으로 `toDoList`를 표시합시다.
            // `key`를 `toDoData`의 `key`를 사용합니다.
            LazyColumn{
                items(toDoList, key = {innerData->
                    innerData.key

                }){ toDoData ->
                    ToDo(toDoData = toDoData,
                        onToggle = onToggle,
                        onDelete = onDelete,
                        onEdit = onEdit
                        )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicTheme {
        TopLevel()
    }
}

@Composable
fun ToDoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit,
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            onSubmit(text)
        }) {
            Text("입력")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoInputPreview() {
    ComposeBasicTheme {
        ToDoInput("테스트", {}, {})
    }
}

@Composable
fun ToDo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {},
) {
    var isEditing by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {

        // 단계 1: `Row`를 만들고 `toDoData.text`를 출력하고
        // 완료를 체크하는 체크박스, 수정 버튼, 삭제 버튼을 만드세요.
        /*        Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = toDoData.text,
                        modifier = Modifier.weight(1f)
                    )
                    Text(text = "완료")
                    Checkbox(
                        checked = toDoData.done,
                        onCheckedChange = { checked ->
                        onToggle(toDoData.key, checked)
                    })
                    Button(onClick = { }) {
                        Text(text = "수정")
                    }
                    Spacer(modifier = Modifier.size(5.dp))
                    Button(onClick = { }) {
                        Text(text = "삭제")
                    }
                }*/
        // 단계 2: `Crossfade`를 통해 `isEditing`을 따라 다른
        // UI를 보여줍니다. `OutlinedTextField`와 `Button을
        // 넣어봅시다.
        Crossfade(targetState = isEditing, label = "편집 상태에 따른 crossFade") {
            when (it) {
                false -> {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = toDoData.text,
                            modifier = Modifier.weight(1f)
                        )
                        Text(text = "완료")
                        Checkbox(
                            checked = toDoData.done,
                            onCheckedChange = { checked ->
                                onToggle(toDoData.key, checked)
                            })
                        Button(onClick = {
                            isEditing = true
                        }) {
                            Text(text = "수정")
                        }
                        Spacer(modifier = Modifier.size(5.dp))
                        Button(onClick = { onDelete(toDoData.key) }) {
                            Text(text = "삭제")
                        }
                    }
                }

                true -> {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)) {
                        val (newText,setNewText) = remember {
                            mutableStateOf(toDoData.text)
                        }
                        OutlinedTextField(
                            value = newText,
                            onValueChange = setNewText,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                        Button(onClick = { isEditing = false
                        onEdit(toDoData.key, newText)}) {
                            Text(text = "완료")
                        }
                    }
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoPreview() {
    ComposeBasicTheme {
        ToDo(ToDoData(1, "nice", true))
    }
}

data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false,
)