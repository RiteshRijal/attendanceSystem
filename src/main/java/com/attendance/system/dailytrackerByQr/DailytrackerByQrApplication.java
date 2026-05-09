package com.attendance.system.dailytrackerByQr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class DailytrackerByQrApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DailytrackerByQrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String url = "http://localhost:8080";

		if (Desktop.isDesktopSupported()) {
			Desktop.getDesktop().browse(new URI(url));
		}
	}
}