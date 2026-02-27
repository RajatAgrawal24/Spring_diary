import java.lang.reflect.Method;

public class App {
    @CalcExecTime()
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new CalculatorImpl();

        for(Method m : calc.getClass().getDeclaredMethods()){
            try{
                if(m.isAnnotationPresent(CalcExecTime.class)){
                    long st = System.nanoTime();
                    int res = (int) m.invoke(calc, 8, 4);
                    long et = System.nanoTime();
                    long execTime = et - st;
                    System.out.println(res);
                    System.out.println("Exec time of " + m.getName() + " is : " + execTime + "nanoseconds");
                }else{
                    System.out.println(m.invoke(calc, 8, 4));
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
