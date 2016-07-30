package com.kn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kn.dto.MetaData;
import com.kn.entity.Competence;
import com.kn.entity.Subpractice;
import com.kn.entity.Vertical;
import com.kn.exception.DaoException;
import com.kn.util.DBUtil;

public class MetaDataDaoImpl implements MetaDataDao {

	@Override
	public MetaData getData() throws DaoException {
		List<Competence> competenceList = new ArrayList<>();
		List<Subpractice> subpracticeList = new ArrayList<>();
		List<Vertical> verticalList = new ArrayList<>();

		Connection con = null;
		Statement statement = null;
		try {
			con = DBUtil.getConnection();
			statement = con.createStatement();
			ResultSet rsc = statement.executeQuery("SELECT idcompetence, competence_name FROM competence");
			while (rsc.next()) {
				String competence_name = rsc.getString("competence_name");
				int idcompetence = rsc.getInt("idcompetence");
				Competence competence = new Competence(idcompetence, competence_name);
				competenceList.add(competence);
			}

			ResultSet rss = statement.executeQuery("SELECT idsubpractice, subpractice_name FROM subpractice");
			while (rss.next()) {
				String subpractice_name = rss.getString("subpractice_name");
				int idsubpractice = rss.getInt("idsubpractice");
				Subpractice subpractice = new Subpractice(idsubpractice, subpractice_name);
				subpracticeList.add(subpractice);
			}

			ResultSet rsv = statement.executeQuery("SELECT idvertical, vertical_name FROM vertical");
			while (rsv.next()) {
				int idvertical = rsv.getInt("idvertical");
				String vertical_name = rsv.getString("vertical_name");
				Vertical vertical = new Vertical(idvertical, vertical_name);
				verticalList.add(vertical);
			}

			MetaData meta = new MetaData(competenceList, subpracticeList, verticalList);
			return meta;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DBUtil.releaseResource(con, statement);
		}
	}
}
