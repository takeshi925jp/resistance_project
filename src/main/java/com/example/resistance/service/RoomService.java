package com.example.resistance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resistance.entity.Player;
import com.example.resistance.entity.Room;
import com.example.resistance.mapper.RoomMapper;

@Service
public class RoomService {

		@Autowired
		private RoomMapper roomMapper;

		public void createRoom(Room room ) {

			// room作成
			roomMapper.createRoom(room);
		}

		public List<Room> showRooms() {

			// room取得
			List<Room> rooms = roomMapper.showRooms();

			return rooms;
		}

		public Room showRoom(Room room) {

			// room取得
			Room resultRoom = roomMapper.showRoom(room);

			return resultRoom;
		}

		public void createPlayer(Player player) {

			// player作成
			roomMapper.createPlayer(player);
		}

		public List<Player> showPlayer(Room room) {

			// roomに対応するplayer取得
			List<Player> players = roomMapper.showPlayer(room);

			return players;
		}

		public void updatePlayerNum(Room room) {

			// 参加人数更新
			roomMapper.updatePlayerNum(room);
		}

		public void deleteRoom(Room room) {

			// 参加人数更新
			roomMapper.deleteRoom(room);
		}



}
