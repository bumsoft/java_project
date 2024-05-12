package Lobby;

import java.awt.*;

class MenuWriter { //메뉴 3개를 그려줄거임
    private final String menu1 = "Game Start!";
    private final String menu2 = "Ranking";
    private final String menu3 = "Rules";
    private Font letter = new Font("Arial", Font.BOLD, 40);
    private Font title = new Font("Arial", Font.BOLD, 60);
    private Font small = new Font("Arial", Font.BOLD, 20);
    private final int size = 500;


    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, size, size);
        g.setColor(Color.black);
        g.drawRect(0, 0, size, size);

        g.setFont(title);
        //게임이름
        g.setColor(Color.red);
        g.drawString("CRASH", 140, 65); //한글 안됨
        g.setColor(Color.blue);
        g.drawString("CRASH", 144, 70); //한글 안됨
        g.setColor(Color.red);
        g.drawString("BALL ", 180, 107); //한글 안됨
        g.setColor(Color.blue);
        g.drawString("BALL ", 184, 112); //한글 안됨

        g.setColor(Color.black);
        g.setFont(small);
        g.drawString("press", 50, 220);
        g.drawString("and", 235, 220);
        g.drawString("to enter!", 380, 220);


        g.setColor(Color.red);
        g.drawString("up/down-key", 110, 220);
        g.drawString("space-bar", 275, 220);


        g.setColor(Color.black);

        g.setFont(letter);
        //메뉴1
        g.setColor(Color.red);
        g.fillRect(100, 250, 300, 60);
        g.setColor(Color.black);
        g.drawString(menu1, 130, 295);

        //메뉴2
        g.setColor(Color.gray);
        g.fillRect(100, 325, 300, 60);
        g.setColor(Color.black);
        g.drawString(menu2, 170, 370);

        //메뉴 3
        g.setColor(Color.GRAY);
        g.fillRect(100, 400, 300, 60);
        g.setColor(Color.black);
        g.drawString(menu3, 190, 445);
    }
}
