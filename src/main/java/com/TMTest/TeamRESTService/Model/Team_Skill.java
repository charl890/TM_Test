package com.TMTest.TeamRESTService.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "team", schema = "TM_Test")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team_Skill implements Serializable {

	@Id
	private Long ID;

	@Column(name = "Team_ID", nullable = false)
	private String team_ID;

	@Column(name = "Skill", nullable = false)
	private String skill;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getTeam_ID() {
		return team_ID;
	}

	public void setTeam_ID(String team_ID) {
		this.team_ID = team_ID;
	}

	public Team_Skill(String team_ID, String skill) {
		this.team_ID = team_ID;
		this.skill = skill;
	}
	
	public Team_Skill() {
	}

	@Override
    public String toString() {
        return "Team{" +
				"TEAM_ID='" + this.team_ID + "\'," +
				"SKILL='" + this.skill + "\'" + 
                "}";
    }
}
