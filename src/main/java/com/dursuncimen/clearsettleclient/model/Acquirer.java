package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Acquirer {
	private Integer id;

	private String name;

	private String code;
	
	private String type;
	
	
	
	public Acquirer() {
		// TODO Auto-generated constructor stub
	}
	
	public Acquirer(String type) {
		this.type = type;
	}
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setTypeVal(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", name = " + name + ", code = " + code + ", type = " + type + "]";
	}
}
