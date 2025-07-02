package File_Handling;

import java.io.*;

public class Fileio {
    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter("FileDemo.txt"));
//        bw.write("Hello\n");
//        bw.write("World\n");
        BufferedWriter bw = new BufferedWriter(new FileWriter("FileDemo1.txt"));
        BufferedReader br = new BufferedReader(new FileReader("FileDemo.txt"));
        String s;
        while((s = br.readLine()) != null){
            bw.write(s +"\n");
        }
        br.close();
        bw.close();
    }
}
