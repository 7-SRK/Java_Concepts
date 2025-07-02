package Java_8;

//A lambda expression is a short block of code which takes in parameters and returns a value.
// Lambda expressions are similar to methods, but they do not need a name and
// they can be implemented right in the body of a method. and Works only with Functional Interface.
//Syntax: (param) -> expression


@FunctionalInterface
//interface B
//{
//    void show(int i);
//}

interface Add
{
    int add(int i,int j);
}

public class LambdaExpression {
    public static void main(String[] args) {
//            B obj =(i) -> System.out.println("Show " +i);
//            obj.show(5);

        Add obj =(i,j) ->i+j;
        int res = obj.add(5,5);
        System.out.println(res);
        }
    }

