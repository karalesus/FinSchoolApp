package com.example.finschoolapp.navigation.navBars

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.ui.theme.ThemeColors
import androidx.compose.ui.Modifier
import com.example.finschoolapp.ui.theme.secondary


@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    palette: ThemeColors = ThemeColors.Theme
) {
    //notify if it is changes
    val navigationBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navigationBackStackEntry?.destination?.route

    NavigationBar(
        modifier = modifier,
        containerColor = palette.thirdLight,
    ) {
        navigationBarItems.forEach { item: NavigationBarItem ->
            val isSelected = currentRoute == item.route

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            if (currentRoute != null) { popUpTo(route = currentRoute) }
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(item.icon),
                        contentDescription = null,
                        tint = secondary
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = palette.secondary
                    )
                },
            )
        }
    }
}

@Preview
@Composable
fun MainNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController())
}