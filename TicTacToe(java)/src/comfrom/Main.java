package comfrom;

import java.util.Scanner;

public class Main {
    public static Boolean gameover = false;

    public static void main(String[] args) {
        int playCount = 0;

	    System.out.println("===============================");
        System.out.println("WELCOME TO TIC TAC TOE!");
        System.out.println("Designer : John Smith");
        System.out.println("Class : Cornerstone WMDP");
        System.out.println("Date : XX/XX/XX");
        System.out.println("1 --- person vs. person");
        System.out.println("2 --- person vs. random computer");
        System.out.println("Enter your choice(1 or 2)");
        System.out.println("===============================");


        Scanner scan = new Scanner(System.in);
        String inputNum = scan.nextLine();

        if(inputNum.equals("1")){

                System.out.println("you have entered choice 1");
                Board bord = new Board();
                bord.display(bord.getBord());

            while (!gameover) {
                Player p1 = new Player();
                p1.setMark("X");
                System.out.println("Player1 make your move");
                inputNum = scan.nextLine();
                p1.selectPlace(inputNum, bord);


                Player p2 = new Player();
                p1.setMark("O");
                System.out.println("Player2 make your move");
                inputNum = scan.nextLine();
                p1.selectPlace(inputNum, bord);

                playCount++;
                if(playCount == 9){
                    gameover = true;
                }
            }

        }
        else if(inputNum.equals("2")){
            System.out.println("you have entered choice 2");
        }
        else {
            System.out.println("you enter invalid number please enter 1 or 2");
        }

    }
}
