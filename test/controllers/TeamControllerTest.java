package controllers;

import models.domain.Player;
import models.domain.PlayerNotInTheTeamException;
import models.domain.Team;
import models.domain.TeamSizeLimitExceededException;
import org.junit.Before;
import org.junit.Test;
import play.test.UnitTest;

/**
 * Created by IntelliJ IDEA.
 * User: vanger
 * Date: 22.12.11
 * Time: 16:20
 */
public class TeamControllerTest extends UnitTest {

    private int maxAmountOfPlayers;
    private Team teamController;
    private Player player;

    @Before
    public void setUp() throws Exception {
        maxAmountOfPlayers = 2;
        teamController = new Team(maxAmountOfPlayers);
        player = new Player("Vasya");
    }

    @Test
    public void testCreationOfTeam() {
        teamController.addPlayerToTeam(player);
        int playerNumber = teamController.getPlayerNumberFor(player);
        assertEquals("player number of first player should be 1", playerNumber, 1);
    }

    @Test
    public void testAddingOfTheSamePlayerTwice() throws Exception {
        teamController.addPlayerToTeam(player);
        teamController.addPlayerToTeam(player);

        int playersAmount = teamController.getMaximalTeamSize();
        assertEquals("adding of the same player should change size of team", playersAmount, 1);
    }

    @Test(expected = TeamSizeLimitExceededException.class)
    public void testExceptionRaisedWhenCommandSizeLimitExceeded() throws Exception {
        for (int i = 0; i <= maxAmountOfPlayers; i++) {
            teamController.addPlayerToTeam(new Player("" + i));
        }
    }

    @Test(expected = PlayerNotInTheTeamException.class)
    public void testExceptionRaisedIfPlayerNotInTheTeam() throws Exception {
        teamController.getPlayerNumberFor(player);
    }
}
