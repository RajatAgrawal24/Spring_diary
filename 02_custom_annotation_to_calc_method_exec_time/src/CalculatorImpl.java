public class CalculatorImpl implements Calculator {
    @CalcExecTime
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @CalcExecTime
    @Override
    public int sub(int a, int b) {
        return a-b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }

    @Override
    public int mod(int a, int b) {
        return a%b;
    }
}
