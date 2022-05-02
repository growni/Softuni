package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {
        boolean isRemoved = false;
        for (Player player : players) {
            if(player.getName().equals(name)) {
                players.remove(player);
                isRemoved = true;
            }
        }
        if(!isRemoved) {
            System.out.printf("Player %s is not in %s team.", name, this.name);
        }
    }

    public double getRating () {
        double avgRating = 0;
        for (Player player : players) {
            avgRating += player.overallSkillLevel();
        }
        return avgRating / players.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %f", this.name, getRating()));
        return sb.toString();
    }
}
