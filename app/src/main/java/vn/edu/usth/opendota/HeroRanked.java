package vn.edu.usth.opendota;

public class HeroRanked {
    String hero_name;
    String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    String pick_rate;
    String win_rate;

    public HeroRanked(String rank, String hero_name, String pick_rate, String win_rate) {
        this.hero_name = hero_name;
        this.rank = rank;
        this.pick_rate = pick_rate;
        this.win_rate = win_rate;
    }

    public HeroRanked(String hero_name, String pick_rate, String win_rate) {
        this.hero_name = hero_name;
        this.pick_rate = pick_rate;
        this.win_rate = win_rate;
    }

    public String getHero_name() {
        return hero_name;
    }

    public void setHero_name(String hero_name) {
        this.hero_name = hero_name;
    }

    public String getPick_rate() {
        return pick_rate;
    }

    public void setPick_rate(String pick_rate) {
        this.pick_rate = pick_rate;
    }

    public String getWin_rate() {
        return win_rate;
    }

    public void setWin_rate(String win_rate) {
        this.win_rate = win_rate;
    }
}
