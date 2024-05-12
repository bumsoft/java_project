package Game.model;

public class DoubleDamageBullet extends Bullet {

    public DoubleDamageBullet(int x, int y)
    {
        super(x, y, 10);
    }

    public void move() //총알의 y좌표 변경
    {
        y -= 10;
    }

    public int getDamage() //총알의 데미지 반환
    {
        return 2;
    }
}
