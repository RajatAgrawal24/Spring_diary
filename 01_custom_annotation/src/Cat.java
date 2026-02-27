@VeryImportant
public class Cat {
    // Field Annotation
    @ImportantField
    String name;
    int age;

    public Cat(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @RunImmediately
    public void meow(){
        System.out.println("meow");
    }

    public void eat(){
        System.out.println("eat");
    }
}
