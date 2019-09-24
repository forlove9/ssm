package zh.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		try {
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
			sqlSessionFactory = ssfb.build(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSessionFactory(){
		return sqlSessionFactory;
	}
}
