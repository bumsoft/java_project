package Game.control;

import Game.model.*;

import java.util.Random;
import java.util.Vector;

public class item_Controller implements controll {
    private Vector<item> item_list;

    public item_Controller()
    {
        item_list = new Vector<>();
    }

    public void add(Random random, int size) //랜덤한 아이템을 박스의 사이즈에 따른 랜덤한 위치에 생성함
    {
        item t;
        int temp = random.nextInt(5) + 1;
        if (temp == 1) //1이면 뎀지
        {
            t = new item_double(random.nextInt(size - 50) + 30, 0);
        } else
        {
            t = new item_increase(random.nextInt(size - 50) + 30, 0, temp);
        }
        item_list.add(t);
    }

    public void move(Game.model.Box box) //item백터의 모든 item의 move()메소드 호출
    {
        for (item i : item_list)
        {
            i.move(box);
        }
    }

    public Vector<item> get_item_list()
    {
        return item_list;
    }

    public int getX(int i)
    {
        return item_list.get(i).getX();
    }

    public int getY(int i)
    {
        return item_list.get(i).getY();
    }

    public int getSize() //백터크기
    {
        return item_list.size();
    }

    public void remove(int i)
    {
        item_list.remove(i);
    }

    public int getEffect(int i) //i번째 아이템의 효과 반환
    {
        return item_list.get(i).getEffect();
    }

    public item getI(int i) //i번째 아이템반환
    {
        return item_list.get(i);
    }
}
