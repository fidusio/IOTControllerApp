package io.xlogistx.iot.controller.app.feature.deviceList.data

import io.xlogistx.iot.controller.app.feature.deviceList.domain.Device
import io.xlogistx.iot.controller.app.feature.deviceList.domain.DeviceRepository

/**
 * @author Ryan Simon
 */
class DeviceRepositoryImpl() : DeviceRepository {

    override suspend fun getDevices(): List<Device> {
        // TODO do the network call

        return listOf()
    }
}