package br.com.odonto.controller;

import br.com.odonto.DAO.SchedulingDAO;
import br.com.odonto.model.ClientModel;
import br.com.odonto.model.SchedulingModel;

public class SchedulingController {
	private SchedulingDAO schedulingDAO = new SchedulingDAO();;
	private SchedulingModel scheduling;
	private boolean success;
	public String queryClientName(String cpf)throws Exception{
		String name = null;
		schedulingDAO = new SchedulingDAO();
		if(cpf.length() > 7) {
			name = schedulingDAO.queryClientName(cpf);
		}
		return name;
	}
	public boolean saveConsultationData(String cpf, String duration, String schedule, String date, String dentist,
			String reason)throws Exception{
		success = false;
		if(cpf.length() > 3 && duration.length() > 3 && schedule.length() > 3 && date.length() > 3 &&
			dentist.length() > 3 && reason.length() > 3){
				scheduling = new SchedulingModel(cpf, duration, schedule, date, dentist, reason);
				return schedulingDAO.saveConsultationData(scheduling);
			}
			return success;
	}
	public SchedulingModel querySchedulingData(String cpf, String date) throws Exception{
		if(cpf.length() > 7){
			return schedulingDAO.querySchedulingData(cpf,date);
		}
		return null;	
	}
	public boolean updateConsultationData(String cpf, String duration, String schedule, String date, String dentist,
			String reason)throws Exception{
		success = false;
		if(cpf.length() > 3 && duration.length() > 3 && schedule.length() > 3 && date.length() > 3 &&
			dentist.length() > 3 && reason.length() > 3){
				scheduling = new SchedulingModel(cpf, duration, schedule, date, dentist, reason);
				return schedulingDAO.updateConsultationData(scheduling);
			}
			return success;
	}
	public boolean excludeConsultation(String cpf, String date)throws Exception{
		boolean success = false;
		if(cpf.length() > 6) {
			success = schedulingDAO.excludeConsultation(cpf,date);
		}
		return success;
	}
}
