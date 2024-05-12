package Game.view;

import Game.model.*;
import Game.control.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameController {
    private Random random;
    private int level; //입력받은 난이도
    private final int box_size = 500;   //박스크기
    private final int player_size = 20; //플레이어 반지름 20이 적당

    private Game.model.Box box;
    private Score score;
    private Player player;
    private AppliedItem apply;

    private Ball_Controller ball_controller;
    private Bullet_Controller bullet_controller;
    private item_Controller item_controller;


    private itemWriter iw;
    private PlayerWriter gw;
    private BulletWriter bw;
    private BallWriter ballWriter;
    private BoxWriter xw;
    private AnimationWriter writer;


    private long beforeTime = System.currentTimeMillis(), afterTime; //총알생성시간 측정
    private long ball_beforeTime = System.currentTimeMillis(), ball_afterTime; //공 생성시간 측정용
    private long item_beforeTime = System.currentTimeMillis(), item_afterTime; //아이템생성시간측정용
    //아이템지속시간 측정용
    private long item_num_beforeTime, item_num_afterTime;
    private long item_double_beforeTime, item_double_afterTime;

    //생성자
    public GameController(int l)
    {
        level = l;
        random = new Random();
        box = new Game.model.Box(box_size);
        score = new Score();
        player = new Player(250, box_size, player_size);
        apply = new AppliedItem();

        ball_controller = new Ball_Controller(box);
        bullet_controller = new Bullet_Controller();
        item_controller = new item_Controller();

        iw = new itemWriter(item_controller);
        gw = new PlayerWriter(player, Color.MAGENTA);
        bw = new BulletWriter(bullet_controller, Color.yellow);
        ballWriter = new BallWriter(ball_controller.getBall_list(), Color.black);
        xw = new BoxWriter(box, score);

        writer = new AnimationWriter(iw, ballWriter, xw, bw, gw, box_size + 40, score);

    }

    public void dispose() //창 종료
    {
        writer.dispose();
    }

    public void shot()  //일정시간마다 총알 생성 + 아이템 적용중이면 해당되는 총알 만들도록 명령
    {
        afterTime = System.currentTimeMillis();
        if ((afterTime - beforeTime) >= 60)  //생성속도
        {
            int t = 0;
            boolean c = true;
            for (int i = 0; i < apply.getNumberOfBullet(); i++)
            {
                if (apply.getDoubleDamage()) //두배 적용중이면
                    bullet_controller.add(player, t, 2);
                else
                    bullet_controller.add(player, t, 1);

                if (c)
                {
                    if (t < 0) t *= -1;
                    t += 10;
                    c = false;
                } else
                {
                    c = true;
                    t *= -1;
                }
            }
            beforeTime = System.currentTimeMillis();
        }
    }

    public void bullet_delete() //화면 나간 총알 삭제
    {
        for (int i = 0; i < bullet_controller.getSize(); i++)
        {
            if (bullet_controller.getBulletlist().get(i).getY() < 0)
            {
                bullet_controller.remove(i);
                i--;
            }
        }
    }

    public void hit() //맞은 총알 삭제하고 체력없는 공 삭제 및 점수증가
    {
        for (int i = 0; i < ball_controller.getSize(); i++)
        {
            for (int j = 0; j < bullet_controller.getSize(); j++)
            {
                //그냥 피타고라스 계산
                if (Math.pow(ball_controller.getX(i) - bullet_controller.getX(j), 2) + Math.pow(ball_controller.getY(i) - bullet_controller.getY(j), 2) <= Math.pow(ball_controller.getI(i).getR() + bullet_controller.getI(j).getR(), 2))
                {
                    ball_controller.getI(i).hit(bullet_controller.getD(j));
                    bullet_controller.remove(j); //총알삭제
                    if (ball_controller.getBall_list().get(i).getHp() <= 0)
                    {
                        score.add_score(ball_controller.getI(i).getOHp());
                        ball_controller.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }
    }

    public void add() //난이도에 따라 다른 일정시간마다 공 생성
    {
        ball_afterTime = System.currentTimeMillis();
        if (ball_afterTime - ball_beforeTime > level)
        {
            ball_controller.add();
            ball_beforeTime = System.currentTimeMillis();
        }

    }

    public boolean is_gameover() //player가 공에 닿았으면 true 아니면 false.
    {
        for (Ball i : ball_controller.getBall_list())
        {
            //그냥 피타고라스 계산
            if (Math.pow(i.getX() - player.getX(), 2) + Math.pow(i.getY() - player.getY(), 2) <= Math.pow(i.getR() + player.getR(), 2)) //피타고라스
            {
                JOptionPane.showMessageDialog(null, "GAME OVER");
                dispose();
                return true;
            }
        }
        return false;
    }


    private void delay(int how_long) //프로그램 how_long/1000 초만큼 정지
    {
        try
        {
            Thread.sleep(how_long);
        } catch (InterruptedException e)
        {
        }
    }


    public void make_item() // 일정시간(10초)마다 랜덤한 아이템 생성
    {
        item_afterTime = System.currentTimeMillis();
        if (item_afterTime - item_beforeTime >= 10000)
        {
            item_controller.add(random, box.sizeOf());
            item_beforeTime = System.currentTimeMillis();
        }
    }

    public void item_contact() //아이템과 플레이어가 닿은경우(피타고라스 통해 거리계산), 아이템을 삭제해주고, 해당 아이템을 적용시킴
    {
        for (int i = 0; i < item_controller.getSize(); i++)
        {
            //그냥 피타고라스 계산
            if (Math.pow(item_controller.getX(i) - player.getX(), 2) + Math.pow(item_controller.getY(i) - player.getY(), 2) <= Math.pow(12 + player.getR(), 2))
            {
                if (item_controller.getEffect(i) == 1)
                {
                    apply.applyDamage();
                    item_double_beforeTime = System.currentTimeMillis();
                } else
                {
                    apply.applyNumber(item_controller.getEffect(i));
                    item_num_beforeTime = System.currentTimeMillis();
                }
                item_controller.remove(i);
                i--;
            }
        }
    }

    public void item_continue()  // 아이템이 적용중이라면, 지속시간을 줄여주고, 지속이간이 끝난경우 아이템효과를 없앰
    {
        if (apply.getNumberOfBullet() != 1)
        {
            item_num_afterTime = System.currentTimeMillis();
            if (item_num_afterTime - item_num_beforeTime >= 1000)
            {
                item_num_beforeTime = System.currentTimeMillis();
                apply.min_numTime();
                if (apply.get_time_number())
                {
                    apply.resetNumber();
                }
            }
        }

        if (apply.getDoubleDamage())
        {
            item_double_afterTime = System.currentTimeMillis();
            if (item_double_afterTime - item_double_beforeTime >= 1000)
            {
                item_double_beforeTime = System.currentTimeMillis();
                apply.min_doubleTime();
                if (apply.get_time_double())
                {
                    apply.resetDamage();
                }
            }
        }
    }

    //game() : 시작하자마자 공을 하나 생성-> (반복문): 아이템 생성메소드호출(시간이 지났다면 생성)->공 생성메소드호출(시간이 지났다면 생성)
    //           ->프로그램 잠깐정지-> 총알 생성메소드호출(시간이 지났다면 생성)-> 총알움직임메소드호출->아이템움직임메소드호출->화면나간총알처리메소드호출->맞은총알처리메소드호출
    //           ->아이템닿았는지확인메소드호출->아이템지속시간확인메소드호출->공움직임메소드호출->게임오버확인메소드호출(true라면, game()메소드는 현재 점수를 반환하며 메소드종료==게임끝)->repaint();
    public int game()
    {
        int painting_delay = 15;
        ball_controller.add(); //시작하자마자 나오는 공
        while (true)
        {
            make_item();

            add(); //공 추가
            delay(painting_delay);

            shot(); // 시간마다 총알생성

            bullet_controller.move(); //총알을 움직임
            item_controller.move(box);
            bullet_delete();//화면나간총알 처리
            hit();//맞은총알 처리
            item_contact();
            item_continue();

            ball_controller.move(); //공움직임(튕기는거는 move에서 처리됨)
            if (is_gameover())
            {
                return score.getScore();
            }
            writer.repaint();
        }
    }
}
