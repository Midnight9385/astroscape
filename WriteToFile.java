import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;
import java.io.*;

public class WriteToFile {
  public static void main(String[] args) {
    Scanner key=new Scanner(System.in);
    WriteToFile run=new WriteToFile();
    run.create("savecodes");
  }
  public void create(String a)
  {
      String filePath=System.getProperty("user.home");
      new File(filePath+"/Astroscape/save").mkdirs();
      filePath+="/Astroscape/save";
      try {
      FileWriter myWriter = new FileWriter(filePath+"\\"+a+".txt");
      myWriter.write("");
      myWriter.close();
    } catch (IOException e) {
      return;
    }
  }
}