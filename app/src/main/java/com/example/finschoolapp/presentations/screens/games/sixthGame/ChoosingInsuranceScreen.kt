package com.example.finschoolapp.presentations.screens.games.sixthGame

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import com.example.finschoolapp.navigation.navBars.BottomNavigationBar
import com.example.finschoolapp.ui.components.buttons.GameButton
import com.example.finschoolapp.ui.components.buttons.HelpButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.textViewBaseVariant


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChoosingInsuranceScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    buttonActions: List<() -> Unit>,
    cashAmount: Int
) {

    val dimensions = LocalDimensions.current
    val palette = ThemeColors.LightTheme
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    var showHelpDialog by remember { mutableStateOf(false) }
    var helpText by remember { mutableStateOf("") }
    var titleHelpText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TextToolbar(
                text = stringResource(id = R.string.insurance),
                titleColor = palette.secondary,
                backgroundColor = palette.thirdLight
            )
        }
    ){ innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = palette.background)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .fillMaxHeight(0.26f)
                    .clip(roundedShape)
                    .background(color = palette.thirdLight)
                    //.padding(vertical = dimensions.verticalNormalPadding)
            ) {
                Text(
                    text = stringResource(id = R.string.choosing_insurance),
                    style = textViewBaseVariant.copy(
                        color = palette.secondary,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(horizontal = 10.dp),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            val buttonTexts = listOf(
                stringResource(id = R.string.dms),
                stringResource(id = R.string.property),
                stringResource(id = R.string.vsr)
            )

            val context = LocalContext.current

            buttonTexts.forEachIndexed { index, buttonText ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HelpButton(
                        onClick = {
                            helpText = getHelpText(context,index)
                            titleHelpText = getHelpTitle(context,index)
                            showHelpDialog = true
                        }
                    )
                    GameButton(
                        modifier = Modifier.width(300.dp),
                        palette = palette,
                        text = buttonText,
                        onClick = buttonActions.get(index)

                    )

                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
            if (showHelpDialog) {
                CustomHelpDialog(
                    text = helpText,
                    title = titleHelpText,
                    onDismissRequest = { showHelpDialog = false }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.second_wallet),
                    contentDescription = "Cash Icon",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "Наличные: $cashAmount",
                    style = textViewBaseVariant.copy(
                        color = palette.secondary,
                        fontWeight = FontWeight.Normal
                    ),
                    textAlign = TextAlign.Start
                )
            }
        }

    }
}


@Composable
fun CustomHelpDialog(title: String, text: String, onDismissRequest: () -> Unit) {

    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = ThemeColors.LightTheme.thirdLight
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Text(
                    text = title,
                    style = textViewBaseVariant.copy(
                        color = ThemeColors.LightTheme.secondary,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(
                    text = text,
                    style = textViewBaseVariant.copy(color = ThemeColors.LightTheme.secondary),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismissRequest) {
                        Text(
                            text = stringResource(id = R.string.ok),
                            style = textViewBaseVariant.copy(
                                color = ThemeColors.LightTheme.secondary,
                                fontWeight = FontWeight.Bold
                            ),
                        )
                    }
                }
            }
        }
    }
}




fun getHelpText(context: Context, index: Int): String {
    return when (index) {
        0 -> context.getString(R.string.help_dms)
        1 -> context.getString(R.string.help_property)
        2 -> context.getString(R.string.help_vsr)
        else -> ""
    }
}

fun getHelpTitle(context: Context,index: Int): String {
    return when (index) {
        0 -> context.getString(R.string.title_help_dms)
        1 -> context.getString(R.string.title_help_property)
        2 -> context.getString(R.string.title_help_vsr)
        else -> ""
    }
}

@Preview
@Composable
fun ChoosingInsuranceScreenPreview() {
    ChoosingInsuranceScreen(
        navController = rememberNavController(),
        buttonActions = listOf(),
        cashAmount = 1000
    )
}
