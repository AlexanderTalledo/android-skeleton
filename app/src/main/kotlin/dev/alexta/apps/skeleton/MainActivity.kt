package dev.alexta.apps.skeleton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.currentRecomposeScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.alexta.apps.features.home.detail.ui.HomeDetailScreen
import dev.alexta.apps.features.master.ui.HomeMasterScreenRenderer
import dev.alexta.apps.shared.ui.domain.screens.ScreenRenderer
import dev.alexta.apps.skeleton.ui.theme.SkeletonTheme
import kotlinx.serialization.Serializable
import javax.inject.Inject

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {

    @Inject
    lateinit var homeDetailScreen: HomeDetailScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            SkeletonTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = HomeMasterDestination
                ) {
                    composable<HomeMasterDestination> {
                        HomeMasterScreenRenderer().Render()
                    }

                    composable("HomeDetail") {
                        homeDetailScreen.Display()
                    }
                }
            }
        }
    }
}

@Serializable
object HomeMasterDestination
