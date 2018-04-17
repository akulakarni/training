/**
 * 
 */
package com.pkma.spring.model;

import java.io.Serializable;
public class Player implements Serializable {

    private static final long serialVersionUID = 3648887465910631637L;
    public Integer id;
    public String name;
    public Integer age;
    public String club;
    public String position;
    public String country;
    public Integer jerseyNumber;
    public Integer goals;
    public Integer assists;

    public Player() {

    }

    public Player(final Integer id, final String name, final Integer age, final String club, final String position,
            final String country, final Integer jerseyNumber, final Integer goals, final Integer assists) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.club = club;
        this.position = position;
        this.country = country;
        this.jerseyNumber = jerseyNumber;
        this.goals = goals;
        this.assists = assists;
    }

    public Integer getId() {
        return id;
    }
    public void setId(final Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(final Integer age) {
        this.age = age;
    }
    public String getClub() {
        return club;
    }
    public void setClub(final String club) {
        this.club = club;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(final String position) {
        this.position = position;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(final String country) {
        this.country = country;
    }
    public Integer getJerseyNumber() {
        return jerseyNumber;
    }
    public void setJerseyNumber(final Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
    public Integer getGoals() {
        return goals;
    }
    public void setGoals(final Integer goals) {
        this.goals = goals;
    }
    public Integer getAssists() {
        return assists;
    }
    public void setAssists(final Integer assists) {
        this.assists = assists;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((club == null) ? 0 : club.hashCode());
        result = prime * result + ((jerseyNumber == null) ? 0 : jerseyNumber.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (club == null) {
            if (other.club != null) {
                return false;
            }
        } else if (!club.equals(other.club)) {
            return false;
        }
        if (jerseyNumber == null) {
            if (other.jerseyNumber != null) {
                return false;
            }
        } else if (!jerseyNumber.equals(other.jerseyNumber)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", age=" + age + ", club=" + club + ", position=" + position
                + ", country=" + country + ", jerseyNumber=" + jerseyNumber + ", goals=" + goals + ", assists="
                + assists + "]";
    }

}
