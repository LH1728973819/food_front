package cn.et.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.sun.crypto.provider.RSACipher;

/**
 * jdbc封装类
 * @author Administrator
 *
 */

public class DbUtils {
   static Properties p =new Properties();
	
	static{
		InputStream is =DbUtils.class.getResourceAsStream("jdbc.properties");
		try {
			p.load(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 */
	public static Connection getConnection() throws Exception{
		String url=p.getProperty("url");
		String driverClass=p.getProperty("driverClass");
		String userName =p.getProperty("userName");
		String password =p.getProperty("password");
		Class.forName(driverClass);
		Connection conn =DriverManager.getConnection(url, userName, password);
		return conn;
	}
	/**
	 * 行和列的结构
	 * id name
	 * 1  zs
	 * 2  ls
	 * 
	 * java结构
	 *多行 List
	 * List list=new ArrayList;多个行可以组成一个集合length=2
	 * 
	 *1行 Map
	 * Map map=new hashMap();
	 * map.put("id",1);
	 * map.put("name","zs");
	 * 
	 * Map maps=new hashMap();
	 * maps.put("id",2);
	 * maps.put("name","ls");
	 * 
	 * List list=new ArrayList;
	 * list.add(map);
	 * list.add(maps);
	 * 
	 *1行  类
	 * class Dept{
	 * 	String id;
	 *	String name;
	 * }
	 * Dept d=new Dept();
	 * d.id="1";
	 * d.name="zs";
	 * 
	 * Dept d=new Dept();
	 * d2.id="2";
	 * d2.name="ls";
	 * 
	 * List list=new ArrayList();
	 * list.add(d);
	 * list.add(d2);
	 * @param <Map>
	 * @throws Exception 
	 */
	public static List<Map> query(String sql) throws Exception{
		Connection conn=getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();//获取列名
		List list=new ArrayList<>();
		int count=rsmd.getColumnCount();//获取列的个数
		
		while (rs.next()) {
			Map map=new HashMap();
			for (int i = 1; i <= count; i++) {
				String name=rsmd.getColumnName(i);
				String value=rs.getString(i);
				map.put(name, value); 
			}
			list.add(map);
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
	}
	public static int execute(String sql) throws Exception{
		Connection conn=getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		int i=ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}
}
