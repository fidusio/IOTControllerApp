package io.xlogistx.iot.controller.app.feature.deviceList.presentation

import io.xlogistx.iot.controller.app.feature.deviceList.domain.Device

/**
 * @author Ryan Simon
 */
data class DeviceListUiModel(val devices: List<DeviceUiModel>) {

    data class DeviceUiModel(val name: String)
}

fun Device.toUiModel(): DeviceListUiModel.DeviceUiModel {
    return DeviceListUiModel.DeviceUiModel(name)
}
