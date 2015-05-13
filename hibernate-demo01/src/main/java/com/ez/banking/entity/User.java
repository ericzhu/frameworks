package com.ez.banking.entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "FINANCES_USER")
@Access(AccessType.FIELD)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	//---------------- SEQUENCE GENERATION STARTEGY ----------------
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
	//@SequenceGenerator(name="user_seq", sequenceName="USER_ID_SEQ")
	
	//---------------- TABLE GENERATION STARTEGY ----------------
	//@GeneratedValue(strategy = GenerationType.TABLE, generator="user_table_generator")
	//@TableGenerator(name = "user_table_generator", pkColumnName="PK_NAME", pkColumnValue="PK_VALUE")
	private Long userId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE", nullable = false)
	private Date birthDate;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;
	
	@Transient
	private boolean valid;
	
	@Formula("lower(datediff(curdate(), birth_date)/365)")
	private int age;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
