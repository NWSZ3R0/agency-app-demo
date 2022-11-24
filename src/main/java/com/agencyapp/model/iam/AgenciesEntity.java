package com.agencyapp.model.iam;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.agencyapp.model.properties.PropertiesTypesEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "agencies")
public class AgenciesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String email2;
	@Column
	private String website;
	@Column
	private String address1;
	@Column
	private String address2;	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created;
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updated;
	@OneToMany(targetEntity = UsersEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="agency_id",referencedColumnName = "id")
	private List<PropertiesTypesEntity> userList;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public List<PropertiesTypesEntity> getUserList() {
		return userList;
	}
	public void setUserList(List<PropertiesTypesEntity> userList) {
		this.userList = userList;
	}
	
}
