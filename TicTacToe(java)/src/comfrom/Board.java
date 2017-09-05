package comfrom;

/**
 * Created by kaorihirata on 2017-09-05.
 */
public class Board {
    private String[][] bord;

    public Board() {
        bord = new String[3][3];
        bord[0][0] = " ";
        bord[0][1] = " ";
        bord[0][2] = " ";
        bord[1][0] = " ";
        bord[1][1] = " ";
        bord[1][2] = " ";
        bord[2][0] = " ";
        bord[2][1] = " ";
        bord[2][2] = " ";

    }

    void display(String[][] board) {
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            System.out.println("==========");
            for (int k = 0; k < 3; k++) {
                System.out.print("| " + board[i][k]);
            }
            System.out.print("| ");
        }
        System.out.println("\n==========");
    }

    public String[][] getBord() {
        return bord;
    }

    public void setBord(String[] bord,String mark ,Player playter) {
        int firstIndex = Integer.parseInt(bord[0]);
        int secondIndex = Integer.parseInt(bord[1]);
        if(this.bord[firstIndex][secondIndex] == " ") {
            this.bord[firstIndex][secondIndex] = mark;
            playter.setSelected(true);
            playter.setPlayCount();
        }
        else {
            System.out.println("this is already selected");
            playter.setSelected(false);
        }
    }
}
