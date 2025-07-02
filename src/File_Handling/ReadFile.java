package File_Handling;

import java.io.*;
import java.util.*;

public class ReadFile {
    public static void main(String[] args)
        {
            File a = new File("FileDemo.txt");

            boolean b = a.exists();
            if (b == true) {
                System.out.println("Executable: " + a.canExecute());
                System.out.println("Readable: " + a.canRead());
                System.out.println("Writable: " + a.canWrite());
            } else {
                System.out.println("File not found.");
            }
            try
            {
                File Obj = new File("FileDemo.txt");
                Scanner obj1 = new Scanner(Obj);
                while (obj1.hasNextLine())
                {
                    String obj2 = obj1.nextLine();
                    System.out.println(obj2);
                }
                obj1.close();
            }catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }

