package com.agencyapp.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.agencyapp.dao.iam.User2Dao;
import com.agencyapp.dto.ReponseUserAgencyDTO;
import com.agencyapp.model.iam.UsersEntity;
import com.agencyapp.model.messaging.MessagesEntity;
import com.agencyapp.service.IUsersService;
@Service
public class UsersServiceImpl implements IUsersService{
	private SimpleDateFormat fm =new SimpleDateFormat("yyyy/MM/dd");  
	@Autowired
	private User2Dao userDao;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public List<UsersEntity> getAllUser() {
		return userDao.findAll();
	}
	@Override
	public UsersEntity getUserById(int id) {
		return (UsersEntity) userDao.findByid(id);
	}
	@Override
	public ReponseUserAgencyDTO getUserDTO(String username) {
		return userDao.getUserDTO(username);
	}
	@Override
	public UsersEntity updateUser(int id, UsersEntity usersEntity) {
		if (usersEntity != null) {
			UsersEntity userFound = userDao.findByid(id);
			if (userFound != null) {
				userFound.setAgency_id(usersEntity.getAgency_id());
				userFound.setUsername(userFound.getUsername());
				userFound.setFirst_name(usersEntity.getFirst_name());
				userFound.setLast_name(usersEntity.getLast_name());
				userFound.setEmail(usersEntity.getEmail());
				userFound.setPassword(bcryptEncoder.encode(usersEntity.getPassword()));
				userFound.setJob_title(usersEntity.getJob_title());
				userFound.setLast_login_date(usersEntity.getLast_login_date());
				userFound.setCreated(usersEntity.getCreated());
				try {
					userFound.setUpdated(fm.parse(fm.format(new Date())));
				} catch (ParseException e) {
					System.out.println("Parse date error!");
					e.printStackTrace();
				}
				userFound.setPic_user(usersEntity.getPic_user());
				return userDao.save(userFound);
			}
		}
		return null;
	}
	@Override
	public UsersEntity updateUserLoginDate(String username) {
		if (username != null) {
			UsersEntity userFound = userDao.findByUsername(username);
			if (userFound != null) {
				try {
					userFound.setLast_login_date(fm.parse(fm.format(new Date())));
				} catch (ParseException e) {
					System.out.println("Parse date error!");
					e.printStackTrace();
				}
				return userDao.save(userFound);
			}
		}
		return null;
	}
	@Override
	public boolean deleteUser(int id) {
		if(userDao.findByid(id) != null) {
			userDao.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public UsersEntity addUser(UsersEntity usersEntity) {
		usersEntity.setPassword(bcryptEncoder.encode(usersEntity.getPassword()));
		try {
			usersEntity.setCreated(fm.parse(fm.format(new Date())));
		} catch (ParseException e) {
			System.out.println("Parse date error!");
			e.printStackTrace();
		}
		return userDao.save(usersEntity);
	}

}
