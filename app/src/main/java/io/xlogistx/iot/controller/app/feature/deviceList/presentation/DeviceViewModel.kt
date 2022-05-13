package io.xlogistx.iot.controller.app.feature.deviceList.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.xlogistx.iot.controller.app.feature.deviceList.domain.DeviceRepository
import kotlinx.coroutines.launch

/**
 * @author Ryan Simon
 */
class DeviceViewModel(val deviceRepository: DeviceRepository) : ViewModel() {

    private val _deviceScreenState = MutableLiveData<DeviceScreenState>()
    val deviceScreenState: LiveData<DeviceScreenState>
        get() = _deviceScreenState

    fun onDeviceLoadRequested() {
        viewModelScope.launch {
            deviceRepository.getDevices()
            _deviceScreenState.value = DeviceScreenState.Loaded(deviceRepository.getDevices().map {
                it.toUiModel()
            }
            )
        }
    }

    sealed class DeviceScreenState {
        object Idle : DeviceScreenState()
        object Loading : DeviceScreenState()
        object Error : DeviceScreenState()
        object Empty : DeviceScreenState()
        data class Loaded(val devices: List<DeviceListUiModel.DeviceUiModel>) : DeviceScreenState()
    }
}