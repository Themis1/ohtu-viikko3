
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private Integer assists;
    private Integer goals;
    private Integer penalties;
    private String team;
    private Integer games;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setNatiotality(String nationality) {
        this.nationality = nationality;
    }
    public String getNationality() {
        return this.nationality;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }
    public Integer getAssists() {
        return this.assists;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }
    public Integer getGoals() {
        return this.goals;
    }

    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }
    public Integer getPenalties() {
        return this.penalties;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return this.team;
    }

    public void setGames(Integer games) {
        this.games = games;
    }
    public Integer getGams() {
        return this.games;
    }

    public Integer pisteet() {
        return this.goals + this.assists;
    }

    @Override
    public String toString() {
        return String.format("%-20s",this.name) + ", team: " + String.format("%-5s",this.team) + ", goals and assists: " + this.goals + " + " + this.assists + " = " + pisteet();
    }
      
}
