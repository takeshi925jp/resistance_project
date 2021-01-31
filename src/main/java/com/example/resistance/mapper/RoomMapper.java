package com.example.resistance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.resistance.entity.Player;
import com.example.resistance.entity.Room;



@Mapper
public interface RoomMapper {

	// room情報取得
	public List<Room> showRooms();

	// room情報取得
	public Room showRoom(Room room);

	// room作成
	public void createRoom(Room room);

	//Player作成
	public void createPlayer(Player player);

	//Player情報取得
	public List<Player> showPlayer(Room room);

	//参加人数更新
	public void updatePlayerNum(Room room);

	//部屋削除
	public void deleteRoom(Room room);
}