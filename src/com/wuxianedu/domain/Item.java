package com.wuxianedu.domain;

public class Item {
	
	private int iid;
	private String topic;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	private Types types;
	public Item() {
		super();
	}
	
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Item [iid=" + iid + ", topic=" + topic + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC
				+ ", optionD=" + optionD + ", answer=" + answer + ", types="
				+ types + "]";
	}

	
	

}
