package MathOperation;

public class MathOperation {

    public MathOperation() {

    }

    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int add(int num1, int num2, int num3) {
        return add(num1, num2) + num3;
    }

    public static int add(int num1, int num2, int num3, int num4) {
        return add(num1, num2, num3) + num4;
    }
}
