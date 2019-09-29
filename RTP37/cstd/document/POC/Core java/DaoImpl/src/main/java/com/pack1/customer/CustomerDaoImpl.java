package com.pack1.customer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/customer.html")
public class CustomerDaoImpl {
	private static final String driverClassName="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/RTP_3710";
	private static final String username="root";
	private static final String password="root";
	
	private static final String sqlDb="SELECT * from  customer_details";
	/*private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	public int selectCustomer(customer_details cdao){
		String query="select * from customer_details";
		return 0;
		
	}
	*/
	private static DriverManagerDataSource ds;
	
	public static void main(String[] args) {
		ds=getdataSource();
		JdbcTemplate template=new JdbcTemplate(ds);
		List<Map<String,Object>> cust=template.queryForList(sqlDb);
		if(cust!=null && !cust.isEmpty()){
			for(Map<String,Object>  cus : cust){
				for(Iterator<Map.Entry<String, Object>> it=cus.entrySet().iterator();it.hasNext();){
					Map.Entry<String, Object> entry=it.next();
					String key=entry.getKey();
					Object value=entry.getValue();
					System.out.println(key+"="+value);
				}
				System.out.println();
			}
		}
	}

	private static DriverManagerDataSource getdataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}
