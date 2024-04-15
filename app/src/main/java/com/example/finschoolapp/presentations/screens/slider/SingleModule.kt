package com.example.finschoolapp.presentations.screens.slider

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.ui.theme.smallDescription
import com.example.finschoolapp.ui.theme.smallDescriptionLight
import com.example.finschoolapp.ui.theme.smallHeader
import com.example.finschoolapp.ui.theme.smallHeaderLight


@Composable
fun SingleModule(module: Module) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = module.image),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(140.dp)
        )
        Spacer(
            modifier = Modifier.size(8.dp)
        )
        Text(
            text = module.title,
            style = smallHeaderLight,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = module.description,
            style = smallDescriptionLight,
            textAlign = TextAlign.Center
        )
    }
}