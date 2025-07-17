package Java21_Packages.Java.Lang_Core_Language_Utilities;

public class SystemUtils {
    public static void main(String[] args) {

        System.out.println("Java Version: " + System.getProperty("java.version")); //
        System.out.println("Operating System: " + System.getProperty("os.name")); //

        System.out.println("Path environment variable: " + System.getenv("PATH")); //

        long startTime = System.currentTimeMillis();
        System.out.println("Start Time (milliseconds): " + startTime);

        // Running garbage collector
        System.gc();

        System.exit(0); // Terminates the JVM
    }
}
