package com.wuxianedu.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemBean {
	
	private int iid;
	@NotEmpty(message="题目不可以为空")
	private String topic;
	@NotEmpty(message="选项A内容不可以为空")
	private String optionA;
	@NotEmpty(message="选项B内容不可以为空")
	private String optionB;
	@NotEmpty(message="选项C内容不可以为空")
	private String optionC;
	@NotEmpty(message="选项D内容不可以为空")
	private String optionD;
	@NotEmpty(message="答案不可以为空")
	private String answer;
	@NotEmpty(message="类型不可以为空")
	private String types;
	public ItemBean() {
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

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}


}
