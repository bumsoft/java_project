package Lobby;

public class Select {
    private final int numOfmenu = 3; //메뉴의 개수(게임시작,랭킹,룰)
    private int x;
    private int y;
    private int where; //현재 몇번메뉴를 보고있는지
    private boolean is_spaced; //스페이스 눌림여부

    public Select() //첫번째 메뉴의 위치로 초기화하며 생성
    {
        x = 100;
        y = 250;
        where = 1;
        is_spaced = false;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getWhere()
    {
        return where;
    }

    public void down() //아래메뉴로 이동하는데, 마지막메뉴인 경우, 첫번째 메뉴로 이동시킴
    {
        if (where == numOfmenu)
        {
            where = 1;
            y -= (numOfmenu - 1) * 75;
        } else
        {
            where++;
            y += 75;
        }
    }

    public void up() //down과 반대
    {
        if (where == 1)
        {
            where = numOfmenu;
            y += (numOfmenu - 1) * 75;
        } else
        {
            where--;
            y -= 75;
        }
    }

    public void spacebar()
    {
        is_spaced = true;
    }

    public boolean get() //스페이스 눌렸는지 여부
    {
        return is_spaced;
    }

    public void reset() //스페이스 false로
    {
        is_spaced = false;
    }

}
