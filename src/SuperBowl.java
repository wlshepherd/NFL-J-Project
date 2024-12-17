public class SuperBowl {
    public void playSuperBowl(Team afcChampion, Team nfcChampion) {
        System.out.println("Super Bowl:");
        Game game = new Game(afcChampion, nfcChampion);
        game.play();
    }
}
