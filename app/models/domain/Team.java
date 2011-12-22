package models.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vanger
 * Date: 22.12.11
 * Time: 16:19
 */
public class Team
{
    private final String teamId;
    private final int maximalTeamSize;
    private final List<Player> players;

    public Team(int maximalTeamSize) {
        teamId = "team0";
        this.maximalTeamSize = maximalTeamSize;
        players = new ArrayList<Player>(this.maximalTeamSize);
    }

    public int getPlayerNumberFor(Player player) {
        if (players.contains(player)) {
            return players.indexOf(player) + 1; // used +1 because numbers in array starts from 0
        } else {
            throw new PlayerNotInTheTeamException(player, this);
        }
    }

    public void addPlayerToTeam(Player player) {
        if (players.contains(player)) {
            return;
        }

        if (isTeamSizeExceeded()) {
            throw new TeamSizeLimitExceededException(this, maximalTeamSize);
        }

        players.add(player);
    }

    public boolean isTeamSizeExceeded() {
        return players.size() == maximalTeamSize;
    }


    public int getMaximalTeamSize() {
        return players.size();
    }

    public String getTeamId() {
        return teamId;
    }
}
