package com.redbite.test.services;

import com.redbite.test.controller.DevicesController;
import com.redbite.test.entity.UserDevice;
import com.redbite.test.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevicesServices {

    private DeviceRepository deviceRepository;

    public DevicesServices(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


    public List<UserDevice> getAllDevices() {
        List<UserDevice> allDevices = deviceRepository.findAll();
        return allDevices;
    }

    public UserDevice getDevice(String serial) {
        return deviceRepository.findBySerial(serial);
    }

    public String createDevice(UserDevice device) {
    deviceRepository.save(device);
    return "created";
    }

    public String updateDevice(String serial, UserDevice device) {
        UserDevice userDevice = deviceRepository.findBySerial(serial);
        userDevice.setName(device.getName());
        userDevice.setDescription(device.getDescription());
        deviceRepository.save(userDevice);
        return "updated";
    }

    public String deleteDevice(String serial) {
        UserDevice userDevice = deviceRepository.findBySerial(serial);
        deviceRepository.delete(userDevice);
        return "deleted";
    }
}
