package comfrom;

import java.util.Scanner;

public class Main {
    public static Boolean gameover = false;

    public static String getInput(){
        Scanner scan = new Scanner(System.in);
        String result = scan.nextLine();
        return result;
    }

    public static Board createBoard(){
        Board bord = new Board();
        bord.display(bord.getBord());
        return bord;
    }

    public static Player createPlayer(String mark){
        Player player = new Player();
        player.setMark(mark);
        return player;
    }

    /////  Game Main code start /////////

    public static void main(String[] args) {

        System.out.println("===============================");
        System.out.println("WELCOME TO TIC TAC TOE!");
        System.out.println("Designer : John Smith");
        System.out.println("Class : Cornerstone WMDP");
        System.out.println("Date : XX/XX/XX");
        System.out.println("1 --- person vs. person");
        System.out.println("2 --- person vs. random computer");
        System.out.println("Enter your choice(1 or 2)");
        System.out.println("===============================");


        String gameType = getInput();

        //　==== 1 --- person vs. person =====
        if (gameType.equals("1")) {

            System.out.println("you have entered choice 1");
            Board bord = createBoard();
            Player player1 = createPlayer("X");
            Player player2 = createPlayer("O");

            while (!gameover) {
                chosePlaceByInput(player1, bord);
                if (player1.statusCheck(bord)) {
                    System.out.println("Player1 win");
                    break;
                }

                chosePlaceByInput(player2, bord);
                if (player2.statusCheck(bord)) {
                    System.out.println("Player2 win");
                    break;
                }

                if (player1.getPlayCount() == 5 || player2.getPlayCount() == 4) {
                    System.out.println("!!!draw!!!");
                    gameover = true;
                }
            }
        }

        //　==== 2 --- person vs. random computer =====
        else if (gameType.equals("2")) {
            System.out.println("you have entered choice 2");

            Board bord = createBoard();
            Player player1 = createPlayer("X");
            Player player2 = createPlayer("O");

            while (!gameover) {
                chosePlaceByInput(player1, bord);
                if (player1.statusCheck(bord)) {
                    System.out.println("Player1 win");
                    break;
                }

                chosePlaceByComputer(player2,bord);
                player2.setSelected(false);
                if (player2.statusCheck(bord)) {
                    System.out.println("computer win");
                    break;
                }

                if (player1.getPlayCount() == 5 || player2.getPlayCount() == 4) {
                    System.out.println("!!!draw!!!");
                    gameover = true;
                }
            }
        } else {
            System.out.println("you enter invalid number please enter 1 or 2");
        }

    }
    /////  Game Main code end /////////


    public static void chosePlaceByInput(Player player, Board board) {
        while (!player.getSelected()) {
            System.out.println(player + " make your move");
            String inputNum = getInput();
            player.selectPlace(inputNum, board);
        }
        player.setSelected(false);
    }

    public static void chosePlaceByComputer(Player player, Board board) {
        while (!player.getSelected()) {
            System.out.println(player + " make your move");
            int randomNum1 = (int) (Math.random() * 3);
            int randomNum2 = (int) (Math.random() * 3);
            String strRandNum1 = String.valueOf(randomNum1);
            String strRandNum2 = String.valueOf(randomNum2);
            String inputNum = (strRandNum1 + " " + strRandNum2);
            System.out.println(inputNum);
            player.selectPlace(inputNum, board);
        }
        player.setSelected(false);
    }
}
