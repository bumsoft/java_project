package Game.model;

public class Player extends ob {
    private static final int movement = 15; //좌/우방향키 눌렀을때 얼마만큼 움직일지

    public Player(int x, int y, int r)
    {
        super(x, y - r, r);
    }

    public void left() //왼쪽으로 movement만큼 이동
    {
        x -= movement;
    }

    public void right() //오른쪽으로 movement만큼 이동
    {
        x += movement;
    }

    public int getMovement() //movement 반환
    {
        return movement;
    }

    public void setX(int i) // x좌표를 i로 변경
    {
        x = i;
    }
}
