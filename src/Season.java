import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Season {
    List<Team> teams;
    List<Team> nfcEast, nfcWest, nfcNorth, nfcSouth, afcEast, afcWest, afcNorth, afcSouth;
    List<List<Game>> weeks;

    public Season(List<Team> nfcEast, List<Team> nfcWest, List<Team> nfcNorth, List<Team> nfcSouth,
                  List<Team> afcEast, List<Team> afcWest, List<Team> afcNorth, List<Team> afcSouth) {
        this.nfcEast = nfcEast;
        this.nfcWest = nfcWest;
        this.nfcNorth = nfcNorth;
        this.nfcSouth = nfcSouth;
        this.afcEast = afcEast;
        this.afcWest = afcWest;
        this.afcNorth = afcNorth;
        this.afcSouth = afcSouth;

        this.teams = new ArrayList<>();
        this.teams.addAll(nfcEast);
        this.teams.addAll(nfcWest);
        this.teams.addAll(nfcNorth);
        this.teams.addAll(nfcSouth);
        this.teams.addAll(afcEast);
        this.teams.addAll(afcWest);
        this.teams.addAll(afcNorth);
        this.teams.addAll(afcSouth);

        this.weeks = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            weeks.add(new ArrayList<>());
        }
    }

    public void generateSchedule() {
        for (int i = 0; i < 17; i++) {
            Collections.shuffle(teams);
            for (int j = 0; j < teams.size(); j += 2) {
                weeks.get(i).add(new Game(teams.get(j), teams.get(j + 1)));
            }
        }
    }

    public void playRegularSeason() {
        Scanner scanner = new Scanner(System.in);
        generateSchedule();
        for (int week = 0; week < weeks.size(); week++) {
            if (week < 17) {
                System.out.println("Week " + (week + 1) + ":");
                for (Game game : weeks.get(week)) {
                    game.play();
                }
                System.out.println(" ");
                displayStandings();
                if (week < 16) {
                    System.out.println("Press Enter to proceed to the next week...");
                    scanner.nextLine();
                }
            }
        }

        displayStandings();
    }

    public List<Team> getTopTeams(int numberOfTeams) {
        teams.sort((a, b) -> b.wins - a.wins);
        return new ArrayList<>(teams.subList(0, numberOfTeams));
    }

    public List<Team> getAllTeams() {
        return new ArrayList<>(teams);
    }

    public void displayStandings() {
        System.out.println("NFC East Standings:");
        printDivisionStandings(nfcEast);

        System.out.println("NFC West Standings:");
        printDivisionStandings(nfcWest);

        System.out.println("NFC North Standings:");
        printDivisionStandings(nfcNorth);

        System.out.println("NFC South Standings:");
        printDivisionStandings(nfcSouth);

        System.out.println("AFC East Standings:");
        printDivisionStandings(afcEast);

        System.out.println("AFC West Standings:");
        printDivisionStandings(afcWest);

        System.out.println("AFC North Standings:");
        printDivisionStandings(afcNorth);

        System.out.println("AFC South Standings:");
        printDivisionStandings(afcSouth);
    }

    private void printDivisionStandings(List<Team> division) {
        division.sort((a, b) -> b.wins - a.wins);
        System.out.printf("%-25s %-10s %-10s%n", "Team", "Wins", "Losses");
        for (Team team : division) {
            System.out.printf("%-25s %-10d %-10d%n", team.name, team.wins, team.losses);
        }
        System.out.println(" ");
    }
}
