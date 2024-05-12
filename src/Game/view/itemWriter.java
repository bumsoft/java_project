package Game.view;

import Game.model.*;
import Game.control.*;

import java.awt.*;

class itemWriter {
    private item_Controller ic;
    private Font letter;
    final int radius = 12;

    public itemWriter(item_Controller ic)
    {
        this.ic = ic;
        letter = new Font("Arial", Font.BOLD, 12);
    }

    public void paint(Graphics g) //item리스트 내 모든 Game.model.item 그림
    {
        for (item i : ic.get_item_list())
        {
            g.setColor(Color.cyan);
            g.fillOval(i.getX() - radius, i.getY() - radius, radius * 2, radius * 2);
            g.setColor(Color.black);
            g.setFont(letter);
            g.drawString(i.getName(), i.getX() - 5, i.getY() + 3);
        }
    }
}
