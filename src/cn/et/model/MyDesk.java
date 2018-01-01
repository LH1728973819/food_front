package cn.et.model;

/**
 * javabean是MVC设计模式的模型层(Model层)操作数据
 * javabean Java
 */
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.Select;

/**
 * 封装get方法
 * @author THINK
 */

public class MyDesk {
	public List<Map> getTableListAll() throws Exception{
		String sql="select * from desk";
		return DbUtils.query(sql);
		
	}
}
