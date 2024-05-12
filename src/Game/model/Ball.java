package Game.model;

import java.util.Random;

public class Ball extends ob {
    private static Random random = new Random();
    private int x_velocity = random.nextInt(1) + 1; //공의 x움직임
    private int y_velocity = random.nextInt(2) + 1; //공의 y움직임

    private int origin_hp; //공의 생성시 체력
    private int hp; //현재 공의 체력


    public Ball()
    {
        //x:150~350위치
        // y:150~200 위치
        // r 30~100 크기로 랜덤
        super(random.nextInt(200) + 150, random.nextInt(50) + 150, random.nextInt(70) + 30); // x,y,r임
        origin_hp = this.getR(); //공의 크기와 체력은 반지름과 같다.
        hp = this.getR();
    }

    public int getHp()
    {
        return hp;
    }

    public int getOHp()
    {
        return origin_hp;
    }


    public void hit(int d) //d만큼 공의 체력 감소
    {
        hp -= d;
    }

    public void move(int time_units, Box container) //x_velocity와 y_velocity만큼 x,y 변경. 만약 틀에 닿았다면 움직임 반전
    {
        x = x + x_velocity * time_units;

        if (container.inHorizontalContact(x, r)) x_velocity = -x_velocity;

        y = y + y_velocity * time_units;

        if (container.inVerticalContact(y, r)) y_velocity = -y_velocity;
    }
}
