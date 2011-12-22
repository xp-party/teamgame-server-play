package models.domain;

/**
 * Created by IntelliJ IDEA.
 * User: vanger
 * Date: 22.12.11
 * Time: 16:27
 */
public class Player {
    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (!playerName.equals(player.playerName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return playerName.hashCode();
    }
}
