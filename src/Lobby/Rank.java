package Lobby;

class Rank //랭크. 유저이름과 점수를 가짐
{
    private String name;
    private int score;

    public Rank(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }
}
