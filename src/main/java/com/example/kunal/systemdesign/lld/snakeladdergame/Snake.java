package com.example.kunal.systemdesign.lld.snakeladdergame;

import lombok.Getter;

@Getter
public class Snake {

    private int head;
    private int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }
}
