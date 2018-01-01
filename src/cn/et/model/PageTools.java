package cn.et.model;

import java.util.List;

public class PageTools {
	/**
	 * 
	 * @param curPage	当前页
	 * @param totalCount	总条数(从数据库查询)
	 * @param pageCount	每页显示的条数
	 * 
	 */
	public PageTools(Integer curPage, Integer totalCount, Integer pageCount) {
		this.curPage =curPage;//当前页
		this.totalCount = totalCount;//总记录数
		this.pageCount = pageCount==null?10:pageCount;//每页显示的条数
		this.prePage= (curPage==1?1:curPage-1);//上一页
		this.totalPage = totalCount%this.pageCount==0?totalCount/this.pageCount:totalCount/this.pageCount+1;//总页数
		this.nextPage = (curPage==totalPage)?totalPage:(curPage+1);//下一页
		this.startIndex =(curPage-1)*this.pageCount+1;
		this.endIndex = curPage*this.pageCount;
		
	}
	/**
	 * 当前页(动态  右页面传递的)
	 */
	private Integer curPage;
	
	/**
	 * 每页显示的条数
	 */
	private Integer pageCount;
	
	/**
	 * 上一页
	 * prePage=(curPage==1?1:curPage-1)
	 * 举例：
	 * 	3--2
	 *  2--1
	 *  1--1
	 */
	private Integer prePage;
	
	/**
	 * 下一页
	 * nextPage=(nextPage==totalPage)?totalPage:(nextPage+1)
	 * 举例：如果4是最后一页
	 *  1--2
	 *  2--3
	 *  3--4
	 *  4--4
	 */
	private Integer nextPage;
	
	
	/**
	 * 总页数
	 * pageCount(每页显示的条数)		total(总记录数)		totalPage
	 * 			10					20					2
	 * 			10					21					3
	 *
	 *totalPage=total%pageCount==0?total/pageCount:total/pageCount+1
	 *
	 */
	private Integer totalPage;
	
	/**
	 * 总条数(从数据库查询)
	 */
	private Integer totalCount;
	
	/**
	 * 开始索引
	 * curPage	pageCount start-end
	 * 	1			10		1-10
	 * 	2			10		11-20
	 * 					(curPage-1)*pageCount+1		curPage*pageCount
	 */
	private Integer startIndex;
	
	/**
	 * 结束索引
	 */
	private Integer endIndex;
	
	/**
	 * 存储最终查询的数据
	 */
	private List data;
	

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
	
	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public static void main(String[] args) {
		PageTools t=new PageTools(2, 5, 26);
		System.out.println(t.getNextPage());
		System.out.println(t.getPrePage());
		System.out.println(t.getTotalPage());
		System.out.println(t.getStartIndex());
		System.out.println(t.getEndIndex());
	}

	@Override
	public String toString() {
		return "PageTools [curPage=" + curPage + ", pageCount=" + pageCount + ", prePage=" + prePage + ", nextPage="
				+ nextPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount + ", startIndex=" + startIndex
				+ ", endIndex=" + endIndex + ", data=" + data + "]";
	}
	
}
