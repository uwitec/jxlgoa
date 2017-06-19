package com.wuxianedu.domain;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class PaperBean {
	
	@NotEmpty(message="�Ծ�������Ϊ��")
	private String paperName;
	@NotEmpty(message="������������Ϊ��")
	@Pattern(regexp="^[0-9]*[1-9][0-9]*$", message="��������ȷ������")
	private String questionNumber;
	@NotEmpty(message="{}")
	@Pattern(regexp="^[0-9]*[1-9][0-9]*$", message="��ѡ����ȷ������")
	private String typesId;
	
	public PaperBean() {
		super();
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(String questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getTypesId() {
		return typesId;
	}

	public void setTypesId(String typesId) {
		this.typesId = typesId;
	}


}
