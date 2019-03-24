package com.tests;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;

public class HelperClass {

	public void emptyDir(String filePath) throws Exception {
		try {
			Path sourceFilepath = Paths.get(filePath);
			Files.walk(sourceFilepath).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
		} catch (NoSuchFileException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createDir(String filePath) throws Exception {
		File f = new File(filePath);
		if (!f.exists() && !f.isDirectory()) {
			f.mkdir();
		}
	}

	public void TransferFileToScriptDir(String filePath, String fileName) throws Exception {
		Path sourceFilepath = Paths.get(filePath, fileName);
		Path destFilepath = Paths.get("./script/", fileName);

		List<String> list = Files.readAllLines(sourceFilepath);
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				Files.write(destFilepath, list.get(i).getBytes(), StandardOpenOption.CREATE_NEW);
			} else {
				Files.write(destFilepath, list.get(i).getBytes(), StandardOpenOption.APPEND);
			}
			Files.write(destFilepath, "\n".getBytes(), StandardOpenOption.APPEND);
		}
	}

}
