package com.example.resistance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resistance.entity.Player;
import com.example.resistance.mapper.GameMapper;

@Service
public class GameService {

	@Autowired
	private GameMapper gameMapper;

	public void registPosition(Player player) {

		// 役職を登録
		gameMapper.registPosition(player);
	}

}
