package geetikaindividualproject;

public class FileFactory {
  public FileWriteInt getInstance(String str)
  {
	  if(str.equals("Error"))
		  return new ErrorHandler();
	  else 
		  return new FinalFile();
  }
}
