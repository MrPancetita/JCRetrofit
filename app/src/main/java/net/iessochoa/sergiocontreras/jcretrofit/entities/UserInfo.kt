package net.iessochoa.sergiocontreras.jcretrofit.entities

import com.google.gson.annotations.SerializedName
import net.iessochoa.sergiocontreras.jcretrofit.retrofit.Constants

/**
 * Project: JC Retrofit
 * From: net.iessochoa.sergiocontreras.jcretrofit.entities
 * Created by: Contr
 * On: 25/10/2025 at 22:48
 * Creado en Settings -> Editor -> File and Code Templates
 */


class UserInfo(
    @SerializedName(Constants.EMAIL_PARAM) val email: String,
    @SerializedName(Constants.PASSWORD_PARAM) val pass: String
)