package com.nwl.nearby.ui.Components.Welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nwl.nearby.R
import com.nwl.nearby.ui.theme.Typography

@Composable
fun WelcomeContent(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    )
    {
        Text(
            text = "Veja como funciona: ",
            style = Typography.bodyLarge
        )

        WelcomeMonitWorksTip(
            modifier = Modifier.fillMaxWidth(),
            title = "Encontre estabelecimentos",
            subtitle = "Veja locais perto de você que são parceiros NearBy",
            iconRes = R.drawable.ic_map_pin
        )

        WelcomeMonitWorksTip(
            modifier = Modifier.fillMaxWidth(),
            title = "Ative com o QrCode",
            subtitle = "Escaneie o codsigo no estabelecimento para usar o beneficio",
            iconRes = R.drawable.ic_qrcode
        )

        WelcomeMonitWorksTip(
            modifier = Modifier.fillMaxWidth(),
            title = "Garanta a vantagem perto de você",
            subtitle = "Ative cupons onde estiver, em diferentes tipo de estebelecimento",
            iconRes = R.drawable.ic_ticket
        )


    }
}