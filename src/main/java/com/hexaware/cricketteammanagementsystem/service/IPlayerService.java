package com.hexaware.cricketteammanagementsystem.service;

import java.util.List;

import com.hexaware.cricketteammanagementsystem.dto.PlayerDto;
import com.hexaware.cricketteammanagementsystem.entity.Player;
import com.hexaware.cricketteammanagementsystem.exception.PlayerNotFoundException;

public interface IPlayerService {
	public List<Player>getAllPlayers();
	public Player addPlayer(PlayerDto playerDto);
	public Player getPlayerById(int id)throws PlayerNotFoundException;;
	public String updatePlayerById(int id, PlayerDto dto);
	public String deletePlayerById(int id);
}
