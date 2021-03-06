package de.fuberlin.chaostesting.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.deutschebahn.osst.v1_0.AngebotsAntwort;

@Entity
@Table(name="TEST_RESPONSE")
public class Response {
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="response_id")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="response")
	private AngebotsAntwort antwort;

	@Column(name="response_timestamp")
	private Date timestamp;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	// this annotation is specific to hibernate, but sadly, there does not seem to be a JPA alternative
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="test_id")
	private Test test;
	
	@Column(name="valid_01")
	private boolean valid_01;
	
	@Column(name="valid_02")
	private boolean valid_02;
	
	@Column(name="valid_02a")
	private boolean valid_02a;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AngebotsAntwort getAntwort() {
		return antwort;
	}

	public void setAntwort(AngebotsAntwort antwort) {
		this.antwort = antwort;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public boolean isValid_01() {
		return valid_01;
	}
	
	public void setValid_01(boolean b) {
		this.valid_01 = b;
	}
	
	public boolean isValid_02() {
		return valid_02;
	}
	
	public void setValid_02(boolean b) {
		this.valid_02 = b;
	}
	
	public boolean isValid_02a() {
		return valid_02a;
	}
	
	public void setValid_02a(boolean b) {
		this.valid_02a = b;
	}
}
