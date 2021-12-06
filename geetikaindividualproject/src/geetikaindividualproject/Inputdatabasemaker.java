package geetikaindividualproject;

import java.util.ArrayList;


public class Inputdatabasemaker {
private StaticDB db = StaticDB.getInstance();
	
	private FileWriteOutput file;
	private FileWriteOutput file2;
	private FileWriteOutput file3;
	public  Inputdatabasemaker ( String filePath,String filePath2,String filePath3 ) {
		
		file = new FileWriteOutput( filePath );
		//file2 is for card
		file2 = new FileWriteOutput(filePath2);
		file3 = new FileWriteOutput(filePath3);
		
	}
	
	public void inputFileScan( ) {
		
		try {
			
			file.readFile( true );
			file2.readFile( true );
			
		} catch (Exception e) {
			
			System.out.println( "Db or card  file not found. Kindly give proper path " );
			System.exit(0);
			
		}
		System.out.println(file.getFileContent(  ));
		
		dbpopulate( file.getFileContent(  ) );
		getCarddetail(file2.getFileContent(  ) );
		
	}
	
	
	private void dbpopulate( ArrayList<String> fileContent ) {
		
		
		for( String line : fileContent ) {
			
			String[] item = line.split(",");
			//System.out.println(item);
      //building database
			db.getDBItems().put(item[1], new Item( item[0], item[1], Double.parseDouble( item[3] ), Integer.parseInt( item[2] ) ) );
			//"Milk",
			//Category,Name,Price,Quantity stock
			
		}  
		
		
	}
	
 private void getCarddetail( ArrayList<String> fileContent ) {
		
		
		for( String line : fileContent ) {
			
			String[] item = line.split(",");
			//System.out.println(item);
      //building database
			db.getCreditCards().add(item[0]);
			
		}  
		
		
	}
}
