package net.iessochoa.sergiocontreras.jcretrofit.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import net.iessochoa.sergiocontreras.jcretrofit.R

/**
 * Project: JC Retrofit
 * From: net.iessochoa.sergiocontreras.jcretrofit.ui.components
 * Created by: Contr
 * On: 29/10/2025 at 13:51
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun SergioCoilImage(url: String, sizeRes: Int) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = null,
        placeholder = rememberVectorPainter(Icons.Default.Timer),
        error = rememberVectorPainter(Icons.Default.BrokenImage),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(dimensionResource(sizeRes))
            .clip(CircleShape)
    )
}
