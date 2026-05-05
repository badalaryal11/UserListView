package com.example.userlistviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.userlistviewer.data.remote.RetrofitClient
import com.example.userlistviewer.data.repository.UserRepository
import com.example.userlistviewer.ui.navigation.AppDestinations
import com.example.userlistviewer.ui.screen.UserDetailScreen
import com.example.userlistviewer.ui.screen.UserListScreen
import com.example.userlistviewer.ui.viewmodel.UserUiState
import com.example.userlistviewer.ui.viewmodel.UserViewModel
import com.example.userlistviewer.ui.viewmodel.UserViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val viewModel: UserViewModel = viewModel(
                factory = UserViewModelFactory(UserRepository(RetrofitClient.apiService))
            )
            val uiState by viewModel.uiState.collectAsState()

            NavHost(
                navController = navController,
                startDestination = AppDestinations.USER_LIST
            ) {
                composable(AppDestinations.USER_LIST) {
                    UserListScreen(
                        uiState = uiState,
                        onUserClick = { userId ->
                            navController.navigate("${AppDestinations.USER_DETAIL}/$userId")
                        },
                        onRetry = viewModel::loadUsers
                    )
                }

                composable(
                    route = "${AppDestinations.USER_DETAIL}/{userId}",
                    arguments = listOf(navArgument("userId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val userId = backStackEntry.arguments?.getInt("userId")
                    val users = (uiState as? UserUiState.Success)?.users.orEmpty()
                    val selectedUser = users.find { it.id == userId }
                    UserDetailScreen(user = selectedUser)
                }
            }
        }
    }
}
