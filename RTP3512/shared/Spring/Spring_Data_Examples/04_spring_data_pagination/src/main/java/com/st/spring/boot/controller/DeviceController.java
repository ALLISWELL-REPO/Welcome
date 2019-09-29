package com.st.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.spring.boot.entity.Device;
import com.st.spring.boot.repository.DeviceRepository;

@RestController
public class DeviceController {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@GetMapping("/devices")
	public Page<Device> getDevices(Pageable pageable) {
		return deviceRepository.findAll(pageable);
	}
	
	
	@GetMapping("/devices/sort")
	public Page<Device> getDevicesSort(Pageable pageable,
			Sort sort) {
		return deviceRepository.findAll(pageable);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
