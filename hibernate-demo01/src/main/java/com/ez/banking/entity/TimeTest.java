package com.ez.banking.entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TIME_TEST")
@Access(AccessType.FIELD)
public class TimeTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIME_TEST_ID")
	private Long timeTestId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_TIME_COL")
	private Date datetimeColumn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_STAMP_COL")
	private Date datestampColumn;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_COL")
	private Date dateColumn;

	@Temporal(TemporalType.TIME)
	@Column(name = "TIME_COL")
	private Date timeColumn;

	@Column(name = "SQL_TIMESTAMP_COL")
	private java.sql.Timestamp sqlTimestampeColumn;

	@Column(name = "SQL_DATE_COL")
	private java.sql.Date sqlDateColumn;

	@Column(name = "SQL_TIME_COL")
	private java.sql.Time sqlTimeColumn;

	public TimeTest() {

	}

	public TimeTest(Date date) {
		this.datetimeColumn = date;
		this.datestampColumn = date;
		this.dateColumn = date;
		this.timeColumn = date;

		this.sqlTimestampeColumn = new java.sql.Timestamp(date.getTime());
		this.sqlDateColumn = new java.sql.Date(date.getTime());
		this.sqlTimeColumn = new java.sql.Time(date.getTime());
	}

	public Long getTimeTestId() {
		return timeTestId;
	}

	public void setTimeTestId(Long timeTestId) {
		this.timeTestId = timeTestId;
	}

	public Date getDatetimeColumn() {
		return datetimeColumn;
	}

	public void setDatetimeColumn(Date datetimeColumn) {
		this.datetimeColumn = datetimeColumn;
	}

	public Date getDatestampColumn() {
		return datestampColumn;
	}

	public void setDatestampColumn(Date datestampColumn) {
		this.datestampColumn = datestampColumn;
	}

	public Date getDateColumn() {
		return dateColumn;
	}

	public void setDateColumn(Date dateColumn) {
		this.dateColumn = dateColumn;
	}

	public Date getTimeColumn() {
		return timeColumn;
	}

	public void setTimeColumn(Date timeColumn) {
		this.timeColumn = timeColumn;
	}

	public java.sql.Timestamp getSqlTimestampeColumn() {
		return sqlTimestampeColumn;
	}

	public void setSqlTimestampeColumn(java.sql.Timestamp sqlTimestampeColumn) {
		this.sqlTimestampeColumn = sqlTimestampeColumn;
	}

	public java.sql.Date getSqlDateColumn() {
		return sqlDateColumn;
	}

	public void setSqlDateColumn(java.sql.Date sqlDateColumn) {
		this.sqlDateColumn = sqlDateColumn;
	}

	public java.sql.Time getSqlTimeColumn() {
		return sqlTimeColumn;
	}

	public void setSqlTimeColumn(java.sql.Time sqlTimeColumn) {
		this.sqlTimeColumn = sqlTimeColumn;
	}
}
