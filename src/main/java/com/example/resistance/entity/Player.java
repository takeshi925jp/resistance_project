package com.example.resistance.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

	private Integer id;
	private Integer roomId;
	private String playerName;
	private String position;

	public Player( Integer id, Integer roomId,String playerName) {
		super();

		this.id = id;
		this.roomId = roomId;
		this.playerName= playerName;
		this.position= position;
	}
}
