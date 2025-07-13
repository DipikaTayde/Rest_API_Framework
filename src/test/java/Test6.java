public class Test6 {

    public static void main(String[] args) {
        // Frequency array for letters a-z
        int[] freq = new int[26];
        String inputStr = "aacccbbb";

// Count frequency of each letter
        for (
                char c : inputStr.toCharArray()) {
            freq[c - 'a']++;
        }

        // Count how many letters appear an odd number of times
        int oddCount = 0;
        for (
                int count : freq) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        // If at most 1 odd count, already a permutation of a palindrome
        if (oddCount <= 1) {
            System.out.println(27);
        }

        // Otherwise, adding a letter can reduce oddCount
        // return 26-oddCount +1;
        //System.out.println(26-oddCount +1);
        System.out.println(oddCount);
    }


}