package com.example.kunal.systemdesign.lld.snakeladdergame;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    @Getter
    private int size;
    private Map<Integer, Integer> snakes; // head to tail
    private Map<Integer, Integer> ladders; // bottom to top

    public Board(int size, List<Snake> snakeList, List<Ladder> ladderList) {
        this.size = size;
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        snakeList.forEach(s -> snakes.put(s.getHead(), s.getTail()));
        ladderList.forEach(l -> ladders.put(l.getBottom(), l.getTop()));
    }

    public int getNewPosition(int current, int diceRoll){
        int newPos = current + diceRoll;

        // check for snake
        if (snakes.containsKey(newPos)) {
            System.out.println("Oops! Snake at " + newPos + ". Go down to " + snakes.get(newPos));
            newPos = snakes.get(newPos);
        }
        // check for ladder
        else if(ladders.containsKey(newPos)) {
            System.out.println("Ladder at " + newPos + "! Climb to " + ladders.get(newPos));
            newPos = ladders.get(newPos);
        }
        return newPos;
    }

    public boolean isWinningPosition(int current) {
        return current == size;
    }


}

