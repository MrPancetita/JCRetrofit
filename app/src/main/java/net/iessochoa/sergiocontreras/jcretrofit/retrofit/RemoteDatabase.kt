package net.iessochoa.sergiocontreras.jcretrofit.retrofit

import net.iessochoa.sergiocontreras.jcretrofit.entities.UserInfo

/**
 * Project: JC Retrofit
 * From: net.iessochoa.sergiocontreras.jcretrofit.retrofit
 * Created by: Contr
 * On: 25/10/2025 at 22:51
 * Creado en Settings -> Editor -> File and Code Templates
 */
class RemoteDatabase {

    fun login(
        user: UserInfo,
        onLogin: () -> Unit,
        onError: (String) -> Unit
    ) {
        if(user.email.contains("@")) {
            onLogin()
        } else {
            onError(":(")
        }
    }
}