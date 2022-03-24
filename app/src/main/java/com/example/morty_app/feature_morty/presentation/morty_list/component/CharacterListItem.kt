package com.example.morty_app.feature_morty.presentation.morty_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.morty_app.feature_morty.domain.model.Character

@Composable
fun CharacterListItem(
    character: Character,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(data = character.image),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Text(text = "${character.name}", style = TextStyle(fontSize = 30.sp))
    }
}