package example.todoapp.lite.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import example.todoapp.lite.common.RootStore.RootState

object Routes { // TODO: What are objects in Kotlin?
    const val Favorites = "Favorites"
    const val Faces = "Faces"
}

@Composable
fun RootContent2(modifier: Modifier = Modifier) {
    val routes = remember { mutableStateOf(Routes.Favorites) }

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
                    IconButton(onClick = { /* doSomething() */ }) {
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
            } else {
                Text("Faces")
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

private val RootState.editingItem: TodoItem?
    get() = editingItemId?.let(items::firstById)

private fun List<TodoItem>.firstById(id: Long): TodoItem =
    first { it.id == id }
