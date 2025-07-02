package File_Handling;

import java.io.*;

public class CreateFile {
        public static void main(String[] args)
        {
            try
            {
                File Obj = new File("FileDemo.txt");
                if (Obj.createNewFile())	{
                    System.out.println("******File created******");
                    System.out.println("Name of the file = " + Obj.getName());
                }
                else{
                    System.out.println("File already exists.");
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

