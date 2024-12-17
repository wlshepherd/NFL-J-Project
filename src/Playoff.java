import java.util.List;

public class Playoff {
    WildCard wildCard;
    Divisional divisional;
    Championship championship;
    SuperBowl superBowl;

    public Playoff() {
        this.wildCard = new WildCard();
        this.divisional = new Divisional();
        this.championship = new Championship();
        this.superBowl = new SuperBowl();
    }

    public void play(List<Team> afcTeams, List<Team> nfcTeams) {
        List<Team> afcWildCardWinners = wildCard.playWildCardRound(afcTeams);
        List<Team> nfcWildCardWinners = wildCard.playWildCardRound(nfcTeams);

        List<Team> afcDivisionalWinners = divisional.playDivisionalRound(afcWildCardWinners, List.of(afcTeams.get(0)));
        List<Team> nfcDivisionalWinners = divisional.playDivisionalRound(nfcWildCardWinners, List.of(nfcTeams.get(0)));

        List<Team> afcConferenceChampions = championship.playChampionshipRound(afcDivisionalWinners);
        List<Team> nfcConferenceChampions = championship.playChampionshipRound(nfcDivisionalWinners);

        if (!afcConferenceChampions.isEmpty() && !nfcConferenceChampions.isEmpty()) {
            superBowl.playSuperBowl(afcConferenceChampions.get(0), nfcConferenceChampions.get(0));
        } else {
            System.out.println("Not enough teams to proceed to Super Bowl.");
        }
    }
}
