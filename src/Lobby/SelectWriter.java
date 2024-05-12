package Lobby;

import java.awt.*;

class SelectWriter {
    Select select;

    public SelectWriter(Select select)
    {
        this.select = select;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.cyan);
        g.drawRect(select.getX(), select.getY(), 300, 60);
        g.drawRect(select.getX() + 5, select.getY() + 5, 290, 50);
        g.drawRect(select.getX() + 10, select.getY() + 10, 280, 40);
        g.drawRect(select.getX() + 15, select.getY() + 15, 270, 30);
    }
}
