package models.domain;

/**
 * Created by IntelliJ IDEA.
 * User: vanger
 * Date: 22.12.11
 * Time: 16:49
 */
public class PlayerNotInTheTeamException extends RuntimeException {

    public PlayerNotInTheTeamException(Player player, Team team) {
        super("Player '" + player.getPlayerName() + "' not in the team '"  + team.getTeamId() + "'.");
    }
}
