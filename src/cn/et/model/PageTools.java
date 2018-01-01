package cn.et.model;

import java.util.List;

public class PageTools {
	/**
	 * 
	 * @param curPage	��ǰҳ
	 * @param totalCount	������(�����ݿ��ѯ)
	 * @param pageCount	ÿҳ��ʾ������
	 * 
	 */
	public PageTools(Integer curPage, Integer totalCount, Integer pageCount) {
		this.curPage =curPage;//��ǰҳ
		this.totalCount = totalCount;//�ܼ�¼��
		this.pageCount = pageCount==null?10:pageCount;//ÿҳ��ʾ������
		this.prePage= (curPage==1?1:curPage-1);//��һҳ
		this.totalPage = totalCount%this.pageCount==0?totalCount/this.pageCount:totalCount/this.pageCount+1;//��ҳ��
		this.nextPage = (curPage==totalPage)?totalPage:(curPage+1);//��һҳ
		this.startIndex =(curPage-1)*this.pageCount+1;
		this.endIndex = curPage*this.pageCount;
		
	}
	/**
	 * ��ǰҳ(��̬  ��ҳ�洫�ݵ�)
	 */
	private Integer curPage;
	
	/**
	 * ÿҳ��ʾ������
	 */
	private Integer pageCount;
	
	/**
	 * ��һҳ
	 * prePage=(curPage==1?1:curPage-1)
	 * ������
	 * 	3--2
	 *  2--1
	 *  1--1
	 */
	private Integer prePage;
	
	/**
	 * ��һҳ
	 * nextPage=(nextPage==totalPage)?totalPage:(nextPage+1)
	 * ���������4�����һҳ
	 *  1--2
	 *  2--3
	 *  3--4
	 *  4--4
	 */
	private Integer nextPage;
	
	
	/**
	 * ��ҳ��
	 * pageCount(ÿҳ��ʾ������)		total(�ܼ�¼��)		totalPage
	 * 			10					20					2
	 * 			10					21					3
	 *
	 *totalPage=total%pageCount==0?total/pageCount:total/pageCount+1
	 *
	 */
	private Integer totalPage;
	
	/**
	 * ������(�����ݿ��ѯ)
	 */
	private Integer totalCount;
	
	/**
	 * ��ʼ����
	 * curPage	pageCount start-end
	 * 	1			10		1-10
	 * 	2			10		11-20
	 * 					(curPage-1)*pageCount+1		curPage*pageCount
	 */
	private Integer startIndex;
	
	/**
	 * ��������
	 */
	private Integer endIndex;
	
	/**
	 * �洢���ղ�ѯ������
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
