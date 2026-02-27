import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunImmediately {
    // Primitive , array, string , class datatype allowed only
    int times() default 2;
}