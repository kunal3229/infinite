package com.example.kunal.systemdesign.lld.snakeladdergame;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderGame {

    private Board board;
    private Dice dice;
    private Queue<Player> players;
    private boolean gameOver;

    public SnakeAndLadderGame(Board board, Dice dice, List<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = new LinkedList<>(players);
        this.gameOver = false;
    }

    public void play(){
        while (!gameOver) {
            Player current = players.poll();
            int roll = dice.roll();
            System.out.println(current.getName() + " rolled " + roll);

            int newPos = board.getNewPosition(current.getPosition(), roll);
            current.setPosition(newPos);
            System.out.println(current.getName() + " moved to " + newPos);

            if (board.isWinningPosition(newPos)) {
                System.out.println(current.getName() + " WINS!");
                gameOver = true;
            } else {
                players.offer(current); // back to queue
            }
        }
    }

    // Main
    // Board board = new Board(100, snakes, ladders);
    // SnakeAndLadderGame game = new SnakeAndLadderGame(board, new Dice(6), players);
    // game.play();
}
