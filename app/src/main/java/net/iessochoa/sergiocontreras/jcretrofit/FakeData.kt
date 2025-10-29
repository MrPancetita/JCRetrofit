package net.iessochoa.sergiocontreras.jcretrofit

import net.iessochoa.sergiocontreras.jcretrofit.entities.Data
import net.iessochoa.sergiocontreras.jcretrofit.entities.SingleUserResponse
import net.iessochoa.sergiocontreras.jcretrofit.entities.Support

fun getUser() = SingleUserResponse(
    Data(
        1,
        "contreras.engineer@outlook.com",
        "Mr",
        "Pancetita",
        ""
    ),
    Support(
        "https...",
        "descripción..."
    )
)

fun getUsers() = listOf(getUser().data, getUser().data)