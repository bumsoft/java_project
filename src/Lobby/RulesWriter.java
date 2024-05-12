package Lobby;

import java.awt.*;

class RulesWriter { //Rule을 그려줄거임
    private int size = 500;
    private Font letter = new Font("Arial", Font.BOLD, 40);
    private Font small_letter = new Font("Arial", Font.BOLD, 17);
    private Font mid_letter = new Font("Arial", Font.BOLD, 20);

    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, size, size);
        g.setColor(Color.black);
        g.drawRect(0, 0, size, size);
        g.setFont(letter);
        g.drawString("[Rules]", 180, 40); //한글 안됨
        g.setFont(small_letter);
        g.drawString("(press 'BACK_SPACE' to return)", 120, 75); //한글 안됨


        //게임설명
        g.setFont(mid_letter);
        g.setColor(Color.black);
        g.drawString(">You can get SCORE by destroying ball.", 40, 140);
        g.drawString(">You can get random items every 15 seconds.", 40, 200);
        g.drawString("   Item's effect will last for 5 seconds.", 40, 240);

        g.drawString("and", 85, 270);
        g.drawString("are overlappable", 160, 270);


        g.drawString(">You can use 150 scores,", 40, 330);
        g.drawString("   to clear every balls by pressing SPACE_BAR.", 40, 370);

        g.setColor(Color.cyan);
        g.fillOval(60, 250, 12 * 2, 12 * 2);
        g.fillOval(125, 250, 12 * 2, 12 * 2);
        g.setColor(Color.black);
        g.setFont(small_letter);
        g.drawString("D", 65, 270);
        g.drawString("X?", 130, 270);
    }
}
