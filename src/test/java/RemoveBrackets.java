public class RemoveBrackets {

    public static String RemoveBrackets(String str) {
        // code goes here
        int c = str.length() - 1;

        char sAr[] = str.toCharArray();
        //0,1,2,4

        for (int i = 0; i <= c; i++) {
            if ((i == 0) || (i == 1) || (i == 2) || (i == 4)) {
                System.out.print(sAr[i]);
            }
        }

        return str;
    }

    public static void main(String[] args) {

        RemoveBrackets("(())()(((");

    }

}
