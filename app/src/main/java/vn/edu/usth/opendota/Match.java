package vn.edu.usth.opendota;

import java.util.ArrayList;

public class Match {
    private int hero;
    private String mode;
    private String ended;
    private String length;
    private String kda;

    public Match(int hero, String mode, String ended, String length, String kda) {
        this.hero = hero;
        this.mode = mode;
        this.ended = ended;
        this.length = length;
        this.kda = kda;
    }

    public int getHero() {
        return hero;
    }

    public void setHero(int hero) {
        this.hero = hero;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getKda() {
        return kda;
    }

    public void setKda(String kda) {
        this.kda = kda;
    }
}
