package net.iessochoa.sergiocontreras.jcretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.JCRetrofitTheme

class UsersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JCRetrofitTheme {

                val snackBarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                var inProgress by remember { mutableStateOf(false)}

                Scaffold(modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackBarHostState) })
                { innerPadding ->
                    UsersView(modifier = Modifier.padding(innerPadding), 
                        inProgress = inProgress)
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun LocalUsersPreview() {
    JCRetrofitTheme {
        UsersPreview()
    }
}