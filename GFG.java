// Java Program to illustrate Reading from FileReader
// using BufferedReader Class
 
// Importing input output classes
import java.io.*;
import java.util.Scanner;
 
// Main class
public class GFG {
 
    // main driver method
    public static void main(String[] args) throws Exception
    {   
        
    }
    public String run(BufferedReader u, BufferedReader v,String t)
    {
      
      // File path is passed as parameter
                //Scanner key = new Scanner(System.in);
                int k=0;
                int h=0;
                        // Declaring a string variable
        String st;

        try{
                u.mark(50);
        v.mark(50);
        while ((st = u.readLine()) != null)
          {
               k++;
          }
          } catch (IOException e) {
        }

      
      try{
        while ((st = v.readLine()) != null)
          {
               h++;
          } 
        } catch (IOException e) {
        System.out.print("something went wrong");
        return "";
      }
         if(h>k)
         {
            k=h;
         }
         
         String[][] logins = new String[2][k];
        

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BuffferedReader class

 

        // Consition holds true till
        // there is character in a string
        int sa=0;
        try{
                 u.reset();
         v.reset();
        while ((st = u.readLine()) != null)
          {
               logins[0][sa]=st;
               sa++;
          }
          } catch (IOException e) {
        sa=0;
        }
        sa=0;
      try{
        while ((st = v.readLine()) != null)
          {
               logins[1][sa]=st;
               sa++;
          } 
        } catch (IOException e) {
        System.out.println("uh oh");
      }
         int z=0;  
          st=login(logins,t);
          if(st.equals(""))
          {
            return "";
          }
          for(int y=0;y<logins[0].length;y++)
          {
               if(st.equals(logins[0][y]))
               {
                  z=y;
                  break;
               }
          }
          return logins[1][z];
    }
    public String login(String[][] a,String t)
    {
         if(check(t,a)==true)
         {
            return t;
         }  
         else
         {
            return "";
         }
      }
      
    public boolean check(String u, String[][] logins)
    {

         for(int m=0;m<logins[0].length;m++)
          {
            if(u.equals(logins[0][m]))
            {
               return true;
            }
          } 
          return false; 
    }
 }   

