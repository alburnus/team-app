package pl.alburnus.team;

public class Team {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + name + '\'' +
                '}';
    }
}
