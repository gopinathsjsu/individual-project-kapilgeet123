package geetikaindividualproject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ErrorHandler implements FileWriteInt {
	
	private ArrayList<String> content;
	
	@Override
	public void fileWrite( ArrayList<String> errorMessage ) {
		
		content = errorMessage;
		
	}

	@Override
	public void saveoutput( Path path ) throws IOException {

		FileWriter errorFile = new FileWriter( path.getParent().toString() + "/errorLog_" + new SimpleDateFormat("yyyyMMddHHmm").format( new Date() ) +  ".txt");
		
		for( String line : content )
		
			errorFile.write( line + "\n" );
		
		errorFile.close();
		
	}

}
