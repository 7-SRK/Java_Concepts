package File_Handling;

import java.io.*;

public class WriteFile {

        public static void main(String[] args)
        {
            try
            {
                FileWriter obj = new FileWriter("FileDemo.txt");
                obj.write("Hello World");
                obj.close();
                System.out.println("File is Updated.");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

