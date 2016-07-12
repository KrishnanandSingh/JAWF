package com.kn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kn.dto.MetaData;
import com.kn.util.DBUtil;

public class MetaDataDao {

	public MetaData getData(){
		List<String> competenceList=new ArrayList<>();
		List<String> subpracticeList=new ArrayList<>();
		List<String> verticalsList=new ArrayList<>();
		
		Connection con=DBUtil.getConnection();
		ResultSet rsc=null;
		ResultSet rss=null;
		ResultSet rsv=null;
		try {
			Statement statement=con.createStatement();
			rsc=statement.executeQuery("SELECT competence_name FROM competence");
			while(rsc.next()){
				competenceList.add(rsc.getString("competence_name"));
			}
			
			rss=statement.executeQuery("SELECT subpractice_name FROM subpractice");
			while(rss.next()){
				subpracticeList.add(rss.getString("subpractice_name"));
			}
			
			rsv=statement.executeQuery("SELECT verticals_name FROM verticals");
			while(rsv.next()){
				verticalsList.add(rsv.getString("verticals_name"));
			}
			
			
			MetaData meta=new MetaData(competenceList, subpracticeList, verticalsList);
			return meta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.releaseResource(rsc);
			DBUtil.releaseResource(rsv);
			DBUtil.releaseResource(rss);
			DBUtil.releaseResource(con);
		}
		
		return null;
		
	}
}
