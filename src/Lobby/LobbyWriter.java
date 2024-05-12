package Lobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//LobbyWriter paintcomponent에서 어느 화면을 보여줄지 제어함
class LobbyWriter extends JPanel {

    private MenuWriter menu = new MenuWriter();
    private JFrame my_frame;
    private SelectWriter menu_selectWriter;
    private RankingWriter rankingWriter;
    private RulesWriter ruleswriter;

    private int screen = 1; //메뉴 or 랭킹 화면.

    LobbyWriter(int size, Select select, RankingWriter rankingWriter)
    {
        menu_selectWriter = new SelectWriter(select);
        ruleswriter = new RulesWriter();
        this.rankingWriter = rankingWriter;


        my_frame = new JFrame();
        my_frame.getContentPane().add(this);
        my_frame.setTitle("Game!");
        my_frame.setSize(size - 23, size);
        my_frame.setVisible(true);
        my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫으면 종료
        my_frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                int k = e.getKeyCode();//스페이스:32
                // System.out.println(k);// 이걸로 키 확인
                if (screen == 1 && k == 38)//위 38
                {
                    select.up();
                } else if (screen == 1 && k == 40)//아래 40
                {
                    select.down();
                } else if (screen == 1 && k == 32)//스페이스
                {
                    select.spacebar();
                } else if (k == 8) //백스페이스
                {
                    screen = 1;
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
            }

            @Override
            public void keyTyped(KeyEvent e)
            {
            }
        });
    }


    public int get_screen()
    {
        return screen;
    }

    public void set_screen(int i)
    {
        screen = i;
    }

    public void dispose() //메뉴화면을 안보이게.(게임이 호출됐을때 게임창과 메뉴창 두개가 떠있으면 이상하니 메뉴창은 안보이게하는용)
    {
        my_frame.setVisible(false);
    }

    public void show() //메뉴화면 보이게(게임끝난뒤)
    {
        my_frame.setVisible(true);
    }

    public void paintComponent(Graphics g) //screen이 1이면 메뉴화면, 2이면 랭킹화면, 3이면 규칙화면
    {
        if (screen == 1)
        {
            menu.paint(g);
            menu_selectWriter.paint(g);
        } else if (screen == 2)
        {
            rankingWriter.paint(g);
        } else if (screen == 3)
        {
            ruleswriter.paint(g);
        }
    }
}
