import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args){
        Cat cat = new Cat("Oggy");

        System.out.println(cat.getClass());
        if(cat.getClass().isAnnotationPresent(VeryImportant.class)){
            try {
                System.out.println(cat.getClass().getMethod("getName"));
                System.out.println("This is important Cat!!!!!");
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("This is NOT important Cat!!!!!");
        }

        for(Method method : cat.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){
                try{
                    RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                    for(int i=0;i<annotation.times();i++){
                        method.invoke(cat);
                    }
                } catch (InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        for(Field field : cat.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(ImportantField.class)){
                try{
                    Object value = field.get(cat);
                    System.out.println(value);
                }catch (IllegalAccessException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
