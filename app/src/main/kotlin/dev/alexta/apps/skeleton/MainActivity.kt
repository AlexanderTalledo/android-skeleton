package dev.alexta.apps.skeleton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.alexta.apps.navigation.domain.navigators.NavigationNavigator
import dev.alexta.apps.skeleton.ui.theme.SkeletonTheme
import javax.inject.Inject

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var navigationNavigator: NavigationNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            SkeletonTheme {
                val navController = rememberNavController()

                navigationNavigator.NavGraphs(navController)
            }
        }
    }
}
