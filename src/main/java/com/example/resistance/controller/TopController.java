package com.example.resistance.controller;

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
import com.example.resistance.service.RoomService;
import com.example.resistance.session.UserSession;

@Controller
public class TopController {
	@Autowired
	private RoomService roomService;
	@Autowired
	public UserSession userSession;

	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String login(@ModelAttribute Room room, Model model, BindingResult result) {

		List<Room> rooms = roomService.showRooms();

		Integer current_player;

		for(Room val:rooms) {
			List<Player> players = roomService.showPlayer(val);
			current_player = players.size();
		}

		model.addAttribute("rooms",rooms);

		return "/top";
	}

	@RequestMapping(value = "/create_room", method = RequestMethod.POST)
	public String create(@ModelAttribute Room room, Model model, BindingResult result) {
		model.addAttribute("room", room);

		roomService.createRoom(room);

		return "redirect:top";
	}

	@RequestMapping(value = "/enter_gameroom", method = RequestMethod.POST)
	public String roomPlayer(@ModelAttribute Player player,@ModelAttribute Room room, Model model, BindingResult result) {
		model.addAttribute("player", player);

		roomService.createPlayer(player);

		room.setId(player.getRoomId());

		List<Player> players = roomService.showPlayer(room);
		model.addAttribute("players", players);

		roomService.updatePlayerNum(room);
		room = roomService.showRoom(room);

		userSession.setUserName(player.getPlayerName());
		userSession.setRoom(room);

		return "redirect:gamer";
	}

	@RequestMapping(value = "/delete_room", method = RequestMethod.POST)
	public String deleteRoom(@ModelAttribute Room room, Model model, BindingResult result) {
		model.addAttribute("room", room);

		roomService.deleteRoom(room);

		return "redirect:top";
	}



}