package com.redbite.test.repository;

import com.redbite.test.entity.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<UserDevice, String>, JpaSpecificationExecutor<UserDevice> {
    UserDevice findBySerial(String serial);
}
