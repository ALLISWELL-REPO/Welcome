package com.st.spring.boot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.st.spring.boot.entity.Device;

@Repository
public interface DeviceRepository 
		extends JpaRepository<Device, Long> {
	
	List<Device> findByModel(String model);
	
	List<Device> findByModelAndManufacturer(String model, String manufacturer);
	
	List<Device> findByUserLastName(String lastName);
	
	List<Device> findByModelContaining(String model);
	
	List<Device> findByModelContainingOrderByModelAsc(String model);
	
	List<Device> findByModelContainingOrderByModelDesc(String model);
	
	List<Device> findByUserLastNameOrderByModelAscManufacturerAsc(String lastName);
	
	@Query("SELECT d FROM Device d WHERE d.model = :MODEL")
	List<Device> queryDevicesByModelName(@Param("MODEL") String model);

	@Transactional
	@Modifying
	@Query("UPDATE Device d SET d.model = :MODEL WHERE d.id = :ID")
	void setDeviceModel(@Param("ID") Long deviceId, @Param("MODEL") String model);

	
	
	
	
	
	
	
	
}
