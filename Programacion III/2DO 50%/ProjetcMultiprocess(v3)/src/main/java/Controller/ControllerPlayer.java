package Controller;

import Model.Player;
import Utilities.JsonStorageUtilities;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerPlayer{
    JsonStorageUtilities json;
    List<Player> players;
    List<Player> playersClone = new ArrayList<>();

    public ControllerPlayer() {
        json = new JsonStorageUtilities();
        players = json.readContentFromFile();
        playersClone.addAll(players);
    }

    public void initialisePlayers(){
        for (Player aux: players) {
            aux.setFlag(true);
            aux.calculateHour();
            aux.rollDice();
            aux.calculateWaitingTime();
        }
    }


    public List<Player> playerRankings(){
        return playersClone.stream()
                .sorted(Comparator.comparingInt(Player::getNumberGames))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }

}
