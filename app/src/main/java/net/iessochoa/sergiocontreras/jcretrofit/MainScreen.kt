package net.iessochoa.sergiocontreras.jcretrofit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.JCRetrofitTheme
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.Typography

/**
 * Project: JC Retrofit
 * From: net.iessochoa.sergiocontreras.jcretrofit
 * Created by: Contr
 * On: 25/10/2025 at 22:15
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    JCRetrofitTheme {
        MainView(
            Modifier
                .padding(top = 24.dp),
            inProgres = false,
            onGoUsers = { },
            onClick = { }
        )
    }
}

@Composable
fun MainView(
    modifier: Modifier,
    inProgres: Boolean = false,
    onGoUsers: () -> Unit,
    onClick: () -> Unit)
{
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("")}

    Box(modifier = modifier) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = stringResource(R.string.main_login_title),
                style = Typography.headlineSmall
            )
        }


    }

}