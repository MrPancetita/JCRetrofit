package net.iessochoa.sergiocontreras.jcretrofit.entities

import com.google.gson.annotations.SerializedName

/**
 * Project: JC Retrofit
 * From: net.iessochoa.sergiocontreras.jcretrofit.entities
 * Created by: Contr
 * On: 25/10/2025 at 22:48
 * Creado en Settings -> Editor -> File and Code Templates
 */


class UserInfo(
    @SerializedName("email") val email: String,
    @SerializedName("password") val pass: String
)