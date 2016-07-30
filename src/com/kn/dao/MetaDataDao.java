package com.kn.dao;

import com.kn.dto.MetaData;
import com.kn.exception.DaoException;

public interface MetaDataDao {

	MetaData getData() throws DaoException;

}