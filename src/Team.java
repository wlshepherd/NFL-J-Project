import java.util.ArrayList;
import java.util.List;

public class Team {
    String name;
    int wins;
    int losses;
    int rating;
    List<Integer> weeksPlayed;

    public Team(String name, int rating) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.rating = rating;
        this.weeksPlayed = new ArrayList<>();
    }

    public void recordWin() {
        wins++;
    }

    public void recordLoss() {
        losses++;
    }

    public void recordWeek(int week) {
        weeksPlayed.add(week);
    }

    public boolean hasPlayed(int week) {
        return weeksPlayed.contains(week);
    }

    public void resetWinLoss() {
        this.wins = 0;
        this.losses = 0;
    }

    @Override
    public String toString() {
        return name + " - Wins: " + wins + ", Losses: " + losses;
    }
}
