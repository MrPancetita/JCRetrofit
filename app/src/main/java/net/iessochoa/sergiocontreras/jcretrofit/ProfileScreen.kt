package net.iessochoa.sergiocontreras.jcretrofit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import net.iessochoa.sergiocontreras.jcretrofit.entities.Data
import net.iessochoa.sergiocontreras.jcretrofit.entities.SingleUserResponse
import net.iessochoa.sergiocontreras.jcretrofit.entities.Support
import net.iessochoa.sergiocontreras.jcretrofit.ui.components.SergioCoilImage
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.JCRetrofitTheme
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.Typography

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    JCRetrofitTheme {
        ProfileView(modifier = Modifier.padding(top = 24.dp),
            response = SingleUserResponse(
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
                )))
    }

}
@Composable
fun ProfileView(
    modifier: Modifier,
    response: SingleUserResponse?,
    inProgress: Boolean = false
) {
    Box(modifier) {
        response?.let{
            Column (Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.common_padding_default)),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                //La imagen Coil
                SergioCoilImage(response.data.avatar, R.dimen.img_cover_size)

                Text(
                    text = response.data.getFullName(),
                    modifier = Modifier.padding(vertical = dimensionResource(R.dimen.common_padding_default)),
                    style = Typography.headlineSmall
                )
                Text(
                    text = response.data.email,
                    style = Typography.headlineSmall
                )
                Text(
                    text = response.support.text,
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.common_padding_default)),
                    style = Typography.bodyLarge
                )
                Spacer(
                    Modifier.weight(1f)
                )
                Text(buildAnnotatedString {
                    withLink(LinkAnnotation.Url(
                        url = response.support.url,
                        styles = TextLinkStyles(style = SpanStyle(color = Color.Blue))
                    )) {
                        append(response.support.url)
                    }
                },
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.common_padding_default))
                )
            }
        }
    }

}