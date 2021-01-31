package com.example.resistance.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.resistance.entity.Player;
import com.example.resistance.entity.Room;
import com.example.resistance.service.GameService;
import com.example.resistance.service.RoomService;
import com.example.resistance.session.UserSession;

@Controller
public class GameController {

		@Autowired
		private RoomService roomService;
		@Autowired
		private GameService gameService;
	     @Autowired
	     public UserSession userSession;

		@RequestMapping(value = "/gamer", method = RequestMethod.GET)
		public String login(@ModelAttribute Room room,@ModelAttribute Player player,@ModelAttribute String playTIme, Model model, BindingResult result) {

			getPageInfo(model, room);

			return "/gameroom";
		}

//		@RequestMapping(value = "/gameroom", method = RequestMethod.POST)
//		public String create(@ModelAttribute Room room, Model model, BindingResult result) {
//			model.addAttribute("room", room);
//
//			List<Player> players = roomService.showPlayer(room);
//			model.addAttribute("players",players);
//
//			System.out.println(userSession.getUserName());
//			model.addAttribute("userName", userSession.getUserName());
//
//			return "/gameroom";
//		}

		@RequestMapping(value = "/start_get", method = RequestMethod.POST)
		public String define(@ModelAttribute Room room, Model model, BindingResult result) {

			// 「入室」押下時に保存したセッション情報(room)取得
			room = userSession.getRoom();

			// Playerテーブルからroom_idに該当するプレイヤー情報を取得
			List<Player> players = roomService.showPlayer(room);

			// positionの割り当て
			players = getPosition(room, players);

			// positionの登録
			for(Player player : players) {
				gameService.registPosition(player);
			}

			return "redirect:gamer";
		}

		/*
		 * ページ情報取得メソッド
		 */
		private Model getPageInfo(Model model, Room room) {

			// 「入室」押下時に保存したセッション情報(room)取得
			room = userSession.getRoom();

			// Playerテーブルからroom_idに該当するプレイヤー情報を取得
			List<Player> players = roomService.showPlayer(room);

			// 役職情報をページに渡す
			for(Player player : players) {
				if(player.getPlayerName() .equals(userSession.getUserName())) {
					model.addAttribute("position", player.getPosition());
				}
			}

			// ページに渡す情報
			model.addAttribute("room", room);
			model.addAttribute("players",players);
			model.addAttribute("playTime",room.getPlayTime());
			model.addAttribute("userName", userSession.getUserName());




			// 制限時間をセッションに設定
			userSession.setPlayTime(room.getPlayTime());

			return model;
		}


		/*
		 * 役職決定メソッド
		 */
		private List<Player> getPosition(Room room, List<Player> players) {

			List<Player> playerList = new LinkedList<Player>();

			for (int i=0; i < players.size(); i++)
			{
			    // プレイヤーを追加
			    playerList.add( players.get(i));
			}

			// 順番をシャッフル
			Collections.shuffle(playerList);

			// スパイ人数の分だけ先頭から取り出す
			for( int i=0; i < room.getSpyNum(); i++) {
				playerList.get(i).setPosition("spy");
			}

			return playerList;

		}


}
