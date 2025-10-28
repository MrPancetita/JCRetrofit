package net.iessochoa.sergiocontreras.jcretrofit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.jcretrofit.entities.UserInfo
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
            onClick = {_,_-> }
        )
    }
}

@Composable
fun MainView(
    modifier: Modifier,
    inProgres: Boolean = false,
    onGoUsers: () -> Unit,
    onClick: (UserInfo, Boolean) -> Unit)
{
    var emailValue by remember { mutableStateOf("eve.holt@reqres.in") }
    var passwordValue by remember { mutableStateOf("cityslicka")}
    var isLogin by remember { mutableStateOf(true) }

    Box(modifier = modifier) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = stringResource(R.string.main_login_title),
                style = Typography.headlineSmall
            )

            OutlinedTextField(
                value = emailValue,
                onValueChange = { emailValue = it },
                modifier = Modifier
                    .padding(top = dimensionResource(R.dimen.common_padding_min)),
                label = { Text (text = stringResource(R.string.main_hint_email))}
            )

            OutlinedTextField(
                value = passwordValue,
                onValueChange = { passwordValue = it },
                modifier = Modifier
                    .padding(top = dimensionResource(R.dimen.common_padding_min)),
                label = { Text (text = stringResource(R.string.main_hint_password))}
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.common_padding_min)),
                modifier = Modifier.padding(
                    vertical = dimensionResource(R.dimen.common_padding_default),
                )

            ) {
                Text(text = if(isLogin) stringResource(R.string.main_switch_login) else stringResource(
                    R.string.main_switch_register
                ))
                Switch(checked = isLogin,
                    onCheckedChange = {isLogin = it},
                    thumbContent = {
                        Icon(
                            imageVector = Icons.Default.Repeat,
                            contentDescription = null,
                            modifier = Modifier.size(SwitchDefaults.IconSize))
                    })
            }



            Button(
                onClick = { onClick(
                    UserInfo(emailValue, passwordValue), isLogin
                ) }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Login,
                    contentDescription = null,
                    modifier = Modifier.padding(end = dimensionResource(R.dimen.common_padding_min))
                )
                Text(text = stringResource(R.string.main_btn_login))
            }


        }


    }



}