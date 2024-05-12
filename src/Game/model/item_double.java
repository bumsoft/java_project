package Game.model;

public class item_double extends item {
    private static final String name = "D";

    public item_double(int x, int y)
    {
        super(x, y);
    }

    public String getName() //아이템이름반환
    {
        return name;
    }

    public int getEffect() //아이템효과반환
    {
        return 1;
    }
}
