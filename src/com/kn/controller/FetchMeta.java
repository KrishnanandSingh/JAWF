package com.kn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kn.dao.MetaDataDao;
import com.kn.dto.MetaData;
import com.kn.processor.RequestHandler;
import com.kn.processor.URLMapping;

@RequestHandler
public class FetchMeta{

	@URLMapping(urlPattern = "/metaData.do")
	public void process(HttpServletRequest request, HttpServletResponse response) {
		MetaDataDao metadao=new MetaDataDao();
		MetaData metadata=metadao.getData();
		Gson gson=new Gson();
		String md=gson.toJson(metadata);
		try {
			PrintWriter out = response.getWriter();
			out.append(md);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
