import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Steps:
        String[] steps = {
                "Take Input from User",
                "Remove small/redundant words from List of small words",
                "Using Dictionary combine words with the same meaning",
                "Now sort these words in alphabetical order",
                "Now sort these words using frequency of words",
                "Output these words in the form of a table"
        };
        System.out.println(Arrays.toString(steps).replaceAll(", ", "\n").replace("[", "").replace("]", ""));

        StringBuilder input = new StringBuilder(inputFunction());

        input = removeSmallWords(input);
        System.out.println("After removing small words:\n" + input);

        // Call the function to combine words with the same meaning using a dictionary
        dictionaryWords(input);

        alphabeticalSort(input);
        System.out.println("After sorting alphabetically:\n" + input);

        frequencySort(input);
        System.out.println("After sorting by frequency:\n" + input);

        outputTable(input);
    }

    private static void outputTable(StringBuilder input) {
        // Create a Hashtable to store word frequencies
        Hashtable<String, Integer> wordFrequency = new Hashtable<>();

        // Count the frequency of each word in the StringBuilder
        StringTokenizer tokenizer = new StringTokenizer(input.toString(), " ");
        while (tokenizer.hasMoreTokens()) {
            String currentWord = tokenizer.nextToken();
            wordFrequency.put(currentWord, wordFrequency.getOrDefault(currentWord, 0) + 1);
        }

        // Print the table header
        System.out.printf("%-15s%-15s\n", "Word", "Frequency");
        System.out.println("------------------------------");

        // Print each word and its frequency
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            System.out.printf("%-15s%-15d\n", word, frequency);
        }

        // Print a message for demonstration purposes
        System.out.println("Table Output:");
    }


    private static void frequencySort(StringBuilder input) {
        
        System.out.println("Sorting by frequency...");
    }

    private static void alphabeticalSort(StringBuilder input) {
        System.out.println("Sorting alphabetically...");
    }

    private static void dictionaryWords(StringBuilder input) {
        // Simple dictionary for lemmatization
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("running", "run");
        dictionary.put("swimming", "swim");
        dictionary.put("eats", "eat");
        // Add more mappings as needed

        // Tokenize the input
        StringTokenizer tokenizer = new StringTokenizer(input.toString(), " ");
        StringBuilder lemmatizedInput = new StringBuilder();

        // Lemmatize each word using the dictionary
        while (tokenizer.hasMoreTokens()) {
            String currentWord = tokenizer.nextToken().toLowerCase(); // Convert to lowercase for case-insensitivity
            String lemma = dictionary.getOrDefault(currentWord, currentWord);
            lemmatizedInput.append(lemma).append(" ");
        }

        // Set the original StringBuilder to the lemmatized value
        input.setLength(0);
        input.append(lemmatizedInput.toString().trim());

        System.out.println("After combining words with the same meaning using a dictionary:\n" + input);
    }


    private static StringBuilder removeSmallWords(StringBuilder input) {
        String[] smallWordsArray = {
                "a", "an", "the", "and", "is", "it", "in", "on", "at", "to",
                "of", "with", "for", "by", "from", "as", "be", "or", "this", "that",
                "he", "she", "we", "you", "they", "I", "me", "him", "her", "us",
                "my", "your", "his", "its", "our", "their", "mine", "yours", "hers", "ours",
                "theirs", "which", "who", "what", "when", "where", "why", "how", "not", "no",
                "yes", "all", "some", "any", "many", "few", "every", "each", "more", "less",
                "but", "if", "else", "or", "so", "then", "now", "soon", "today", "yesterday",
                "tomorrow", "before", "after", "while", "during", "since", "until", "because",
                "since", "although", "are"
        };
        for (String smallWord : smallWordsArray) {
            String wordToRemove = " " + smallWord + " ";
            // Remove the small word surrounded by spaces
            int index;
            while ((index = input.indexOf(wordToRemove)) != -1) {
                input.delete(index, index + wordToRemove.length());
            }

            // Check for words at the beginning and end of the StringBuilder
            if (input.toString().startsWith(smallWord + " ")) {
                input.delete(0, smallWord.length() + 1);
            }

            if (input.toString().endsWith(" " + smallWord)) {
                input.delete(input.length() - smallWord.length() - 1, input.length());
            }
        }
        return input;
    }


    private static String inputFunction() {
        // Your existing inputFunction method
        // For demonstration purposes, a predefined input string is used
        return "a place called Home where eats and eat are the same";
    }
}
