package Game.view;

import Game.model.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//AnimationWriter의 경우, KeyEvent와 KeyListener 컴포넌트를 사용한 keyPressed(KeyEvent e)메소드, dispose(), keyPressed(KeyEvent e) 3개만 설명하면 될듯함
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class AnimationWriter extends JPanel { //위의 자잘한 writer들의 paint()를 여기의 paintComponent에서 호출해줄거임

    private BoxWriter box_writer;
    private BulletWriter bullet_writer;
    private PlayerWriter player_writer;
    private BallWriter ball_writer;
    private itemWriter item_writer;

    JFrame my_frame;

    AnimationWriter(itemWriter iw, BallWriter bw, BoxWriter b, BulletWriter l, PlayerWriter gw, int size, Score score)
    {
        item_writer = iw;
        box_writer = b;
        bullet_writer = l;
        player_writer = gw;
        ball_writer = bw;

        my_frame = new JFrame();
        my_frame.getContentPane().add(this);
        my_frame.setTitle("Crash Game.model.Ball");
        my_frame.setSize(size - 23, size);
        my_frame.setVisible(true);
        my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫으면 종료


        //Key이벤트를 처리하기위해 KeyEvent와 KeyListener 컴포넌트를 사용.
        my_frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) // 좌/우/스페이스(스킬)키가 입력되었을때 플레이어를 좌/우 이동시키는 함수 호출하고 스페이스시에 모든 공을 여기서 삭제해줌
            /////////////////////////////////// ++ 플레이어가 벽밖으로 못나가게 예외처리한 부분이 여기임
            {
                int k = e.getKeyCode();  //왼:37 오:39 스페이스:32
                //System.out.println(k); 이걸로 키 확인
                if (k == 37)
                {
                    if (gw.getplayer().getX() - gw.getplayer().getMovement() > gw.getplayer().getR())  //15씩 이동하기에.
                    {
                        gw.getplayer().left();
                    } else if (gw.getplayer().getX() - gw.getplayer().getMovement() <= gw.getplayer().getR())
                    {
                        gw.getplayer().setX(gw.getplayer().getR());
                    }
                } else if (k == 39)
                {
                    if (gw.getplayer().getX() + gw.getplayer().getMovement() < b.sizeOf() - gw.getplayer().getR())
                    {
                        gw.getplayer().right();
                    } else if (gw.getplayer().getX() + gw.getplayer().getMovement() >= b.sizeOf() - gw.getplayer().getR())
                    {
                        gw.getplayer().setX(b.sizeOf() - gw.getplayer().getR());
                    }
                } else if (k == 32)
                {
                    if (bw.getBall_list().size() > 0 && score.min_score(150)) bw.getBall_list().clear(); //사용할 점수
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

    public void dispose() //JFrame 창 종료
    {
        my_frame.dispose();
    }

    public void paintComponent(Graphics g)
    {
        box_writer.paint(g);
        bullet_writer.paint(g);
        player_writer.paint(g);
        ball_writer.paint(g);
        item_writer.paint(g);
    }
}
