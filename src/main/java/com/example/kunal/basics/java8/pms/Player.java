package com.example.kunal.basics.java8.pms;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class Player {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + "(" + score + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return score == player.score && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
