package com.hexaware.cricketteammanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(PlayerNotFoundException.class)
	@ResponseStatus(reason="Player Not Found",code = HttpStatus.BAD_REQUEST)
	public String handler()
	{
		return "Player Not Found";
	}
}
