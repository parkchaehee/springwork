package com.khit.web.service;

import java.util.List;

import com.khit.web.dto.UserDTO;

public interface UserService {

	void insert(UserDTO userDTO);

	List<UserDTO> findAll();

	UserDTO findById(Long id);

	UserDTO login(UserDTO userDTO);

}
