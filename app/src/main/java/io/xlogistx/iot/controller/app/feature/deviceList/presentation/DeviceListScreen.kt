package io.xlogistx.iot.controller.app.feature.deviceList.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.xlogistx.iot.controller.app.theme.ThemedPreview

/**
 * @author Ryan Simon
 */
@Composable
fun DeviceListScreen(viewModel: DeviceViewModel) {
    val state = viewModel.deviceScreenState.observeAsState(
        initial = DeviceViewModel.DeviceScreenState.Idle
    )

    DeviceListContent(state = state.value)
}

@Composable
private fun DeviceListContent(state: DeviceViewModel.DeviceScreenState) {
    when (state) {
        DeviceViewModel.DeviceScreenState.Empty -> TODO()
        DeviceViewModel.DeviceScreenState.Error -> TODO()
        DeviceViewModel.DeviceScreenState.Idle -> {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Text("Header")
                }

                items(items = sampleContent.devices) {
                    DeviceListItem(it)
                }
            }
        }
        is DeviceViewModel.DeviceScreenState.Loaded -> TODO()
        DeviceViewModel.DeviceScreenState.Loading -> TODO()
    }
}

@Composable
private fun DeviceListItem(device: DeviceListUiModel.DeviceUiModel) {
    Text(text = device.name)
}

private val sampleContent = DeviceListUiModel(devices = listOf(
    DeviceListUiModel.DeviceUiModel(
        name = "Device 1"
    ),
    DeviceListUiModel.DeviceUiModel(
        name = "Device 2"
    ),
    DeviceListUiModel.DeviceUiModel(
        name = "Device 3"
    )
))

@Preview
@Composable
fun DeviceListScreenPreview() {
    ThemedPreview {
        DeviceListContent(state = DeviceViewModel.DeviceScreenState.Idle)
    }
}