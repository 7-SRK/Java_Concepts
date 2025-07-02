package Exception_Handling;

class CustomException extends Exception {
    public CustomException(String string) {
        super(string);
    }
}

public class CustomExceptionHandling {
    public static void main(String[] args) {
        int i = 20;
        int j = 0;

        try {
            j = 10 / i;
            if (j == 0)
                throw new CustomException("No Zero");
        } catch (ArithmeticException e) {
            System.out.println("Divide by Zero Error " + e);
        } catch (CustomException e) {
            System.out.println("something went Wrong " + e);
        }

        System.out.println(j);
    }
}
