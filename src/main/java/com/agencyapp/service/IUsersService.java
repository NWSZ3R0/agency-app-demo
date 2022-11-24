package com.agencyapp.service;

import java.util.List;

import com.agencyapp.dto.ReponseUserAgencyDTO;
import com.agencyapp.model.iam.UsersEntity;

public interface IUsersService {
	public List<UsersEntity> getAllUser();
	public UsersEntity getUserById(int id);
	public ReponseUserAgencyDTO getUserDTO(String username);
	public UsersEntity updateUser(int id, UsersEntity usersEntity);
	public boolean deleteUser(int id);
	public UsersEntity addUser(UsersEntity usersEntity);
	public UsersEntity updateUserLoginDate(String username);
}
