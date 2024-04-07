import com.example.finschoolapp.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
) {

    object Progress: BottomBarScreen(
        route = "progress",
        title = "Progress",
        icon = R.drawable.ic_progress,
    )

    object Learning: BottomBarScreen(
        route = "learning",
        title = "Learning",
        icon = R.drawable.ic_learning,
    )

    object Accounting: BottomBarScreen(
        route = "accounting",
        title = "Accounting",
        icon = R.drawable.ic_accounting,
    )

}