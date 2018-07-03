package com.TMTest.TeamRESTService.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "task", schema = "TM_Test")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task implements Serializable {

	@Id
	private Long ID;

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

	@Column(name = "Task_ID", nullable = false)
	private String task_ID;

	@Column(name = "Skill", nullable = false)
	private String skill;

	public String getTask_ID() {
		return task_ID;
	}

	public void setTask_ID(String task_ID) {
		this.task_ID = task_ID;
	}

	public Task(String task_ID, String skill) {
		this.task_ID = task_ID;
		this.skill = skill;
	}
	
	public Task() {
	}

	@Override
    public String toString() {
		return "Task{" + "TASK_ID='" + this.task_ID + "\'," + "SKILL='" + this.skill + "\'" +
                "}";
    }
}
