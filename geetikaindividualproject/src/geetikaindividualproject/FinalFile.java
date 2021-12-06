package geetikaindividualproject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FinalFile implements FileWriteInt {
	
	private ArrayList<String> content;
	
	@Override
	public void fileWrite( ArrayList<String> orderLog ) {
		
		content = orderLog;
		
	}

	@Override
	public void saveoutput( Path path ) throws IOException {
	
        	FileWriter finalopFile = new FileWriter( path.toString());
//        }else
//        {
//		     finalopFile = new FileWriter( path.getParent().toString() + "/finalop_" + new SimpleDateFormat("yyyyMMddHHmm").format( new Date() ) +  ".csv");
//        }
		for( String line : content )
		
		finalopFile.write( line + "\n" );
		
		finalopFile.close();
		
	}

}
