// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//
//        Main: Den här klassen startar spelet.
//        Den kan skapa ett nytt Game-objekt och sedan köra spelet.

        while(true) {
            Game game = new Game(9,10);
            game.play();
        }


    }
}