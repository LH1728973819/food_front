package cn.et.model;

import java.util.List;
import java.util.Map;

public class MyFoodType {
	public List<Map> getAllFoodType() throws Exception{
		String sql="select * from FOODTYPE";
		return DbUtils.query(sql);
	}
}
