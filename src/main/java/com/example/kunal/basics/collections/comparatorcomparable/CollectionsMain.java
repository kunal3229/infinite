package com.example.kunal.basics.collections.comparatorcomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsMain {
    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();
        players.add(new Player(2, "Max", 80));
        players.add(new Player(1, "Alex", 95));
        players.add(new Player(3, "Nina", 70));

        Collections.sort(players);
        System.out.println(players);

        // Use custom comparator to sort by score descending
        players.sort((p1, p2) -> p2.score - p1.score);
        players.sort(Comparator.comparing(Player::getScore).reversed());


    }
}
