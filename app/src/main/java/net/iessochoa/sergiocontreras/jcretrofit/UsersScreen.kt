package net.iessochoa.sergiocontreras.jcretrofit

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.jcretrofit.entities.Data
import net.iessochoa.sergiocontreras.jcretrofit.entities.SingleUserResponse
import net.iessochoa.sergiocontreras.jcretrofit.ui.components.SergioProgressFullScreen
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.JCRetrofitTheme
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.Typography

/**
 * Project: JC Retrofit
 * From: net.iessochoa.sergiocontreras.jcretrofit
 * Created by: Contr
 * On: 29/10/2025 at 15:16
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Preview(showBackground = true)
@Composable
fun UsersPreview() {
    JCRetrofitTheme {
        UsersView(Modifier.padding(top=24.dp), getUsers(),false)
    }
}

@Composable
fun UsersView(
    modifier: Modifier,
    users: List<Data>,
    inProgress: Boolean = false
) {
    Box(modifier) {

        Column(modifier.padding(horizontal = dimensionResource(R.dimen.common_padding_default)),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text (text = stringResource(R.string.users_title),
                style = Typography.headlineSmall
            )

            LazyColumn {
                items(users.size) { index ->
                    val user = users[index]
                    Text(user.getFullName())
                }
            }
        }


        AnimatedVisibility(
            visible = inProgress,
            enter = fadeIn(),
            exit = fadeOut()

        ) {
            SergioProgressFullScreen()
        }

    }

}