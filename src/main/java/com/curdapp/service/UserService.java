package com.curdapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curdapp.dto.UserDto;
import com.curdapp.entity.User;

public interface UserService {

	public UserDto saveUser(User user);

	public UserDto updateUser(User user);

	public int deleteUserById(Integer id);

	public List<UserDto> getAllUser();

	public UserDto getUserById(int id);

	public String deleteAllUsers();

	public Page<User> getAllUserByPage(String keyword, int pageNo, int size);
}
