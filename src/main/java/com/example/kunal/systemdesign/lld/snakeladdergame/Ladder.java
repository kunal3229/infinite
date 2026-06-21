package com.example.kunal.systemdesign.lld.snakeladdergame;

import lombok.Getter;

@Getter
public class Ladder {
    private int top, bottom;

    public  Ladder(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }
}
