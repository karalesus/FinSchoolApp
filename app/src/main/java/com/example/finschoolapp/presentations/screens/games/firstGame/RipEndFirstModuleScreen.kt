package com.example.finschoolapp.presentations.screens.games.firstGame


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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.mainHeader
import com.example.finschoolapp.ui.theme.textViewBaseVariant
import com.example.finschoolapp.ui.theme.thirdLight

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RipEndFirstModuleScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val palette = ThemeColors.LightTheme

    Scaffold(
        topBar = {
            TextToolbar(
                text = stringResource(id = R.string.label_rip_game),
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
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.image_game_1_rip),
                    contentDescription = null,
                    modifier = Modifier
//                        .size(400.dp)
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
                        modifier = Modifier.fillMaxWidth().height(100.dp)
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally).padding(10.dp),
                            text = stringResource(id = R.string.text_rip_game),
                            style = textViewBaseVariant.copy(color = palette.secondary)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = stringResource(id = R.string.text_tom_rip),
                        style = textViewBaseVariant.copy(color = palette.secondary, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(vertical = 8.dp).align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    PrimaryButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        palette = ThemeColors.LightTheme,
                        text = stringResource(id = R.string.try_again),
                        navController = navController,
                        route = com.example.finschoolapp.navigation.games.NeedHelpScreen.StartGame.route
                    )

                }
            }
        }
    }
}

@Composable
@Preview
fun RipEndFirstModuleScreenPreview() {
    RipEndFirstModuleScreen(
        modifier = Modifier,
        navController = rememberNavController()
    )
}
