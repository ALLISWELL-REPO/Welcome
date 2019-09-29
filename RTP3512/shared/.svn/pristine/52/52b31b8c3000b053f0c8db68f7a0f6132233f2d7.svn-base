package com.st.spring.boot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.st.spring.boot.entity.Device;
import com.st.spring.boot.entity.User;
import com.st.spring.boot.repository.DeviceRepository;
import com.st.spring.boot.repository.UserRepository;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		DeviceRepository deviceRepository = context.getBean(DeviceRepository.class);
		
		// save entities
		
		User user = buildUser();
		userRepository.save(user);
		
		Device device = deviceRepository.save(buildDevice(user));
		deviceRepository.setDeviceModel(device.getId(), "iPhone 99");
		
		// find entity by id
		/*Device device = deviceRepository.findOne(1L);
		System.out.println(device);*/
		
		// derived queries
		List<Device> devices = 
				deviceRepository.findByModel("iPhone 7");
		System.out.println(devices);
		
		/*List<Device> devices = deviceRepository.findByModelAndManufacturer("iPhone 7", "Apple");
		System.out.println(devices);*/
		
		/*List<Device> devices = deviceRepository.findByModelContaining("iPhone");
		System.out.println(devices);*/
		
		/*List<Device> devices = deviceRepository.findByModelContainingOrderByModelAsc("iPhone");
		System.out.println("---------------");
		devices.stream().forEach(device -> System.out.println(device.getModel()));
		System.out.println("---------------");*/
		
		/*List<Device> devices = deviceRepository.findByModelContainingOrderByModelDesc("iPhone");
		System.out.println("---------------");
		devices.stream().forEach(device -> System.out.println(device.getModel()));
		System.out.println("---------------");*/
		
		/*List<Device> devices = deviceRepository.findByUserLastNameOrderByModelAscManufacturerAsc("lname_1");
		System.out.println("---------------");
		devices.stream().forEach(device -> System.out.println(device.getModel() + "       " + device.getManufacturer()));
		System.out.println("---------------");*/
		
		/*List<Device> devices = deviceRepository.queryDevicesByModelName("iPhone 7");
		System.out.println(devices);*/
		
	}
	
	private static User buildUser() {
		User user = new User();
		user.setFirstName("fname_99");
		user.setLastName("lname_99");
		return user;
	}
	
	private static Device buildDevice(User user) {
		Device device = new Device();
		device.setUuid("uuid-99");
		device.setModel("iPhone 7");
		device.setManufacturer("Apple");
		device.setDeviceOS("iOS");
		device.setUser(user);
		return device;
		
	}
}
