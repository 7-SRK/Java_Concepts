package Exception_Handling;


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
