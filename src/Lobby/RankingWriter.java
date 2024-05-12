package Lobby;

import java.awt.*;

class RankingWriter {
    private final int size = 500; //랭킹창의 크기(500*500) (사실상 어느화면이든 500으로 틀이랑 다 똑같다보면됨)
    private Font big_letter;
    private Font small_letter;
    private Font mid_letter;
    private Rank_Controller ranking;

    public RankingWriter(Rank_Controller ranking)
    {
        this.ranking = ranking;
        big_letter = new Font("Arial", Font.BOLD, 40);
        small_letter = new Font("Arial", Font.BOLD, 17);
        mid_letter = new Font("Arial", Font.PLAIN, 20);
    }

    public void paint(Graphics g) //랭킹화면 그림
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, size, size);
        g.setColor(Color.black);
        g.drawRect(0, 0, size, size);

        g.setFont(big_letter);
        g.setColor(Color.black);
        g.drawString("[Ranking]", 160, 40); //한글 안됨
        g.setFont(small_letter);
        g.drawString("(press 'BACK_SPACE' to return)", 120, 75); //한글 안됨

        g.setFont(mid_letter);
        g.drawString("It will be displayed up to the top 15", 110, 100);
        for (int i = 0; i < ranking.getlist().size(); i++)
        {
            if (i == 15) break; // 랭킹은 15등까지 표시되도록.
            g.drawString(i + 1 + ".  " + ranking.getName(i) + "  :  " + ranking.getScore(i), 50, 150 + i * 20);
        }
    }
}
