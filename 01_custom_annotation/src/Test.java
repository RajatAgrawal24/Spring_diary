public class Test {
    public static void main(String[] args){
        Cat cat = new Cat();

        System.out.println(cat.getClass());
        if(cat.getClass().getAnnotatedInterfaces() == VeryImportant.class.getAnnotatedInterfaces()){
            try {
                System.out.println(cat.getClass().getMethod("getName"));
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
