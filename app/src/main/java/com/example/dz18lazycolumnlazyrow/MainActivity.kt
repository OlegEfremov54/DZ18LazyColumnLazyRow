package com.example.dz18lazycolumnlazyrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dz18lazycolumnlazyrow.ui.theme.DZ18LazyColumnLazyRowTheme

private val fruit = listOf(
    Item("Яблоко зеленое", R.drawable.apllegrin,10),
    Item("Яблоко красное", R.drawable.apllered,20),
    Item("Виноград", R.drawable.grape,30),
    Item("Дыня", R.drawable.melon,15),
    Item("Апельсин", R.drawable.orange,25),
    Item("Персик", R.drawable.peach,35),
    Item("Груша", R.drawable.grusha,40),
    Item("Ананас", R.drawable.pineapple,45)
)

private val vegetables = listOf(
    Item("Морковь", R.drawable.carrot,10),
    Item("Перец красный", R.drawable.perecred,20),
    Item("Перец оранжевый", R.drawable.perecorand,30),
    Item("Чили", R.drawable.perecchili,40),
    Item("Огурец", R.drawable.ogurec,15),
    Item("Лук", R.drawable.onion,25),
    Item("Рамиро", R.drawable.perecramiro,35),
    Item("Картофель", R.drawable.potato,45),
    Item("Помидоры", R.drawable.tomato,50)
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Screen()
        }
    }
}

data class Item(val name: String, val imageResource: Int, val prace:Int)

@Preview
@Composable
fun ScreenPreview() {
    Screen()
}

@Composable
fun Screen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    )  {
        Text(
            text = "Фрукты (прокрутка в право)",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(2.dp, Color.Black)
                .padding(4.dp)
        )
        LazyRow(
            modifier = Modifier
                .padding(8.dp)
                .border(1.dp, Color.Black)
        ) {
            items(fruit) {
                ItemCeil(it)
            }

        }
        Text(
            text = "Овощи (прокрутка вниз)",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(2.dp, Color.Black)
                .padding(4.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Black)
        ) {
            items(vegetables) {
                ItemCeil(it)
            }
        }
    }
}

@Composable
fun ItemCeil(item: Item) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 8.dp)
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(item.imageResource),
            contentDescription = "",
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp))

        Column {
            Text(
                text = item.name,
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = "Цена "+item.prace.toString() +" руб.",
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp)
            )

        }

    }
}