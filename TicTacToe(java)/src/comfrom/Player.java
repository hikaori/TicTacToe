package comfrom;

/**
 * Created by kaorihirata on 2017-09-05.
 */
public class Player {
    String mark;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void selectPlace(String selectNum, Board bord) {
        String[] result = new String[2];
        String[] splitNum = selectNum.split(" ");
        bord.setBord(splitNum,this.mark);
        bord.display(bord.getBord());
    }
}
