package com.example.finschoolapp.presentations.screens.games.seventhGame

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.navigation.navBars.BottomNavigationBar
import com.example.finschoolapp.ui.components.animation.ConfettiAnimation
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.mainHeader
import com.example.finschoolapp.ui.theme.textViewBaseVariant
import com.example.finschoolapp.ui.theme.thirdLight

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EndSeventhModuleScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val palette = ThemeColors.LightTheme
    var showConfetti by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TextToolbar(
                text = stringResource(id = R.string.label_hooray_lower),
                titleColor = mainHeader.color,
                backgroundColor = ThemeColors.LightTheme.thirdLight,
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = palette.background),
        ) {
            ConfettiAnimation(visible = showConfetti)
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_character_end_lvl7),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                        .align(Alignment.Center)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = thirdLight,
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth().height(110.dp)
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally).padding(10.dp),
                            text = stringResource(id = R.string.end_seventh_module),
                            style = textViewBaseVariant.copy(color = palette.secondary)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = stringResource(id = R.string.increase_level),
                        style = textViewBaseVariant.copy(color = palette.secondary, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(vertical = 8.dp).align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    PrimaryButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        palette = ThemeColors.LightTheme,
                        text = stringResource(id = R.string.button_complete_module),
                        navController = navController,
                        route = ""
                    )

                }
            }
        }
    }
}

@Composable
@Preview
fun EndSeventhModuleScreenPreview() {
    EndSeventhModuleScreen(
        modifier = Modifier,
        navController = rememberNavController())
}
