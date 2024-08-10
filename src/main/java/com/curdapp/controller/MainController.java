package com.curdapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.curdapp.dto.UserDto;
import com.curdapp.entity.User;
import com.curdapp.exception.UserNotFoundException;
import com.curdapp.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService service;

	@GetMapping("/getUser")
	public ResponseEntity<UserDto> getUserById(@RequestParam int id, Model model) {

		UserDto dto = service.getUserById(id);
		try {
			if (dto != null) {
				model.addAttribute("UserDto", dto);
			} else {
				throw new UserNotFoundException("user not found");
			}
		} catch (Exception e) {
			model.addAttribute("UserDto", null);
		}
		return new ResponseEntity<UserDto>(dto, HttpStatus.OK);
	}

	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody UserDto dto, Model model, BindingResult bindingResult) {
		ModelMapper mapper = new ModelMapper();
		User user = mapper.map(dto, User.class);
		UserDto UserDto = service.saveUser(user);
		model.addAttribute("UserDto", UserDto);
		return new ResponseEntity<String>("Renderd successfully", HttpStatus.OK);
	}

	@GetMapping("/home")
	public String getAll(Model model) {
		model.addAttribute("UserDto", new UserDto());
		model.addAttribute("keyword", " ");
		getAllByPage(null, 0, model);
		return "index";
	}

	@GetMapping("/search")
	public String getBYKeyword(@RequestParam("keyword") String keyword, Model model) {
		model.addAttribute("UserDto", new UserDto());
		model.addAttribute("keyword", keyword);
		return "redirect:/user?page=0";
	}

	@GetMapping("/user")
	public String getAllByPage(@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
		model.addAttribute("UserDto", new UserDto());
		if (keyword == null) {
			Page<User> pageabel = service.getAllUserByPage(null, page, 5);
			model.addAttribute("pageList", pageabel);
			model.addAttribute("currentPage", page);
			model.addAttribute("toatalPages", pageabel.getTotalPages());
			model.addAttribute("totalRecords", pageabel.getTotalElements());
			model.addAttribute("UserDto", new UserDto());
		} else {
			Page<User> pageable = service.getAllUserByPage(keyword, page, 5);
			model.addAttribute("pageList", pageable);
			model.addAttribute("currentPage", page);
			model.addAttribute("toatalPages", pageable.getTotalPages());
			model.addAttribute("totalRecords", pageable.getTotalElements());
			model.addAttribute("UserDto", new UserDto());
		}
		return "index";
	}

	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody UserDto dto) {
		System.out.println("model attribute is:: " + dto.toString());
		ModelMapper mapper = new ModelMapper();
		User user = mapper.map(dto, User.class);
		UserDto updatedDto = service.updateUser(user);
		System.out.println("updated user is:: " + updatedDto);
		return new ResponseEntity<String>("Success..", HttpStatus.OK);
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {

		try {
			int status = service.deleteUserById(id);
			if (status == 1) {
				return "redirect:/home";
			} else {
				throw new UserNotFoundException("User not found for id:: " + id);
			}
		} catch (Exception e) {
			return "redirect:/home";
		}

	}

}
