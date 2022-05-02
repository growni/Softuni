package FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if(statValidation(endurance)) {
            this.endurance = endurance;
        } else {
            System.out.println("Endurance should be between 0 and 100");
        }
    }

    private void setSprint(int sprint) {
        if(statValidation(sprint)) {
            this.sprint = sprint;
        } else {
            System.out.println("Sprint should be between 0 and 100");
        }
    }

    private void setDribble(int dribble) {
        if(statValidation(dribble)) {
            this.dribble = dribble;
        } else {
            System.out.println("Dribble should be between 0 and 100");
        }
    }

    private void setPassing(int passing) {
        if(statValidation(passing)) {
            this.passing = passing;
        } else {
            System.out.println("Passing should be between 0 and 100");
        }
    }

    private void setShooting(int shooting) {
        if(statValidation(shooting)) {
            this.shooting = shooting;
        } else {
            System.out.println("Shooting should be between 0 and 100");
        }
    }

    public String getName() {
        return name;
    }

    public double overallSkillLevel() {
        return (double)(endurance + sprint + dribble + passing + shooting) / 5;
    }

    private boolean statValidation(int stat) {
        if (stat < 0 || stat > 100) {
            return false;
        }
        return true;
    }
}
