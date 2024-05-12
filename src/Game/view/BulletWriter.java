package Game.view;

import Game.control.*;
import Game.model.*;

import java.awt.*;
import java.util.Vector;

class BulletWriter {
    private Bullet_Controller mb;
    private Color bullet_color;

    public BulletWriter(Bullet_Controller x, Color c)
    {
        mb = x;
        bullet_color = c;
    }

    public void paint(Graphics g) //bullet 리스트를 받아서 리스트에 있는 모든 bullet을 그림
    {
        Vector<Bullet> b = mb.getBulletlist();
        int radius;
        for (int i = 0; i < b.size(); i++)
        {
            radius = b.get(i).getR();
            g.setColor(bullet_color);
            g.fillOval(b.get(i).getX() - radius, b.get(i).getY() - radius, radius * 2, radius * 2);
            g.setColor(Color.black);
            g.drawOval(b.get(i).getX() - radius, b.get(i).getY() - radius, radius * 2, radius * 2);
        }
    }
}
