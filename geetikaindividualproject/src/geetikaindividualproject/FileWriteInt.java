package geetikaindividualproject;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public interface FileWriteInt {
	
	void fileWrite( ArrayList<String> content );
	
	void saveoutput( Path path ) throws IOException;

}
