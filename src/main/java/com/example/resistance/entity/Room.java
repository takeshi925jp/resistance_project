package com.example.resistance.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {

	private Integer id;
	private Integer roomNum;
	private Integer currentNum;
	private Integer spyNum;
	private String playTime;
	private Integer current_player_num;

	public Room( Integer id, Integer roomNum,Integer currentNum ,Integer spyNum, String playTime) {
		super();

		this.id = id;
		this.roomNum = roomNum;
		this.currentNum = currentNum;
		this.spyNum = spyNum;
		this.playTime = playTime;
		this.current_player_num = current_player_num;
	}
}
