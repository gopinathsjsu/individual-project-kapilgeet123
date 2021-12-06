package geetikaindividualproject;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileWriteOutput  {

	Path path;
	
	FileWriteInt opFile;
	
	
	private ArrayList<String> fileContent = new ArrayList<>();

	public FileWriteOutput( String filePath ) {
		
		this.path = Paths.get( filePath );

	}

	public void readFile( boolean ignoreFirstLine  ) throws IOException {
		System.out.println("path"+path);
		if ( Files.notExists(path) ) {
			System.out.println("Hi1");
			new IOException();
			 
        }
		 System.out.println("Hi");
		BufferedReader bufferedReader = new BufferedReader( new FileReader( path.toFile() ) );

		String line = "";

		while ( ( line = bufferedReader.readLine() ) != null ) {
			
			if( ignoreFirstLine ) { ignoreFirstLine = false; continue; }

			fileContent.add( line );

		}
		
	}
	
	public ArrayList<String> getFileContent() {
		
		return fileContent;
		
	}
	
	public void outputfilewrite( ArrayList<String> message, boolean isError ) throws IOException {
		

		FileFactory ff = new FileFactory();
		if( isError ) {
		
		opFile = ff.getInstance("Error");
		
	} else {
		
		opFile = ff.getInstance("Outputfile");
		
	}
		
		opFile.fileWrite(message); 
		
		opFile.saveoutput(path);
		
	}
	
}