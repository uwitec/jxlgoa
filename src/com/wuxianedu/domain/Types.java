package com.wuxianedu.domain;

public class Types {
	
	private int id;
	private String typeName;
	public Types() {
		super();
	}
	
	public Types(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "Types [id=" + id + ", typeName=" + typeName + "]";
	}
	
	
	

}
