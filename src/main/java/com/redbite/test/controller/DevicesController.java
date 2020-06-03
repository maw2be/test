package com.redbite.test.controller;

import com.redbite.test.entity.UserDevice;
import com.redbite.test.services.DevicesServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class DevicesController {

    private DevicesServices devicesServices;

    public DevicesController(DevicesServices devicesServices) {
        this.devicesServices = devicesServices;
    }

    /**
     * Get all devices
     *
     * method: GET
     * request: "/"
     *
     * respond:
     * [
     *  {
     *      "serial" : STRING,
     *      "name" : STRING,
     *      "description" : STRING
     *  }
     * ]
     *
     */

    @GetMapping(produces = "application/json")
    public List<UserDevice> getAllDevices(){
        return devicesServices.getAllDevices();
    }

    /**
     * Get device details by serial number
     *
     * method: GET
     * request: "/a123"
     *
     * respond:
     *  {
     *      "serial" : STRING,
     *      "name" : STRING,
     *      "description" : STRING
     *  }
     *
     */



    @GetMapping(value = "/{serial}", produces = "application/json")
    public UserDevice getDevices(@PathVariable String serial){
        return devicesServices.getDevice(serial);
    }



    /**
     * Create new device
     *
     * method: POST
     * request: "/"
     * headers: "Content-Type:application/json"
     * body:
     *      {
     *          "serial" : STRING,
     *          "name" : STRING,
     *          "description" : STRING
     *      }
     *
     * respond:
     *  Created
     *
     */


    @PostMapping(consumes = "application/json")
    public String createDevice(@RequestBody UserDevice device){
    return devicesServices.createDevice(device);
    }

    /**
     * Update device by serial number
     *
     * method: PUT
     * request: "/a123"
     * headers: "Content-Type:application/json"
     * body:
     *      {
     *          "serial" : STRING,
     *          "name" : STRING,
     *          "description" : STRING
     *      }
     *
     * respond:
     *  Updated
     *
     */



    @PutMapping(value = "/{serial}", consumes = "application/json")
    public String updateDevice(@PathVariable String serial, @RequestBody UserDevice device){
return devicesServices.updateDevice(serial, device);
    }


    /**
     * Delete device by serial number
     *
     * method: DELETE
     * request: "/a123"
     *
     * respond:
     *  Deleted
     *
     */

    @DeleteMapping(value = "/{serial}")
    public String deleteDevice(@PathVariable String serial){
return devicesServices.deleteDevice(serial);
    }

}
