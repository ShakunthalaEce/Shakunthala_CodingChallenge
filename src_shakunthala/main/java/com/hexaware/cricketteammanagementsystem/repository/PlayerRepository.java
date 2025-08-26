package com.hexaware.cricketteammanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.cricketteammanagementsystem.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer>{
	
	
	@Query("Select p from Player p where p.total_matches BETWEEN :min AND :max")
	List<Player>findPlayersByMinAndMaxmatches(@Param("min") int minMatch,@Param("max")int maxMatch);
	
	
}
