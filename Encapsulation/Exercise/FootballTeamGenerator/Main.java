package FootballTeamGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] teamInput = scan.nextLine().split(";");
        Team team = new Team(teamInput[1]);

        String[] commandTokens = scan.nextLine().split(";");
        while (!commandTokens[0].equals("END")) {

            switch (commandTokens[0]) {
                case "Add":
                    if(!commandTokens[1].equals(team.getName())) {
                        System.out.printf("Team %s does not exist.%n", commandTokens[1]);
                    } else {
                        team.addPlayer(new Player(commandTokens[2], Integer.parseInt(commandTokens[3]),
                                Integer.parseInt(commandTokens[4]), Integer.parseInt(commandTokens[5]),
                                Integer.parseInt(commandTokens[6]), Integer.parseInt(commandTokens[7])));
                    }
                    break;
                case "Remove":
                    if(!commandTokens[1].equals(team.getName())) {
                        System.out.printf("Player %s is not in %s team", commandTokens[2], team.getName());
                        commandTokens = scan.nextLine().split(";");
                        continue;
                    }
                    team.removePlayer(commandTokens[2]);
                    break;
            }

            commandTokens = scan.nextLine().split(";");
        }

    }
}
