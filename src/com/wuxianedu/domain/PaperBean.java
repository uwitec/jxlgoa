package com.wuxianedu.domain;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class PaperBean {
	
	@NotEmpty(message="试卷名不能为空")
	private String paperName;
	@NotEmpty(message="试题数量不能为空")
	@Pattern(regexp="^[0-9]*[1-9][0-9]*$", message="请输入正确的数量")
	private String questionNumber;
	@NotEmpty(message="{}")
	@Pattern(regexp="^[0-9]*[1-9][0-9]*$", message="请选择正确的类型")
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
