package com.example.finschoolapp.presentations.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.finschoolapp.ui.theme.mainBackground
import java.lang.reflect.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.theme.NunitoFontFamily
import com.example.finschoolapp.ui.theme.moduleBackgroundDark
import com.example.finschoolapp.ui.theme.third
import com.example.finschoolapp.ui.theme.thirdLight
import java.nio.file.WatchEvent

@Preview
@Composable
fun SplashScreen() {




    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .fillMaxSize()

            .background(color = mainBackground),

    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally

    ){
        Image(painter = painterResource(id = R.drawable.logo_version_1), contentDescription = "logo",modifier = androidx.compose.ui.Modifier
            .padding(10.dp)
            .size(110.dp))
        Text(text="Fin School",style = TextStyle( color =  moduleBackgroundDark, fontSize = 50.sp,fontWeight= FontWeight.ExtraBold, fontFamily = NunitoFontFamily))
    }
}

@Preview
@Composable
fun SplashScreen2() {




    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(color = mainBackground),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(text="Fin School", androidx.compose.ui.Modifier.padding(vertical = 30.dp),
            style = TextStyle( color =  moduleBackgroundDark,
                fontSize = 50.sp,
                fontWeight= FontWeight.ExtraBold,
                fontFamily = NunitoFontFamily),
            )




        Card(
            modifier = androidx.compose.ui.Modifier.fillMaxWidth().padding(10.dp, vertical = 20.dp),
            shape = RoundedCornerShape(15.dp),
//            border = BorderStroke(3.dp, third),
            ) {
            Box(
                modifier =androidx.compose.ui.Modifier.fillMaxWidth().background(thirdLight),
                contentAlignment = Alignment.Center

            ) {
                Text(text="Копейка рубль бережёт!",androidx.compose.ui.Modifier.padding(vertical = 20.dp),
                    textAlign = TextAlign.Right,
                    style = TextStyle( color =  moduleBackgroundDark,
                        fontSize = 19.sp,
                        fontFamily = NunitoFontFamily,
                    ), )
            }

        }



    }
}