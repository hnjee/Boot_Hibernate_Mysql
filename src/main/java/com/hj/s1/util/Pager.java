package com.hj.s1.util;

import lombok.Data;

@Data
public class Pager {
	private Integer totalPage;			//전체 페이지의 수 
	private Integer totalBlock;			//전체 페이지 블럭의 수 
	
	private Integer size = 15;			//perPage 한 페이지 당 글의 수  		*초기화 필요*
	private Integer perBlock = 5;		//한 블럭 당 페이지의 수 				*초기화 필요

	private Integer page;				//curPage 현재 페이지   				*초기화 필요* 
	private Integer startRow;			//현재 페이지의 첫번째 글 번호
	private Integer lastRow;			//현재 페이지의 마지막 글 번호
	
	private Integer curBlock;			//현재 페이지블럭 
	private Integer startNum;			//현재 페이지블럭의 처음 페이지 번호   
	private Integer lastNum;			//현재 페이지블럭의 마지막 페이지 번호
			
	private String kind;			//검색 말머리 
	private String search;			//검색어 
	
	//한 페이지의 첫번째글과 마지막글 번호 계산하기
	public void makeRow() {
		this.startRow = this.getPage()-1; //mysql은 0부터 시작이므로 +1 지움 (oracle은 1부터) +  hiberate에서 곱하는거 없앰 
		this.lastRow = this.getPage()*this.size;
	}
	
	public void makePage(Integer totalPage) {
		//1. 전체 글의 수 : totalCount

//		//2. 전체 페이지 수 계산
//		this.totalPage = totalCount/this.size;
//		if(totalCount%this.size!=0) {
//			this.totalPage++;
//		}
		this.setTotalPage(totalPage);
		
		//3. 전체 페이지 블럭 수 계산
		this.totalBlock = this.totalPage/this.perBlock;
		if(this.totalPage % this.perBlock!=0) {
			this.totalBlock++;
		}
		//----------------------------------------전체 구하기 끝 
		
		//4. 현재 페이지 블럭 번호 계산 
		this.curBlock = this.getPage() / this.perBlock;
		if(this.page % this.perBlock!=0) {
			this.curBlock++;
		}
		
		//5. 현재 페이지 블럭의 첫번째와 마지막 페이지 번호 계산
		this.startNum = (this.curBlock-1) * this.perBlock + 1;
		this.lastNum = this.curBlock * this.perBlock;
		
		//5-2. 마지막 페이지 블럭일 경우
		if(this.curBlock==this.totalBlock) {
			this.lastNum = this.totalPage;		//마지막 페이지번호를 전체 페이지번호로 변경  
		}
		
		//6. 검색 결과가 없을 경우 
		if(totalPage==0) {
			this.startNum=1;
			this.lastNum=1;
		}
	}
	
	public Integer getPage() {	 
		if(this.page==null||this.page==0) {
			this.page = 1; //현재페이지 초기화 
		}
		return this.page;
	}
	
	public String getKind() {
		if(this.kind==null||this.kind.equals("")) {
			this.kind="title";
		}
		return kind;
	}
	
	public String getSearch() { 
		if(this.search==null) { 
			this.search=""; //검색어 초기화 
		}
		return search;
	}
}