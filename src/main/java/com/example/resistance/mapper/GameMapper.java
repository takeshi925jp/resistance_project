package com.example.resistance.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.resistance.entity.Player;

@Mapper
public interface GameMapper {

	// room情報取得
	public void registPosition(Player player);

}
