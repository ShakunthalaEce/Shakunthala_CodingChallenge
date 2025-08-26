package com.hexaware.cricketteammanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricketteammanagementsystem.dto.PlayerDto;
import com.hexaware.cricketteammanagementsystem.entity.Player;
import com.hexaware.cricketteammanagementsystem.exception.PlayerNotFoundException;
import com.hexaware.cricketteammanagementsystem.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayerService {
	
	@Autowired
	PlayerRepository repo;

	@Override
	public List<Player> getAllPlayers() {
		return repo.findAll();
	}

	@Override
	public Player addPlayer(PlayerDto playerDto) {
		Player player=new Player();
		
		player.setPlayer_id(playerDto.getPlayer_id());
		player.setPlayer_name(playerDto.getPlayer_name());
		player.setJersey_number(playerDto.getJersey_number());
		player.setRole(playerDto.getRole());
		player.setTotal_matches(playerDto.getTotal_matches());;
		player.setTeam_name(playerDto.getTeam_name());
		player.setCountry(playerDto.getCountry());
		player.setDescription(playerDto.getDescription());
		
		return repo.save(player);
		
	}

	@Override
	public Player getPlayerById(int id) throws PlayerNotFoundException {
		
		return repo.findById(id).orElseThrow(() -> new PlayerNotFoundException());
	}

	@Override
	public String deletePlayerById(int id) {
		repo.deleteById(id);
		return "Player deleted successfully. ";
	}

	@Override
	public String updatePlayerById(int id, PlayerDto dto) {
		Player player=repo.findById(id).orElse(null);
		player.setPlayer_name(dto.getPlayer_name());
		player.setJersey_number(dto.getJersey_number());
		player.setRole(dto.getRole());
		player.setTotal_matches(dto.getTotal_matches());;
		player.setTeam_name(dto.getTeam_name());
		player.setCountry(dto.getCountry());
		player.setDescription(dto.getDescription());
		
		repo.save(player);
		
		
		return "Player updated successfully. ";
	}

	@Override
	public List<Player> findPlayersByMinAndMaxmatches(int min, int max) {
		return repo.findPlayersByMinAndMaxmatches(min, max);
	}

}
