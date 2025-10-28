package net.iessochoa.sergiocontreras.jcretrofit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.jcretrofit.R
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.JCRetrofitTheme

@Preview(showBackground = true)
@Composable
private fun SergioProgressFullScreenPreview() {
    JCRetrofitTheme {
        SergioProgressFullScreen()
    }
}


@Composable
fun SergioProgressFullScreen() {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.progress_background))
            .clickable(interactionSource = null, indication = null) {

            },
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()

    }
}