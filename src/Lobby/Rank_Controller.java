package Lobby;

import java.util.Vector;

class Rank_Controller {
    private Vector<Rank> list;

    public Rank_Controller()
    {
        list = new Vector<>();
    }

    public void add(String name, int score)
    {
        Rank t = new Rank(name, score);
        list.add(t);
    }

    public Vector<Rank> getlist()
    {
        return list;
    }

    public String getName(int i)
    {
        return list.get(i).getName();
    }

    public int getScore(int i)
    {
        return list.get(i).getScore();
    }
}
