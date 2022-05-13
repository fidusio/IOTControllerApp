package io.xlogistx.iot.controller.app.feature.deviceList.data

import io.xlogistx.iot.controller.app.feature.deviceList.domain.Device

/**
 * @author Ryan Simon
 */
data class ApiDevice(val id: String, val name: String)

fun ApiDevice.toDomainModel(): Device {
  return Device(id, name)
}
