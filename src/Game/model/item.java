package Game.model;

public abstract class item extends ob {
    protected static final int item_r = 12;

    public item(int x, int y)
    {
        super(x, y, item_r);
    }

    //아이템의 이름과 효과->하위클래스에서 정의할거임
    abstract public String getName();

    abstract public int getEffect();

    public void move(Box box)//아이템의 y좌표 증가
    {
        if (box.item_bottom(y, 12))
            y += 1;
    }
}
