//public class Test {
//
//    public static void main(String [] args){


//class Parent {
//    int x = 10;
//
//    Parent() {
//        System.out.println("Parent Constructor");
//        show();
//    }
//
//    void show() {
//        System.out.println("Parent Show: " + x);
//    }
//}
//
//class Child extends Parent {
//    int x = 20;
//
//    Child() {
//        System.out.println("Child Constructor");
//        System.out.println("Child Show: " + x);
//    }
//
//    @Override
//    void show() {
//        System.out.println("Child Show: " + x);
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        Parent obj = new Child();
//    }
//}


//class A {
//    A() {
//        System.out.println("A's Constructor");
//    }
//}
//
//class B extends A {
//    B() {
//        System.out.println("B's Constructor");
//    }
//}
//
//class C extends B {
//    C() {
//        System.out.println("C's Constructor");
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        C obj = new C();
//    }
//}
//
//
//        mport java.util.*;
//        public class Main {
//            public static void main(String[] args) {
//                List<String> list = new ArrayList<>();
//                list.add("Apple");
//                list.add("Banana");
//                list.add("Apple");
//                list.add("Orange");
//                Set<String> set = new HashSet<>(list);
//                System.out.println("List: " + list);
//                System.out.println("Set: " + set);
//            }
//        }
//
//        List<String> list = new ArrayList<>();
//        list.add("Apple");
//        list.add("Banana");
//        list.add("Apple");
//        list.add("Orange");
//        Set<String> set = new HashSet<>(list);
//        System.out.println("List: " + list);
//        System.out.println("Set: " + set);

//    }
//}


class Parent {

    int a = 10;

    {
        a = 20;
        System.out.println(a);
    }

    {
        a = 30;
        System.out.println(a);
    }

    Parent() {
        System.out.println(a);
    }
}

public class Test {

    public static void main(String[] args) {
        Parent parent = new Parent();
    }
}