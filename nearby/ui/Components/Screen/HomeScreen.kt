package com.nwl.nearby.ui.Screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.maps.android.compose.GoogleMap
import com.nwl.nearby.data.model.Mock.mockCategories
import com.nwl.nearby.data.model.Mock.mockMarkets
import com.nwl.nearby.ui.Components.Category.NearbyCategoryFilterChipList
import com.nwl.nearby.ui.Components.Market.NearbyMarketCardList
import com.rocketseat.nlw.nearby.ui.theme.Gray100


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val bootomSheetState = rememberBottomSheetScaffoldState()
    val isBottomSheetOpenend by remember { mutableStateOf(true) }
    val configuration = LocalConfiguration.current

    if (isBottomSheetOpenend) {
        BottomSheetScaffold(
            scaffoldState = bootomSheetState,
            sheetContainerColor = Gray100,
            sheetPeekHeight = configuration.screenHeightDp.dp * 0.5f,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            sheetContent = {
                NearbyMarketCardList(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    markets = mockMarkets,
                    onMarketClick = {}
                )
            },
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {

                    GoogleMap(modifier = Modifier.fillMaxSize())

                    NearbyCategoryFilterChipList(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp)
                            .align(Alignment.TopStart),
                        categories = mockCategories,
                        onSelectedCategoryChange = {}
                    )
                }

            }

        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}