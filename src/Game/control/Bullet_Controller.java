package Game.control;

import Game.model.*;

import java.util.Vector;

public class Bullet_Controller implements controll {
    private Vector<Bullet> bullet_list;

    public Bullet_Controller()
    {
        bullet_list = new Vector<>();
    } //클래스 생성시 백터도 같이 생성

    public void add(Player player, int a, int whatBullet)   //플레이어와 총알의 종류를 매개변수로 받아서 해당하는 총알을 플레이어위치에 생성해서 백터에 추가)
    {
        Bullet t;
        if (whatBullet == 1)
        {
            t = new NormalBullet(player.getX() + a, player.getY());
        } else
        {
            t = new DoubleDamageBullet(player.getX() + a, player.getY());
        }
        bullet_list.add(t);
    }

    public void move() //백터의 모든 총알의 move()메소드를 실행시킴
    {
        for (Bullet i : bullet_list)
        {
            i.move();
        }
    }

    public int getD(int i) //i위치의 총알의 데미지 반환
    {
        return bullet_list.get(i).getDamage();
    }

    public Vector<Bullet> getBulletlist()
    {
        return bullet_list;
    }

    public int getX(int i) //i위치의 총알 x좌표반환
    {
        return bullet_list.get(i).getX();
    }

    public int getY(int i)
    {
        return bullet_list.get(i).getY();
    }

    public int getSize() //백터의 크기(원소개수)
    {
        return bullet_list.size();
    }

    public void remove(int i) //i위치의 총알(원소) 삭제
    {
        bullet_list.remove(i);
    }

    public Bullet getI(int i)//i위치의 총알 반환
    {
        return bullet_list.get(i);
    }
}
