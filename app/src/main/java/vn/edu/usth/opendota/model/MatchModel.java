package vn.edu.usth.opendota.model;

import java.util.ArrayList;

public class MatchModel {
    private int hero;
    private String mode;
    private String kda;
    private String length;
    private String ended;

    public MatchModel(int hero, String mode, String kda, String length, String ended) {
        this.hero = hero;
        this.mode = mode;
        this.kda = kda;
        this.length = length;
        this.ended = ended;
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

    public String getKda() {
        return kda;
    }

    public void setKda(String kda) {
        this.kda = kda;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }
}
