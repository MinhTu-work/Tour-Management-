package com.easy.tour.Tour_View;

import com.easy.tour.Tour_View.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;

import static com.easy.tour.Tour_View.service.Impl.FilesStorageServiceImpl.root;

@SpringBootApplication
public class TourViewApplication implements CommandLineRunner  {

	@Autowired
	private FilesStorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(TourViewApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		root = storageService.getUploadPath();
		try {
			Files.createDirectories(root);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}
}
