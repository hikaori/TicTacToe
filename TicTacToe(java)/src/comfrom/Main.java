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

        //　==== 1 --- person vs. person =====
        if(inputNum.equals("1")){

            System.out.println("you have entered choice 1");
            Board bord = new Board();
            bord.display(bord.getBord());

            Player p1 = new Player();
            p1.setMark("X");
            Player p2 = new Player();
            p2.setMark("O");
            while (!gameover) {
                while(!p1.getSelected()) {
                    System.out.println("Player1 make your move");
                    inputNum = scan.nextLine();
                    p1.selectPlace(inputNum, bord);
                }

                p1.setSelected(false);
                if(p1.statusCheck(bord)){
                    System.out.println("Player1 win");
                    break;
                }

                while(!p2.getSelected()) {
                    System.out.println("Player2 make your move");
                    inputNum = scan.nextLine();
                    p2.selectPlace(inputNum, bord);
                }
                p2.setSelected(false);
                if(p2.statusCheck(bord)){
                    System.out.println("Player2 win");
                    break;
                }

                if(p1.getPlayCount()==5 || p2.getPlayCount()==4){
                    System.out.println("!!!draw!!!");
                    gameover = true;
                }
            }

        }

        //　==== 2 --- person vs. random computer =====
        else if(inputNum.equals("2")){
            System.out.println("you have entered choice 2");

            Board bord = new Board();
            bord.display(bord.getBord());

            Player p1 = new Player();
            p1.setMark("X");
            Player p2 = new Player();
            p2.setMark("O");
            while (!gameover) {
                while(!p1.getSelected()) {
                    System.out.println("Player1 make your move");
                    inputNum = scan.nextLine();
                    p1.selectPlace(inputNum, bord);
                }
                p1.setSelected(false);
                if(p1.statusCheck(bord)){
                    System.out.println("Player1 win");
                    break;
                }
                else if(p1.getPlayCount()==4){
                    System.out.println("!!!draw!!!");
                    gameover = true;
                }


                while(!p2.getSelected()) {
                    System.out.println("computer make move");
                    int randomNum1 = (int) (Math.random() * 3);
                    int randomNum2 = (int) (Math.random() * 3);
                    String strRandNum1 = String.valueOf(randomNum1);
                    String strRandNum2 = String.valueOf(randomNum2);
                    inputNum = (strRandNum1 + " " + strRandNum2);
                    System.out.println(inputNum);
                    p2.selectPlace(inputNum, bord);
                }
                p2.setSelected(false);
                if(p2.statusCheck(bord)){
                    System.out.println("computer win");
                    break;
                }

                if(p1.getPlayCount()==5 || p2.getPlayCount()==4){
                    System.out.println("!!!draw!!!");
                    gameover = true;
                }

            }
        }


        else {
            System.out.println("you enter invalid number please enter 1 or 2");
        }

    }
}
