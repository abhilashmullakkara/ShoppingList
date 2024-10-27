import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myshopping.ui.theme.admob.ItemViewModel

@Composable
fun ItemListScreen(itemViewModel: ItemViewModel = viewModel()) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val itemList by itemViewModel.allItems.collectAsStateWithLifecycle(lifecycleOwner.lifecycle)

    Column {
        if (itemList.isEmpty()) {
            Text(text = "No items in the database", color = Color.Gray)
        } else {
            itemList.forEach { item ->
                Row(modifier = Modifier.padding(8.dp)) {
                    Text(text = item.name, color = Color.White, fontSize = 16.sp, modifier = Modifier.weight(1f))
                    Text(text = item.quantity, color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}
