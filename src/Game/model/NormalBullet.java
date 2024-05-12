package Game.model;

public class NormalBullet extends Bullet {

    public NormalBullet(int x, int y)
    {
        super(x, y, 5);
    }

    public void move() //총알의 y좌표 변경
    {
        y -= 10;
    }

    public int getDamage() //총알의 데미지 반환
    {
        return 1;
    }
}
