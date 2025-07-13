/*
 *Given:  Hello this is Arunava
 * Output: Holle tsih is Aavanur
 * */

public class Test3 {
    public static void main(String[] args) {
        String input = "Hello this is Arunava";
        String[] parts = input.split(" ");

        String output = "";

        for (int i = 0; i < parts.length; i++) {

            String temp = String.valueOf(parts[i].charAt(0));

            for (int j = parts[i].length() - 1; j >= 1; j--) {
                temp = temp + parts[i].charAt(j);
            }

            output = output + temp + " ";
        }

        System.out.println(output);
    }
}
