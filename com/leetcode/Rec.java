package com.leetcode;

import java.util.Objects;

/**
 * Created by appleuser on 8/29/16.
 */
public class Rec {
    public int x;
    public int y;
    public Rec(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object o)
    {
        Rec rec = (Rec)o;
        return this.x == rec.x && this.y == rec.y;
    }

    public String toString(){
        return "["+ x + "," + y + "]";
    }
}
