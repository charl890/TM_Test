package com.TMTest.TeamRESTService.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "team", schema = "TM_Test")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team implements Serializable {

	@Id
	private Long ID;

	@Column(name = "Team_ID", nullable = false)
	private String team_ID;

	public String getTeam_ID() {
		return team_ID;
	}

	public void setTeam_ID(String team_ID) {
		this.team_ID = team_ID;
	}

	public Team(String team_ID) {
		this.team_ID = team_ID;
	}
	
	public Team() {
	}

	@Override
    public String toString() {
        return "Team{" +
				"TEAM_ID='" + this.team_ID + "\'" + 
                "}";
    }
}
