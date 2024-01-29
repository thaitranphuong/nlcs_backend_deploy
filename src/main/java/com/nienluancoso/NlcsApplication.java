package com.nienluancoso;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NlcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NlcsApplication.class, args);
		Timer timer = new Timer();
        timer.scheduleAtFixedRate(new PrintHelloTask(), 0, 10000); // Schedule the task to run every 5 seconds
	}

	static class PrintHelloTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("hello");
        }
    }
}
