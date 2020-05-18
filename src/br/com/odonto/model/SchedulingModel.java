package br.com.odonto.model;

public class SchedulingModel {
	private String cpf;
	private String name;
	private String duration;
	private String schedule;
	private String date;
	private String dentist;
	private String reason;
	
	public SchedulingModel() {

	}

	public SchedulingModel(String cpf, String duration, String schedule, String date, String dentist,
			String reason) {
		this.cpf = cpf;
		this.duration = duration;
		this.schedule = schedule;
		this.date = date;
		this.dentist = dentist;
		this.reason = reason;
	}

	public SchedulingModel(String cpf2, String name2, String dentist2, String duration2, String date2, String schedule2,
			String reason2) {
		this.cpf = cpf2;
		this.name = name2;
		this.dentist = dentist2;
		this.duration = duration2;
		this.date = date2;
		this.schedule = schedule2;
		this.reason = reason2;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDentist() {
		return dentist;
	}

	public void setDentist(String dentist) {
		this.dentist = dentist;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
}
