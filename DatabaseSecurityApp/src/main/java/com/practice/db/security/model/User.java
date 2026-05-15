package com.practice.db.security.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_tab")
@Data
public class User {
	 @Id
	 @GeneratedValue
	 private int id;
	 @Column(name = "user_name")
	 private String userName;
	 @Column(name = "user_email")
	 private String userEmail;
	 @Column(name = "user_pwd")
	 private String userPwd;
	 @ElementCollection(fetch = FetchType.EAGER)
	 @CollectionTable(name = "role_tab", 
	 joinColumns = @JoinColumn(name="id")
			 )
	 @Column(name = "role")
	 private List<String> role;
}
