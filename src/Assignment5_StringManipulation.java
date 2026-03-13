import java.util.*;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> task1(scanner);
                case 2 -> task2(scanner);
                case 3 -> task3(scanner);
                case 4 -> task4(scanner);
                case 5 -> task5(scanner);
                case 6 -> task6(scanner);
                case 7 -> task7(scanner);
                case 8 -> task8(scanner);
                case 0 -> {
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().toLowerCase();

        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count = 0;
        for (char c : input.toCharArray()) {
            if (vowels.contains(c)) {
                count++;
            }
        }

        System.out.println("Number of vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String reversed = "";

        for(int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        System.out.println(reversed);
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean isPalindrome = false;

        String reversed = "";

        for(int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        if (reversed.toLowerCase().equals(input.toLowerCase())) {
            isPalindrome = true;
        }

        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");
        int wordCount = words.length;

        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[] words = input.split(" ");
        String noSpaces = "";

        for(String w : words) {
            noSpaces += w;
        }

        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");
        String result = "";
        for (String w : words) {
            if(!w.isEmpty()) {
                result += w.substring(0, 1).toUpperCase() + w.substring(1) + " ";
            }
        }

        System.out.println(result.trim());
    }

    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char mostFrequent = ' ';
        int maxCount = 0;

        for(int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            int count = 0;

            for(int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == current) {
                    count++;
                }
            }

            if (maxCount < count) {
                maxCount = count;
                mostFrequent = current;
            }
        }

        System.out.println("The most frequent character is: " + mostFrequent);
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine().toLowerCase().trim();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine().toLowerCase().trim();

        ArrayList<Character> chars1 = new ArrayList<>();
        ArrayList<Character> chars2 = new ArrayList<>();
        boolean areAnagrams = false;

        for (char c : str1.toCharArray()) {
            chars1.add(c);
        }
        for (char c : str2.toCharArray()) {
            chars2.add(c);
        }

        Collections.sort(chars1);
        Collections.sort(chars2);

        if (chars1.equals(chars2)) {
            areAnagrams = true;
        }

        System.out.println(areAnagrams ? "Yes" : "No");
    }
}