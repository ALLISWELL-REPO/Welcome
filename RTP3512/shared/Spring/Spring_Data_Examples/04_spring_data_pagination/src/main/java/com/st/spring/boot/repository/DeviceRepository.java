package com.st.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.st.spring.boot.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
	
	List<Device> findByModel(String model);
	
	List<Device> findByModelAndManufacturer(String model, String manufacturer);
	
	List<Device> findByUserLastName(String lastName);
	
	List<Device> findByModelContaining(String model);
	
	@Query("SELECT d FROM Device d WHERE d.model = :MODEL")
	List<Device> queryDevicesByModelName(@Param("MODEL") String model);

}
