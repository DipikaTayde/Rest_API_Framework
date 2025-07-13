/*
 * Given:  Hello this is Arunava
 * Output: HavanurA si siht olle
 * */

public class Test4 {

    public static void main(String[] args) {

        char[] input = "Hello this is Arunava".toCharArray();

        String output = String.valueOf(input[0]);

        for (int i = input.length - 1; i >= 1; i--) {
            output = output + input[i];
        }

        System.out.println(output);
    }
}
