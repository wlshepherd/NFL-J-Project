import java.util.ArrayList;
import java.util.List;

public class WildCard {
    public List<Team> playWildCardRound(List<Team> teams) {
        List<Team> wildCardTeams = new ArrayList<>(teams.subList(1, 7));
        return playRound("Wild Card Round", wildCardTeams);
    }

    private List<Team> playRound(String roundName, List<Team> teams) {
        System.out.println(roundName + ":");
        List<Team> winners = new ArrayList<>();
        for (int i = 0; i < teams.size(); i += 2) {
            if (i + 1 < teams.size()) {
                Game game = new Game(teams.get(i), teams.get(i + 1));
                game.play();
                Team winner = determineWinner(teams.get(i), teams.get(i + 1));
                winners.add(winner);
            }
        }
        resetRecords(winners);
        System.out.println(" ");
        return winners;
    }

    private Team determineWinner(Team team1, Team team2) {
        return (team1.wins > team2.wins) ? team1 : team2;
    }

    private void resetRecords(List<Team> teams) {
        for (Team team : teams) {
            team.resetWinLoss();
        }
    }
}
