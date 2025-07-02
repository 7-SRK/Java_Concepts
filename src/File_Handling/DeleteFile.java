package File_Handling;

import java.io.*;

public class DeleteFile {

        public static void main(String[] args) {
            File Obj = new File("FileDemo.txt");
            if (Obj.delete()) {
                System.out.println(Obj.getName() + " has been deleted");
            } else {
                System.out.println("Failed");
            }
        }
    }

