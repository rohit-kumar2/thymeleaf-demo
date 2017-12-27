package com.thymeleaf.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id = null;
	
    private String text = null;
    
	public Comment() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", text=" + text + "]";
	}

}
