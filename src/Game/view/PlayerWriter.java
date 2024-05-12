package Game.view;

import Game.model.Player;

import java.awt.*;

class PlayerWriter {
    private Player player;
    private Color player_color;

    public PlayerWriter(Player player, Color c)
    {
        this.player = player;
        player_color = c;
    }

    public Player getplayer() //플레이어 반환
    {
        return player;
    }

    public void paint(Graphics g) //플레이어의 위치를 기반으로 플레이어 그림
    {
        int radius = player.getR();

        g.setColor(player_color);
        g.fillOval(player.getX() - radius, player.getY() - radius, radius * 2, radius * 2);
    }
}
