package com.nwl.nearby.ui.Components.Button


import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nwl.nearby.R.drawable
import com.nwl.nearby.ui.theme.Typography
import com.rocketseat.nlw.nearby.ui.theme.GreenBase


@Composable
fun NearbyButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    @DrawableRes iconRes: Int? = null,
    onClick: () -> Unit
) {

    Button(
        modifier = modifier.heightIn(min = 56.dp),
        shape = RoundedCornerShape(16.dp),
        contentPadding = if (text == null && iconRes != null) PaddingValues(0.dp)
        else ButtonDefaults.ContentPadding,
        colors = ButtonDefaults.buttonColors(containerColor = GreenBase),
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconRes?.let {
                Icon(painter = painterResource(id = iconRes), contentDescription = "Icone do botão")
            }
            text?.let { Text(text = text.uppercase(), style = Typography.labelLarge) }

        }
    }


}


/*botão com Icon*/
@Preview
@Composable
private fun NearbyButtonPreview() {
    NearbyButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Confirmar",
        iconRes = drawable.ic_scan
    ) {

    }

}

/*botão com  sem texto*/
@Preview
@Composable
private fun NearbyButtonNoText() {
    NearbyButton(
        modifier = Modifier,
        iconRes = drawable.ic_arrow_left
    ) {

    }


}

/*botão  sem Icon*/
@Preview
@Composable
private fun NearbyButtonNoIconPreview() {
    NearbyButton(
        modifier = Modifier,
    ) {

    }
}

