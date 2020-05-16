package br.com.odonto.controller;

import br.com.odonto.DAO.SchedulingDAO;
import br.com.odonto.model.ClientModel;
import br.com.odonto.model.SchedulingModel;

public class SchedulingController {
	private SchedulingDAO schedulingDAO = new SchedulingDAO();;
	private SchedulingModel scheduling;
	
	public String queryClientName(String cpf)throws Exception{
		String name = null;
		if(cpf.length() > 10) {
			name = schedulingDAO.queryClientName(cpf);
		}
		return name;
	}
	public boolean saveConsultationData(String cpf, String duration, String schedule, String date, String dentist,
			String reason)throws Exception{
		boolean success = false;
		if(cpf.length() > 10 && duration.length() > 3 && schedule.length() > 3 && date.length() > 3 &&
			dentist.length() > 3 && reason.length() > 3){
			scheduling = new SchedulingModel(cpf, duration, schedule, date, dentist, reason);
				return schedulingDAO.saveConsultationData(scheduling);
			}
			return success;
	}
	public SchedulingModel querySchedulingData(String cpf, String date) throws Exception{
		if(cpf.length() > 10){
			return schedulingDAO.querySchedulingData(cpf,date);
		}
		return null;	
	}
	public boolean updateConsultationData(String cpf, String duration, String schedule, String date, String dentist,
			String reason)throws Exception{
		boolean success = false;
		if(cpf.length() > 10 && duration.length() > 3 && schedule.length() > 3 && date.length() > 3 &&
			dentist.length() > 3 && reason.length() > 3){
			scheduling = new SchedulingModel(cpf, duration, schedule, date, dentist, reason);
				success = schedulingDAO.updateConsultationData(scheduling);
			}
			return success;
	}
	public boolean excludeConsultation(String cpf, String date)throws Exception{
		boolean success = false;
		if(cpf.length() > 10) {
			success = schedulingDAO.excludeConsultation(cpf,date);
		}
		return success;
	}
}
