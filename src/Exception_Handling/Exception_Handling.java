package Exception_Handling;

//Compile-Time(Checked) Exception:
//These exceptions are checked by the Java compiler at compile time.
//The compiler ensures that the programmer handles these exceptions
//either by using a try-catch block or by declaring them with the throws keyword in the method signature.

//Examples: IOException, SQLException, FileNotFoundException.

//Runtime(Unchecked) Exception:
//These exceptions occur during program execution (runtime) and are not checked by the compiler.
//NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException.


public class Exception_Handling {
    public static void main(String[] args) {
        int i = 2;
        int j = 0;
        String str = null;
        int[] arr = new int[5];

        try{
            j = 10/i;
            System.out.println(str.length());
            System.out.println(arr[5]);

        }
        catch (ArithmeticException e) {
            System.out.println("Divide by Zero Error " + e);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bounds Exception " + e);
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
        catch (Exception e) {
            System.out.println("something went Wrong " +e);
        }

        System.out.println(j);
    }
}
