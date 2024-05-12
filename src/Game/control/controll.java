package Game.control;

interface controll { //인터페이스 : 컨트롤러들이 구현해야하는 메소드들.

    public abstract int getX(int i); //x좌표반환

    public abstract int getY(int i); //y"반환

    public abstract void remove(int i);//i번째 원소 제거

    public abstract int getSize(); //백터의 크기(원소의 개수)반환
}
