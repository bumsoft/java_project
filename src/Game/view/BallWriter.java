package Game.view;

import Game.model.Ball;

import java.awt.*;
import java.util.Vector;

class BallWriter {
    private Vector<Ball> ball;
    private Color balls_color;

    private Font letter;

    public BallWriter(Vector<Ball> balllist, Color c)
    {
        ball = balllist;
        balls_color = c;
        letter = new Font("Arial", Font.BOLD, 50);
    }

    public Vector<Ball> getBall_list()
    {
        return ball;
    }

    public void paint(Graphics g) //ball리스트 내의 모든 ball 그림
    {
        for (int i = 0; i < ball.size(); i++)
        {
            g.setColor(balls_color);
            int radius = ball.get(i).getR();
            g.fillOval(ball.get(i).getX() - radius, ball.get(i).getY() - radius, radius * 2, radius * 2);
            g.setColor(Color.red);
            g.drawOval(ball.get(i).getX() - radius, ball.get(i).getY() - radius, radius * 2, radius * 2);
            g.setColor(Color.white);
            g.setFont(letter);
            g.drawString(Integer.toString(ball.get(i).getHp()), ball.get(i).getX() - 35, ball.get(i).getY() + 10);
        }
    }
}
