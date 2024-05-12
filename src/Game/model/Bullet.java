package Game.model;

public abstract class Bullet extends ob {     //추가기능이 있는 총알들의 공통적 속성을 지닌 추상클래스

    public Bullet(int x, int y, int r)
    {
        super(x, y, r);
    }

    //추상메소드들-> 하위클래스에서 정의할 예정
    abstract public void move();

    abstract public int getDamage();
}
