import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userInput;
        do {
            List<Team> nfcEast = Teams.createNFCEastTeams();
            List<Team> nfcWest = Teams.createNFCWestTeams();
            List<Team> nfcNorth = Teams.createNFCNorthTeams();
            List<Team> nfcSouth = Teams.createNFCSouthTeams();

            List<Team> afcEast = Teams.createAFCEastTeams();
            List<Team> afcWest = Teams.createAFCWestTeams();
            List<Team> afcNorth = Teams.createAFCNorthTeams();
            List<Team> afcSouth = Teams.createAFCSouthTeams();

            Season season = new Season(nfcEast, nfcWest, nfcNorth, nfcSouth, afcEast, afcWest, afcNorth, afcSouth);
            season.playRegularSeason();

            List<Team> afcPlayoffTeams = getConferenceTopTeams(season.getAllTeams(), "AFC", 7);
            List<Team> nfcPlayoffTeams = getConferenceTopTeams(season.getAllTeams(), "NFC", 7);

            Playoff playoff = new Playoff();
            playoff.play(afcPlayoffTeams, nfcPlayoffTeams);

            System.out.print("Simulate another season? (y/n): ");
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();

        } while (userInput.equalsIgnoreCase("y"));
    }

    private static List<Team> getConferenceTopTeams(List<Team> allTeams, String conference, int numberOfTeams) {
        List<Team> conferenceTeams = new ArrayList<>();
        for (Team team : allTeams) {
            if ((conference.equals("AFC") && isAFC(team.name)) || (conference.equals("NFC") && !isAFC(team.name))) {
                conferenceTeams.add(team);
            }
        }
        conferenceTeams.sort((a, b) -> b.wins - a.wins);
        return new ArrayList<>(conferenceTeams.subList(0, numberOfTeams));
    }

    private static boolean isAFC(String teamName) {
        return teamName.equals("Buffalo Bills") || teamName.equals("Miami Dolphins") || teamName.equals("New England Patriots") || teamName.equals("New York Jets") ||
                teamName.equals("Kansas City Chiefs") || teamName.equals("Las Vegas Raiders") || teamName.equals("Los Angeles Chargers") || teamName.equals("Denver Broncos") ||
                teamName.equals("Baltimore Ravens") || teamName.equals("Pittsburgh Steelers") || teamName.equals("Cleveland Browns") || teamName.equals("Cincinnati Bengals") ||
                teamName.equals("Tennessee Titans") || teamName.equals("Indianapolis Colts") || teamName.equals("Houston Texans") || teamName.equals("Jacksonville Jaguars");
    }
}
