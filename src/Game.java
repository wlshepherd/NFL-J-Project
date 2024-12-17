import java.util.Random;

public class Game {
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;

    public Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void play() {
        Random random = new Random();

        double team1Chance = team1.rating * (0.95 + (1.25 - 0.95) * random.nextDouble());
        double team2Chance = team2.rating * (0.90 + (1.20 - 0.90) * random.nextDouble());

        team1Chance *= (team1.rating > team2.rating) ? 1.1 : 1.0;
        team2Chance *= (team2.rating > team1.rating)  ? 1.1 : 1.0;

        int team1Touchdowns = random.nextInt((int) (team1Chance / 12) + 1);
        int team2Touchdowns = random.nextInt((int) (team2Chance / 12) + 1);
        int team1FieldGoals = random.nextInt(3);
        int team2FieldGoals = random.nextInt(3);

        team1Score = team1Touchdowns * 7 + team1FieldGoals * 3;
        team2Score = team2Touchdowns * 7 + team2FieldGoals * 3;

        team1Score = adjustScore(team1Score, team1Touchdowns, random);
        team2Score = adjustScore(team2Score, team2Touchdowns, random);

        while (team1Score == team2Score) {
            System.out.println("Overtime! Both teams are tied at " + team1Score + " - " + team2Score);
            int overtimeTeam1Score = random.nextInt(6) + 1;
            int overtimeTeam2Score = random.nextInt(6) + 1;
            team1Score += overtimeTeam1Score;
            team2Score += overtimeTeam2Score;
        }

        if (team1Score > team2Score) {
            team1.recordWin();
            team2.recordLoss();
            System.out.println(team1.name + " wins against " + team2.name + " with a score of " + team1Score + " - " + team2Score);
        } else {
            team2.recordWin();
            team1.recordLoss();
            System.out.println(team2.name + " wins against " + team1.name + " with a score of " + team2Score + " - " + team1Score);
        }
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    private int adjustScore(int score, int touchdowns, Random random) {
        if (score == 1) {
            score += 2;
        } else if (score == 2) {
            score += 3;
        } else if (score == 5) {
            score += 1;
        }
        return score;
    }
}