package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("demo.json"); // Your complete address not smaller one

            // Read JSON file into JsonNode
            JsonNode jsonNode = objectMapper.readTree(file);

            // Extract the "words" array
            JsonNode wordsArray = jsonNode.get("words");

            // Iterate through the array and print each word
            for (JsonNode word : wordsArray) {
                System.out.println(word.asText());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
