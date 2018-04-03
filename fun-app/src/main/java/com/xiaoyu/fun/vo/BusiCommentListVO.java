package com.xiaoyu.fun.vo;

import java.util.List;

public class BusiCommentListVO {

	private int lastId;
	
	private int total;
	
	private List<BusiCommentVO> voList;

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<BusiCommentVO> getVoList() {
		return voList;
	}

	public void setVoList(List<BusiCommentVO> voList) {
		this.voList = voList;
	}

}