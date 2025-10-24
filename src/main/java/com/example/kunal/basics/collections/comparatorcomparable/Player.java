package com.example.kunal.basics.collections.comparatorcomparable;

import lombok.Getter;

@Getter
public class Player implements Comparable<Player> {

    int id;
    String name;
    int score;

    Player(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Player o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return name + " (" + score + ")";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
