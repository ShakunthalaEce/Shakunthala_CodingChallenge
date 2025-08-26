package com.hexaware.cricketteammanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricketteammanagementsystem.dto.PlayerDto;
import com.hexaware.cricketteammanagementsystem.entity.Player;
import com.hexaware.cricketteammanagementsystem.exception.PlayerNotFoundException;
import com.hexaware.cricketteammanagementsystem.service.IPlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PlayerController {
	
	@Autowired
	IPlayerService service;

	@GetMapping("/players")
	public List<Player>getAllPlayers()
	{
		return service.getAllPlayers();
	}
	
	@PostMapping("/players")
	public Player addPlayer(@RequestBody @Valid PlayerDto playerDto)
	{
		return service.addPlayer(playerDto);
	}
	
	@GetMapping("/players/{id}")
	public Player getPlayerById(@PathVariable int id)throws PlayerNotFoundException 
	{
		return service.getPlayerById(id);
	}
	
	@PutMapping("/players/{id}")
	public String updatePlayerById(@PathVariable int id,@RequestBody PlayerDto playerDto)
	{
		return service.updatePlayerById(id, playerDto);
	}
	
	@DeleteMapping("/players/{id}")
	public String deletePlayerById(@PathVariable int id)
	{
		return service.deletePlayerById(id);
	}
	
	@GetMapping("/players/getPlayersbetween/{min}/{max}")
	public List<Player>getPlayersMatchesBetween(@PathVariable int min,@PathVariable int max){
		return service.findPlayersByMinAndMaxmatches(min, max);
	}
}
