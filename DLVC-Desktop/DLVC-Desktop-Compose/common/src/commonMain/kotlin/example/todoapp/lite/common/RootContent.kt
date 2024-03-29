package example.todoapp.lite.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import example.todoapp.lite.common.RootStore.RootState

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.util.*
import kotlinx.coroutines.runBlocking

object Routes {
    const val Favorites = "Favorites"
    const val Faces = "Faces"
    const val PostTest = "PostTest"
}

@Composable
fun RootContent2(modifier: Modifier = Modifier) {
    val routes = remember { mutableStateOf(Routes.Favorites) }
    var text by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("DLVC Taverne 2.0") },
                actions = {
                    IconButton(onClick = { routes.value = Routes.Favorites }) {
                        Icon(Icons.Filled.Send, contentDescription = null)
                    }
                    IconButton(onClick = { routes.value = Routes.Faces }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                    IconButton(onClick = {
                        testPost()
                        routes.value = Routes.PostTest
                    }) {
                        Icon(Icons.Filled.Home, contentDescription = null)
                    }
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.AddCircle, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                sampleButton()
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true,
        content = { innerPadding ->
            if(routes.value == Routes.Favorites) {
                middleLayout(modifier, innerPadding)
            } else if (routes.value == Routes.Faces) {
                TextField(
                    value = text,
                    onValueChange = { changedText:String -> text = changedText },
                    label = { Text("Name") }
                )
            } else if (routes.value == Routes.PostTest) {
                Text("PostTest")
            } else {
                Text("Unknown route")
            }
        }
    )
}

@Composable
private fun middleLayout(
    modifier: Modifier,
    innerPadding: PaddingValues
) {
        RootContent(
            modifier = modifier.padding(innerPadding)
        )
}

@Composable
private fun sampleButton() {
    Button(
        onClick = { /* ... */ },
        // Uses ButtonDefaults.ContentPadding by default
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
    ) {
        // Inner content including an icon and a text label
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}

@Composable
fun RootContent(modifier: Modifier = Modifier) {
    val model = remember { RootStore() }
    val state = model.state

    MainContent(
        modifier = modifier,
        items = state.items,
        inputText = state.inputText,
        onItemClicked = model::onItemClicked,
        onItemDoneChanged = model::onItemDoneChanged,
        onItemDeleteClicked = model::onItemDeleteClicked,
        onAddItemClicked = model::onAddItemClicked,
        onInputTextChanged = model::onInputTextChanged,
    )

    state.editingItem?.also { item ->
        EditDialog(
            item = item,
            onCloseClicked = model::onEditorCloseClicked,
            onTextChanged = model::onEditorTextChanged,
            onDoneChanged = model::onEditorDoneChanged,
        )
    }
}

@OptIn(InternalAPI::class)
fun testPost() {
    val client = HttpClient(CIO) {
        install(HttpTimeout) {
            requestTimeoutMillis = 5000
        }
    }

    runBlocking {
        val response = client.post("http://localhost:8080/hello") {
            header("Content-Type", "application/json")
            body = """{ "text": "Aber Hallo!" }"""
        }
        println(response)
    }
}

private val RootState.editingItem: TodoItem?
    get() = editingItemId?.let(items::firstById)

private fun List<TodoItem>.firstById(id: Long): TodoItem =
    first { it.id == id }
