package net.iessochoa.sergiocontreras.jcretrofit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.jcretrofit.entities.Data
import net.iessochoa.sergiocontreras.jcretrofit.ui.components.SergioCoilImage
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.JCRetrofitTheme
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.Typography

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    JCRetrofitTheme {
        ItemUserView(getUser().data)
    }
}

@Composable
fun ItemUserView(user: Data) {
    Box (
        contentAlignment = Alignment.BottomCenter
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.common_padding_min)),
            verticalAlignment = Alignment.CenterVertically
        ){
            SergioCoilImage(
                url = user.avatar,
                sizeRes = R.dimen.img_list_size)
            Text(user.getFullName(),
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.common_padding_min)),
                style = Typography.titleLarge
            )
        }

        HorizontalDivider()
    }

}