package comfrom;

/**
 * Created by kaorihirata on 2017-09-05.
 */
public class Player {
    private String mark;
    private Boolean isSelected = false;
    private int playCount = 0;

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount() {
        this.playCount++;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }


    public void selectPlace(String selectNum, Board bord) {
        String[] result = new String[2];
        String[] splitNum = selectNum.split(" ");
        bord.setBord(splitNum, this.mark,this);
        bord.display(bord.getBord());
    }

    public Boolean statusCheck(Board board) {
        boolean result = false;
        String[][] statusbord = board.getBord();

        if (statusbord[0][0] != " " && statusbord[0][0] == statusbord[1][1] && statusbord[1][1] == statusbord[2][2]) {
            result = true;
        } else if (statusbord[0][2] != " " && statusbord[0][2] == statusbord[1][1] && statusbord[1][1] == statusbord[2][0]) {
            result = true;
        } else {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 1; j++) {
                    if (statusbord[i][j] != " " && statusbord[i][j] == statusbord[i][j + 1] && statusbord[i][j] == statusbord[i][j + 2]) {
                        result = true;
                    } else {
                        break;
                    }
                }
            }
            for (int y = 0; y < 2; y++) {
                if (statusbord[0][y] != " " &&statusbord[0][y] == statusbord[1][y]&& statusbord[1][y] == statusbord[2][y]){
                    result = true;
                }
            }
        }
        return result;
    }
}
