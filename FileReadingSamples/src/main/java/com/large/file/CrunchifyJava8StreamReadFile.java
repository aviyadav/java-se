package com.large.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CrunchifyJava8StreamReadFile {

	public static void main(String[] args) {
		String fileName = "C:\\Users\\Q845332\\codebase\\data\\naaccr-files\\NAACCR-RANDOM-1000.dat";
		
		crunchifyReadFile1(fileName);
		crunchifyReadFile2(fileName);
	}

	private static void crunchifyReadFile1(String cFile) {
		
		Stream<String> cFileStream = null;
		
		try {
			cFileStream = Files.lines(Paths.get(cFile));
		} catch (IOException e) {
			Logger.getLogger(CrunchifyJava8StreamReadFile.class.getName()).log(Level.SEVERE, null, e);
		}
		
		cFileStream.forEach(System.out::println);
		Logger.getLogger(CrunchifyJava8StreamReadFile.class.getName()).log(Level.INFO, "Result from lines and Stream Approach");
	}

	private static void crunchifyReadFile2(String cFile) {
		List<String> cFileList = new ArrayList<>();
		BufferedReader cBufferedReader = null;
		
		try {
			cBufferedReader = Files.newBufferedReader(Paths.get(cFile));
		} catch (IOException e) {
			Logger.getLogger(CrunchifyJava8StreamReadFile.class.getName()).log(Level.SEVERE, null, e);
		}
		
		cFileList = cBufferedReader.lines().collect(Collectors.toList());
		
		cFileList.forEach(System.out::println);
		Logger.getLogger(CrunchifyJava8StreamReadFile.class.getName()).log(Level.INFO, "Result from newBufferedReader and Stream Approach");
	}
}
