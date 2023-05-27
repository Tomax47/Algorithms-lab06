import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FifthTask {

    public static void main(String[] args) {
        String[] text = {"Luke", "Banana", "Alexis", "SpongeBob", "911"};
        System.out.println("The 5 lettered words number is: " + countIt(text, s -> s.length() == 5));

        Predicate<String> p = s -> {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                    return false;
            }
            return true;
        };

        for (String word : text) {
            System.out.println(word + " = " + p.test(word));
        }

        System.out.println("\nPoli. count: " + countIt(text, p));

        Predicate<String> startWithW = s -> s.startsWith("w");
        List<String> withW = new ArrayList<>();
        for (String line : text) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (startWithW.test(word)) {
                    withW.add(word);
                }
            }
        }
        System.out.println("Words starting with 'w':");
        for (String word : withW) {
            System.out.println(word);
        }

    }

    public static int countIt(String[] text, Predicate<String> p) {
        int count = 0;
        for (String s : text) {
            if (p.test(s)) {
                count++;
            }
        }
        return count;
    }
}
