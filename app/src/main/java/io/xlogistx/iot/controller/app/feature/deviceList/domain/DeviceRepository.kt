package io.xlogistx.iot.controller.app.feature.deviceList.domain

/**
 * @author Ryan Simon
 */
interface DeviceRepository {
    suspend fun getDevices(): List<Device>
}
