package cn.et.model;

/**
 * javabean��MVC���ģʽ��ģ�Ͳ�(Model��)��������
 * javabean Java
 */
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.Select;

/**
 * ��װget����
 * @author THINK
 */

public class MyDesk {
	public List<Map> getTableListAll() throws Exception{
		String sql="select * from desk";
		return DbUtils.query(sql);
		
	}
}
