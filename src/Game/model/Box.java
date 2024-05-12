package Game.model;

public class Box { //게임이 진행될 틀
    private int box_size;

    public Box(int size)
    {
        box_size = size;
    }

    public boolean inHorizontalContact(int x_position, int r)  //공이 벽에 닿았는지 여부 반환
    {
        return x_position <= r || x_position >= box_size - r;
    }

    public boolean inVerticalContact(int y_position, int r) //공이 바닥/천장에 닿았는지 여부 반환
    {
        return y_position <= r || y_position >= box_size - r;
    }

    public boolean item_bottom(int y, int r) //아이템에 바닥에 닿았는지 안닿았는지를 반환(안닿았다면 true!! 닿았으면 false)
    {
        return y <= box_size - r;
    }

    public int sizeOf()
    {
        return box_size;
    } //박스사이즈 반환
}
