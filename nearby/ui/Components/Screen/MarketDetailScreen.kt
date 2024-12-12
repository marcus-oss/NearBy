package com.nwl.nearby.ui.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.nwl.nearby.R
import com.nwl.nearby.data.model.Market
import com.nwl.nearby.data.model.Mock.mockMarkets
import com.nwl.nearby.ui.Components.Button.NearbyButton
import com.nwl.nearby.ui.Components.market_Details.NearByMarketdetailsInfos
import com.nwl.nearby.ui.Components.market_Details.NearbyMarketDetailsCoupons
import com.nwl.nearby.ui.Components.market_Details.NearbyMarketDetailsRules
import com.nwl.nearby.ui.theme.Typography

@Composable
fun MarketDetailScreen(
    modifier: Modifier = Modifier,
    market: Market,
    onNavigationBack: () -> Unit
) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            contentDescription = "Imagem do Local",
            contentScale = ContentScale.Crop,
            model = market.cover
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(36.dp)
            ) {
                Column {
                    Text(text = market.name, style = Typography.headlineLarge)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = market.description, style = Typography.bodyLarge)
                }
                Spacer(modifier = Modifier.height(48.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())

                ) {
                    NearByMarketdetailsInfos(market = market)
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                    )

//                    if (market.rules.isNotEmpty()) {
//                        NearbyMarketDetailsRules(rules = market.rules)
//                        HorizontalDivider(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 24.dp)
//                        )

                }
                NearbyMarketDetailsCoupons(coupons = listOf("ABC12345"))
            }

            NearbyButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                text = "Ler o qrCode",
                onClick = {}
            )


        }

        NearbyButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(24.dp),
            iconRes = R.drawable.ic_arrow_left,
            onClick = onNavigationBack
        )
    }
}


@Preview
@Composable
private fun MarketDetailsScreenPreview() {
    MarketDetailScreen(market = mockMarkets.first(), onNavigationBack = {})
}
