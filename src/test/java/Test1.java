// revers string using loops
public class Test1 {

    public static void main(String[] args) {

        String sr = "Hello";
        int count = sr.length() - 1;
        char srAr[] = sr.toCharArray();
        int i = 0;

        for (i = count; i >= 0; i--) {
            System.out.print(srAr[i]);
        }

    }
}

