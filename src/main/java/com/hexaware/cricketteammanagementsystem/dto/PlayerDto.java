package com.hexaware.cricketteammanagementsystem.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PlayerDto {
	
	@Max(20)
	private int player_id;
	
	@Pattern(regexp = "^[A-Z].*[a-z]$")
	private String player_name;
	
	@Min(1) @Max(20)
	private int jersey_number;
	
	@NotEmpty
	@Pattern(regexp = "Batsman|Bowler|All-Rounder|Wicket-Keeper")
	private String role;
	
	@NotNull
	private int total_matches;
	
	@NotEmpty
	private String team_name;
	
	@Pattern(regexp = "^[A-Z].*[a-z]$")
	private String country;
	
	@NotEmpty
	private String description;
	
	public PlayerDto() {}
	public PlayerDto(int player_id, String player_name, int jersey_number, String role, int total_matches,
			String team_name, String country, String description) {
		super();
		this.player_id = player_id;
		this.player_name = player_name;
		this.jersey_number = jersey_number;
		this.role = role;
		this.total_matches = total_matches;
		this.team_name = team_name;
		this.country = country;
		this.description = description;
	}
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public int getJersey_number() {
		return jersey_number;
	}
	public void setJersey_number(int jersey_number) {
		this.jersey_number = jersey_number;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getTotal_matches() {
		return total_matches;
	}
	public void setTotal_matches(int total_matches) {
		this.total_matches = total_matches;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "PlayerDto [player_id=" + player_id + ", player_name=" + player_name + ", jersey_number=" + jersey_number
				+ ", role=" + role + ", total_matches=" + total_matches + ", team_name=" + team_name + ", country="
				+ country + ", description=" + description + "]";
	}
	
	
}
