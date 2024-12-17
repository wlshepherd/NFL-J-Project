import java.util.ArrayList;
import java.util.List;

public class Teams {
    public static List<Team> createNFCEastTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Dallas Cowboys", 70));
        teams.add(new Team("Philadelphia Eagles", 92));
        teams.add(new Team("Washington Commanders", 60));
        teams.add(new Team("New York Giants", 5));
        return teams;
    }

    public static List<Team> createNFCWestTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("San Francisco 49ers", 70));
        teams.add(new Team("Los Angeles Rams", 70));
        teams.add(new Team("Seattle Seahawks", 83));
        teams.add(new Team("Arizona Cardinals", 60));
        return teams;
    }

    public static List<Team> createNFCNorthTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Green Bay Packers", 80));
        teams.add(new Team("Minnesota Vikings", 88));
        teams.add(new Team("Chicago Bears", 55));
        teams.add(new Team("Detroit Lions", 90));
        return teams;
    }

    public static List<Team> createNFCSouthTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Tampa Bay Buccaneers", 75));
        teams.add(new Team("New Orleans Saints", 60));
        teams.add(new Team("Carolina Panthers", 35));
        teams.add(new Team("Atlanta Falcons", 70));
        return teams;
    }

    public static List<Team> createAFCEastTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Buffalo Bills", 93));
        teams.add(new Team("Miami Dolphins", 80));
        teams.add(new Team("New England Patriots", 55));
        teams.add(new Team("New York Jets", 30));
        return teams;
    }

    public static List<Team> createAFCWestTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Kansas City Chiefs", 95));
        teams.add(new Team("Las Vegas Raiders", 10));
        teams.add(new Team("Los Angeles Chargers", 80));
        teams.add(new Team("Denver Broncos", 70));
        return teams;
    }

    public static List<Team> createAFCNorthTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Baltimore Ravens", 90));
        teams.add(new Team("Pittsburgh Steelers", 85));
        teams.add(new Team("Cleveland Browns", 55));
        teams.add(new Team("Cincinnati Bengals", 70));
        return teams;
    }

    public static List<Team> createAFCSouthTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Tennessee Titans", 55));
        teams.add(new Team("Indianapolis Colts", 58));
        teams.add(new Team("Houston Texans", 80));
        teams.add(new Team("Jacksonville Jaguars", 40));
        return teams;
    }
}