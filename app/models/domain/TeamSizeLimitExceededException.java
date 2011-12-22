package models.domain;

/**
 * Created by IntelliJ IDEA.
 * User: vanger
 * Date: 22.12.11
 * Time: 16:45
 */
public class TeamSizeLimitExceededException extends RuntimeException
{
    public TeamSizeLimitExceededException(Team team, int maxTeamSize) {
        super("Exceeded maximal team size (" + maxTeamSize + ") for team '" + team.getTeamId() + "'");
    }
}
