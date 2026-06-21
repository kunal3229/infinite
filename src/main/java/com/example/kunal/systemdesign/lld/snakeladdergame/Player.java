package com.example.kunal.systemdesign.lld.snakeladdergame;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {

    private String name;
    @Setter
    private int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = 0;
    }
}
