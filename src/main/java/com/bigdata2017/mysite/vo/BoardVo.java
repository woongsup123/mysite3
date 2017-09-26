package com.bigdata2017.mysite.vo;

public class BoardVo {
	private Long no;
	private String title;
	private String regDate;
	private Long hit;
	private Long group;
	private Long order;
	private Long depth;
	private Long userNo;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	public Long getGroup() {
		return group;
	}
	public void setGroup(Long group) {
		this.group = group;
	}
	public Long getOrder() {
		return order;
	}
	public void setOrder(Long order) {
		this.order = order;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", regDate=" + regDate + ", hit=" + hit + ", group=" + group
				+ ", order=" + order + ", depth=" + depth + ", userNo=" + userNo + "]";
	}
	
}
