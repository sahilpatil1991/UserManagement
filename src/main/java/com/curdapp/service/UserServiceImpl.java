package com.curdapp.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curdapp.dto.UserDto;
import com.curdapp.entity.User;
import com.curdapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDto saveUser(User user) {
		User savedUser = repo.save(user);
		ModelMapper mapper = new ModelMapper();
		UserDto savedDto = mapper.map(savedUser, UserDto.class);
		System.out.println("savedDto inside userserviceimpl:: " + savedDto);
		return savedDto;
	}

	@Override
	public UserDto updateUser(User user) {

		boolean status = repo.existsById(user.getUserId());

		if (status) {
			User savedUser = repo.save(user);
			ModelMapper mapper = new ModelMapper();
			UserDto dto = mapper.map(savedUser, UserDto.class);
			return dto;
		} else {
			return null;
		}
	}

	@Override
	public int deleteUserById(Integer id) {
		int flag = 0;
		boolean status = repo.existsById(id);
		if (status) {
			repo.deleteById(id);
			flag = 1;
		}
		return flag;
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> userList = repo.findAll();
		List<UserDto> dtolist = new ArrayList<UserDto>();
		userList.forEach((user -> {
			ModelMapper mapper = new ModelMapper();
			dtolist.add(mapper.map(user, UserDto.class));
		}));
		return dtolist;
	}

	@Override
	public UserDto getUserById(int id) {

		if (repo.existsById(id)) {
			User user = repo.getById(id);
			ModelMapper mapper = new ModelMapper();
			return mapper.map(user, UserDto.class);
		} else {
			return null;
		}

	}

	@Override
	public String deleteAllUsers() {

		repo.deleteAll();
		return "deleted successfully";
	}

	@Override
	public Page<User> getAllUserByPage(String keyword, int pageNo, int size) {
		Pageable pageable = PageRequest.of(pageNo, size);
		if (keyword == null) {
			return repo.findAll(pageable);
		}
		return repo.findByKeyword(keyword, pageable);
	}
}
