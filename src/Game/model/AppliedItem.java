package Game.model;

public class AppliedItem { //아이템 적용여부
    private int NumberOfBullet; //한번에 발사되야하는 총알개수
    private int time_number; //item_increase의 지속시간

    private boolean DoubleDamage;//데미지2배 여부
    private int time_double;//item_double의 지속시간

    public AppliedItem()
    {
        NumberOfBullet = 1; //기본 1
        DoubleDamage = false; //기본 두배x
    }

    public int getNumberOfBullet() //한번에 발사되어야하는 총알 개수 반환
    {
        return NumberOfBullet;
    }

    public boolean getDoubleDamage() //더블뎀지 총알이 적용중인지 여부 반환
    {
        return DoubleDamage;
    }

    public void applyNumber(int num) //NumberOfBullet을 num으로 변경 및 지속시간 5초로 설정
    {
        time_number = 5;//////////아이템 적용시간
        NumberOfBullet = num;
    }

    public void applyDamage() // DoubleDamage를 true로 변경 및 지속시간 5초로 설정
    {
        time_double = 5;
        DoubleDamage = true;
    }

    public void resetNumber() //NumberOfBullet와 time_number 기본값으로 변경
    {
        NumberOfBullet = 1;
        time_number = 0;
    }

    public void resetDamage() //DoubleDamage와 time_double 기본값으로 변경
    {
        DoubleDamage = false;
        time_double = 0;
    }

    public void min_numTime() //지속시간 1감소
    {
        time_number--;
    }

    public void min_doubleTime()//지속시간 1감소
    {
        time_double--;
    }

    public boolean get_time_number() //NumberOfBullet의 지속시간이 끝났는지 여부
    {
        return time_number <= 0;
    }

    public boolean get_time_double() //DoubleDamage의 지속시간이 끝났는지 여부
    {
        return time_double <= 0;
    }

}
