package com.example.springBoot.api.download;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class FileDownloadUtil {
	
	private Path foundFile;
	
	public Resource getFileAsResoure(String fileCode) throws IOException {
		Path uploadDirector = Paths.get("File-Upload");
		
		Files.list(uploadDirector).forEach(file ->{
			if(file.getFileName().toString().startsWith(fileCode)) {
				foundFile = file;
				return;
			}
		});
		if(foundFile != null) {
			return new UrlResource(foundFile.toUri());
		}
		return null;
		
	}

}
