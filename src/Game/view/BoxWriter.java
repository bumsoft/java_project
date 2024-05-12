package Game.view;

import Game.model.Score;

import java.awt.*;

class BoxWriter //게임 틀 그려줌 (흰색으로 칠하고, 테두리는 검정으로)
{
    private Score score;
    private Font sletter; //폰트(score표시용)
    private Game.model.Box box;

    public BoxWriter(Game.model.Box b, Score score)
    {
        box = b;
        this.score = score;
        sletter = new Font("Arial", Font.BOLD, 20);
    }

    public int sizeOf()//박스사이즈반환
    {
        return box.sizeOf();
    }

    public void paint(Graphics g) // 흰색으로 칠하고, 테두리는 검정으로 그림 + 점수를 표시해줌
    {
        int size = box.sizeOf();
        g.setColor(Color.white);
        g.fillRect(0, 0, size, size);
        g.setColor(Color.black);
        g.drawRect(0, 0, size, size);

        g.setColor(Color.black);
        g.setFont(sletter);
        g.drawString("Game.model.Score:" + Integer.toString(score.getScore()), 5, 30);
    }
}
