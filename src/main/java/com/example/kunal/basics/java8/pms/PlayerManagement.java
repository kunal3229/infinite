package com.example.kunal.basics.java8.pms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PlayerManagement {

    public static void main(String[] args) {

        List<Player> players = Arrays.asList(
                new Player("Alice", 50),
                new Player("Bob", 70),
                new Player("Charlie", 40),
                new Player("David", 90),
                new Player("Eve", 60)
        );

        // 1️⃣ Use Functional Interface + Lambda to check high score
        ScoreChecker highScoreChecker = p -> p.getScore() >= 60;

        System.out.println("High Score Players (Lambda + Functional Interface):");
        players.stream().filter(highScoreChecker::check).forEach(System.out::println);

        // 2️⃣ Use Stream to sort players by score descending
        System.out.println("\nPlayers sorted by score (Descending):");
        players.stream().sorted(Comparator.comparingInt(Player::getScore).reversed()).forEach(System.out::println);

        // 3️⃣ Use Stream map to get names in uppercase
        System.out.println("\nPlayer names in uppercase:");
        players.stream().map(p -> p.getName().toUpperCase()).forEach(System.out::println);

        // 4️⃣ Use reduce to get total score
        int totalScore = players.stream().map(Player::getScore).reduce(0, Integer::sum);
        System.out.println("\nTotal Score of all players: " + totalScore);

        // 6️⃣ Optional usage with findFirst
        Optional<Player> firstHighScorer = players.stream().filter(p -> p.getScore() >= 80).findFirst();
        firstHighScorer.ifPresent(p -> System.out.println("\nFirst player with score >= 80: " + p));
    }
}
