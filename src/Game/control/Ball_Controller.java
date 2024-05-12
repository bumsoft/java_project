package Game.control;

import Game.model.Ball;

import java.util.Vector;

public class Ball_Controller implements controll { //bullet_controller와 비슷함
    private Vector<Ball> ball_list;
    private Game.model.Box box;

    public Ball_Controller(Game.model.Box box)
    {
        ball_list = new Vector<>();
        this.box = box;
    }


    public Vector<Ball> getBall_list()
    {
        return ball_list;
    }

    public void move()
    {
        for (Ball i : ball_list)
        {
            i.move(1, box);
        }
    }

    public void add() //공생성해서 백터에 추가
    {
        Ball temp = new Ball();
        ball_list.add(temp);
    }

    public int getX(int i)
    {
        return ball_list.get(i).getX();
    }

    public int getY(int i)
    {
        return ball_list.get(i).getY();
    }

    public int getSize()
    {
        return ball_list.size();
    }

    public void remove(int i)
    {
        ball_list.remove(i);
    }

    public Ball getI(int i)
    {
        return ball_list.get(i);
    }
}
