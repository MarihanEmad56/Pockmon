package com.example.test4.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.test4.data.ImageItem
import com.example.test4.data.imageList

@Composable
fun PockmonItem(item: ImageItem) {
    var isFavouriteState by rememberSaveable { mutableStateOf(false) }
    val icon= if(isFavouriteState){
        Icons.Filled.Favorite

    } else {
        Icons.Filled.FavoriteBorder
    }
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(140.dp),
        colors = CardDefaults.cardColors(containerColor = item.bckground)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {

            PockmonDetails(item, Modifier.weight(0.60f))
            PockmonIcon(item, Modifier.weight(0.30f))
            FavouriteItemIcon(icon,Modifier.weight(0.10f)){
                isFavouriteState=!isFavouriteState
            }
        }
    }
}

@Composable
fun FavouriteItemIcon(icon :ImageVector, modifier: Modifier,onClick :() -> Unit) {

    Image(imageVector = icon,
        contentDescription ="Favourite Item Icon",
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onClick()
            }
    )
}

@Composable
fun PockmonDetails(item: ImageItem, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = item.description)
        Row {
            Text(
                text = " ${item.type}     ",
                modifier = Modifier.background(item.Typebckground, shape = CircleShape))

            Column {
                Text(text = "Attack: ${item.Attack}")
                Text(text = "Defense: ${item.Defense}")
            }
        }
    }
}

@Composable
fun PockmonIcon(item: ImageItem, modifier: Modifier) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .size(290.dp)
            .background(item.Iconbckground, shape = CircleShape)


    ) {
        Image(
            painter = painterResource(id = item.id),
            contentDescription = item.description,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun PockmonList() {
    LazyColumn {
        items(imageList) { item ->
            PockmonItem(item)
        }
    }
}
