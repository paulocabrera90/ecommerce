package com.infosl.ecommerce.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {
	
	private String folder = "images//"; //ubicacion del proyecto donde voy a cargar las imagenes
	
	public String saveImage(MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			byte [] bytesImg =	file.getBytes();
			Path path = Paths.get(folder+ file.getOriginalFilename());
			Files.write(path, bytesImg);
			return file.getOriginalFilename();
		}
		return "";
	}
}
