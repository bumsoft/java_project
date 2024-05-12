package Game.model;

public class Score {
    private int score = 0;

    public void add_score(int s) // s만큼 score증가
    {
        score += s;
    }

    public boolean min_score(int s) //점수가 s이상인지 여부 반환(스킬사용을 위해)
    {
        if (score - s >= 0)
        {
            score -= s;
            return true;
        } else return false;
    }

    public int getScore() //score반환
    {
        return score;
    }
}
