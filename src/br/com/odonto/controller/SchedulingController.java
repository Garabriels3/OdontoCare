package br.com.odonto.controller;

import br.com.odonto.DAO.SchedulingDAO;

public class SchedulingController {
	SchedulingDAO schedulingDAO;
	public String queryClientName(String cpf)throws Exception{
		String name = null;
		schedulingDAO = new SchedulingDAO();
		if(cpf.length() > 7) {
			name = schedulingDAO.queryClientName(cpf);
		}
		return name;
	}
}
