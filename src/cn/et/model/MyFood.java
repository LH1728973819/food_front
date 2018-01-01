package cn.et.model;

import java.util.List;
import java.util.Map;

import cn.et.model.DbUtils;
import cn.et.model.PageTools;

public class MyFood {
	/**
	 * ·ÖÒ³
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Integer getTableListCount() throws Exception{
		String sql="select count(rowid) as cr from food";
		List<Map> result=DbUtils.query(sql);
		return Integer.valueOf(result.get(0).get("CR").toString());
	}
	
	
	public PageTools getTableListPager(Integer curPage) throws Exception{
		Integer totalCount=getTableListCount();
		PageTools pt=new PageTools(curPage,totalCount,6);
		
		String sql="select * from (select f.*,ft.typename,rownum rn from food f inner join foodtype ft on f.typeid=ft.typeid)"
				+ " where rn>="+pt.getStartIndex()+" and rn<="+pt.getEndIndex();
		
		List<Map> result=DbUtils.query(sql);
		pt.setData(result);
		return pt;
	}
}
