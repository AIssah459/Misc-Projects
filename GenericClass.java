public class GenericClass<Type1, Type2> {
    Type1 one;
    Type2 two;
    GenericClass(Type1 one, Type2 two) {
        this.one = one;
        this.two = two;
    }
    public static void main(String[] args) {
        GenericClass<String, Integer> gc = new GenericClass<String, Integer>("Hello world", 30);
        GenericClass<String, String> gc2 = new GenericClass<String,String>("String1", "String2");
        System.out.println(gc.one);
        System.out.println(gc.two);
        System.out.println();
        System.out.println(gc2.one);
        System.out.println(gc2.two);
    }
}
