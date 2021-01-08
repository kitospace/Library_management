package com.birlasoft.projectOne.model;

public class StudentVO {
	private int stuId;
	private String stuName;
	private String stuAge;
	private String stuNum;
	private String stuDOB;


//GETTER AND SETTER	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuAge() {
		return stuAge;
	}
	public void setStuAge(String stuAge) {
		this.stuAge = stuAge;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getStuDOB() {
		return stuDOB;
	}
	public void setStuDOB(String stuDOB) {
		this.stuDOB = stuDOB;
	}
	
//Constructor
	public StudentVO(int stuId, String stuName, String stuAge,
			String stuNum, String stuDOB) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuNum = stuNum;
		this.stuDOB = stuDOB;
	}
	
//ToString
	@Override
	public String toString() {
		return "StudentVO [stuId=" + stuId + ", stuName=" + stuName
				+ ", stuAge=" + stuAge + ", stuNum=" + stuNum + ", stuDOB="
				+ stuDOB + "]";
	}
	
//Constructor from superclass
	public StudentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
