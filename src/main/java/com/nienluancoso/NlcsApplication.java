package com.nienluancoso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.nienluancoso.entity.RoleEntity;
import com.nienluancoso.repository.RoleRepository;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class NlcsApplication implements ApplicationRunner {
    @Autowired
    RoleRepository roleRepo;

    public static void main(String[] args) {
        SpringApplication.run(NlcsApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        init(); // Gọi init() ở đây để chạy một lần khi ứng dụng bắt đầu
        scheduleInitTask(); // Lập lịch cho việc thực hiện init() mỗi giây
    	//createRole();
    }

    public void init() {
//        RoleEntity role = roleRepo.findById(1L).orElse(null);
//        if (role == null) {
//            roleRepo.save(new RoleEntity(1L, "teacher"));
//        }
//
//        role = roleRepo.findById(2L).orElse(null);
//        if (role == null) {
//            roleRepo.save(new RoleEntity(2L, "student"));
//        }
	
	    // Prepare URL for the self-call
	    String selfCallUrl = "https://exam-vavn.onrender.com/keep-alive";
	
	    // Send HTTP GET request to itself
	    RestTemplate restTemplate = new RestTemplate();
	    String response = restTemplate.getForObject(selfCallUrl, String.class);
	    
    }

    private void scheduleInitTask() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Lập lịch thực hiện init() mỗi giây
        scheduler.scheduleAtFixedRate(this::init, 0, 300, TimeUnit.SECONDS);
    }

    public void createRole() {
		RoleEntity teacherRole = new RoleEntity();
		RoleEntity studentRole = new RoleEntity();
		teacherRole.setId(1L);
		teacherRole.setName("teacher");
		studentRole.setId(2L);
		studentRole.setName("student");
		roleRepo.save(teacherRole);
		roleRepo.save(studentRole);
	}

}
