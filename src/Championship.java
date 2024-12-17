import java.util.ArrayList;
import java.util.List;

public class Championship {
    public List<Team> playChampionshipRound(List<Team> divisionalWinners) {
        return playRound("Conference Championship", divisionalWinners);
    }

    private List<Team> playRound(String roundName, List<Team> teams) {
        System.out.println(roundName + ":");
        List<Team> winners = new ArrayList<>();
        for (int i = 0; i < teams.size(); i += 2) {
            if (i + 1 < teams.size()) {
                Game game = new Game(teams.get(i), teams.get(i + 1));
                game.play();
                Team winner = determineWinner(game);
                winners.add(winner);
            }
        }
        resetRecords(teams);
        System.out.println(" ");
        return winners;
    }

    private Team determineWinner(Game game) {
        if (game.getTeam1Score() > game.getTeam2Score()) {
            return game.getTeam1();
        } else {
            return game.getTeam2();
        }
    }

    private void resetRecords(List<Team> teams) {
        for (Team team : teams) {
            team.resetWinLoss();
        }
    }
}
