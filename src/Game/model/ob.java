package Game.model;

abstract class ob { // x,y,r 좌표를 가지는 게임object들에게 공통적인 속성과 기능을 부여하기위한 추상클래스
    protected int x;
    protected int y;
    protected int r;

    public ob(int x, int y, int r)
    {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getR()
    {
        return r;
    }
}
