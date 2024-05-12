package Lobby;
import Game.view.*;

import javax.swing.*;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Menu_Controller {
    private int score;
    private int level;
    private Select select;
    private LobbyWriter lobbyWriter;

    private Rank_Controller ranking;
    private RankingWriter rankingWriter;

    GameController game_controller;

    public Menu_Controller()
    {
        select = new Select();
        ranking = new Rank_Controller();
        rankingWriter = new RankingWriter(ranking);
        lobbyWriter = new LobbyWriter(540, select, rankingWriter);
    }

    //게임 첫실행시 파일만듦(있는경우 유지) (입출력은 아무것도 안함)
    public void make_rank_file()
    {
        PrintWriter pw = null;
        try
        {
            pw = new PrintWriter(new FileWriter("rank.txt", true));
        } catch (IOException e)
        {
            e.printStackTrace(); //콘솔에 오류 표시하는코드임. 나중에 없애도됨.
            JOptionPane.showMessageDialog(null, "랭킹 파일생성 중 오류가 발생했습니다.");
        } finally
        {
            if (pw != null) pw.close();
        }
    }

    //게임시작시 파일을 읽어서 랭킹벡터에 추가 + 랭킹백터를 정렬 함(정렬은 원래 랭킹 등록시에 진행되는데 혹시나 누군가 txt파일을 수정한 뒤 바로 랭킹을 보면 정렬이 안되기때문에 정렬되게 해둠)
    //랭킹파일을 찾을수없는경우(filenotfoundex), 랭킹txt가 이상하게 수정된경우(Numberformatexception) 메시지를 표시해줌.

    public void load_rank_file()
    {
        BufferedReader br = null;

        try
        {
            br = new BufferedReader(new FileReader("rank.txt"));
            try
            {
                while (br.ready())
                {
                    ranking.add(br.readLine(), Integer.parseInt(br.readLine()));
                }
            } catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "랭킹파일에 잘못된 부분이 있습니다. 랭킹이 정상적으로 로드되지 않았을 수도 있습니다.");
            } catch (IOException e)
            {
                JOptionPane.showMessageDialog(null, "저장된 랭킹을 읽어올수없습니다.");
            }

        } catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "저장된 랭킹파일을 찾을 수 없습니다.");
        } finally
        {
            if (br != null)
                try
                {
                    br.close();
                } catch (IOException e)
                {
                }
        }
        Collections.sort(ranking.getlist(), new Comparator<Rank>() {
            public int compare(Rank a, Rank b)
            {
                return b.getScore() - a.getScore();
            }
        });

    }

    //기존 파일에 새로 추가되어 정렬된 랭킹벡터를 덮어씀 // 오류발생여부와 상관없이 file.close()해줌
    public void write_rank_file()
    {
        PrintWriter pw = null;
        try
        {
            pw = new PrintWriter(new FileWriter("rank.txt", false));

            Vector<Rank> temp = ranking.getlist();
            for (int i = 0; i < temp.size(); i++)
            {
                pw.println(temp.get(i).getName());
                pw.println(temp.get(i).getScore());
            }
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            //	e.printStackTrace(); //콘솔에 오류 표시하는코드임. 나중에 없애도됨.
            JOptionPane.showMessageDialog(null, "랭킹 저장 중 오류가 발생했습니다. 저장이 정상적으로 되지 않았습니다.");
        } finally
        {
            if (pw != null) pw.close();
        }
    }

    public int level_input() //난이도를 입력받음 1 2 3외 입력 안되도록 예외처리됨
    {
        String s;
        while (true)
        {
            s = JOptionPane.showInputDialog("난이도 입력(1:쉬움 2:중간 3:어려움)");
            if (s == null)
            {
                return 0;
            }
            if (s.length() == 1)
            {
                if (s.charAt(0) == '1') break;
                if (s.charAt(0) == '2') break;
                if (s.charAt(0) == '3') break;
            }
            JOptionPane.showMessageDialog(null, "1 2 3 중 하나를 입력하세요.");
        }
        level = Integer.parseInt(s);
        switch (level)
        {
            case 1:
                level = 6000;
                break;
            case 2:
                level = 4000;
                break;
            case 3:
                level = 3000;
        }

        return level;
    }

    public void add_rank() //이름을 입력받고 랭킹백터에 랭킹을 추가 및 정렬 및 파일에 랭킹리스트를 덮어씀
    // 15자 초과, 글자수 0, 영어&숫자 외 입력 예외처리
    // 취소누를시 랭킹등록취소 예외처리
    {
        String s;
        char t;
        boolean c;
        while (true)
        {
            c = true;
            s = JOptionPane.showInputDialog("랭킹에 등록할 이름을 입력하세요(공백없는15글자 이하의 영문 및 숫자) : ");
            if (s == null)//취소누르거나 창닫기누른경우
            {
                JOptionPane.showMessageDialog(null, "랭킹등록을 취소합니다.");
                return;
            }
            if (s.length() > 15)
            {
                JOptionPane.showMessageDialog(null, "15글자 초과입니다.");
                continue;
            }
            if (s.length() == 0)
            {
                JOptionPane.showMessageDialog(null, "최소 1글자 이상 입력해주세요.");
                continue;
            }
            //영어나 숫자외의 문자가 있는지 확인
            for (int i = 0; i < s.length(); i++)
            {
                t = s.charAt(i);
                if ((48 <= t && t <= 57) || (65 <= t && t <= 90) || (97 <= t && t <= 122))
                {
                    continue;
                }
                c = false;
                break;
            }
            if (!c)
            {
                JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
                continue;

            }
            ranking.add(s, score);
            Collections.sort(ranking.getlist(), new Comparator<Rank>() {
                public int compare(Rank a, Rank b)
                {
                    return b.getScore() - a.getScore();
                }
            });
            write_rank_file();
            //여기서 파일쓰기./////////////////////////////////////////////////////////////////////////////////

            break;
        }
    }

    public void run() //가장 처음 실행할 메소드.
    {
        make_rank_file();
        load_rank_file();
        while (true)
        {
            if (select.get())
            {
                select.reset(); //이거 안하면 스페이스 계속 눌러진 상태로 인식됨.
                if (select.getWhere() == 1)
                {
                    int t = level_input();
                    if (t == 0) continue;
                    lobbyWriter.dispose();
                    game_controller = new GameController(t);
                    score = game_controller.game();
                    lobbyWriter.show();
                    //game_controller = null;
                    add_rank();
                    //score로 랭킹 반영하기
                } else if (select.getWhere() == 2)
                {
                    lobbyWriter.set_screen(2);
                } else if (select.getWhere() == 3)
                {
                    lobbyWriter.set_screen(3);
                }
            }
            lobbyWriter.repaint();

        }
    }
}
