public class ReplaceString {

    public static String SnakeCase(String str) {
        // code goes here


        String rep = str.replace(" ", "_");
        rep = rep.replace("-", "_");
        rep = rep.replace("%", "_");
        System.out.println("Given string -> " + str);
        System.out.println("Output string -> " + rep);
        return rep;
    }

    public static void main(String[] args) {

        SnakeCase("a b c d-e-f%g");

    }

}
