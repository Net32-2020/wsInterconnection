package com.azureclaropayagile.soap.entity;

import java.util.Date;

public class DataSendBmc {
	private String logType;
	private Date logDate;
	private String comunicationSource;
	private String resume;
	private String description;
	private String detailDescription;
	private Date logSubmit;
	private byte[] z2AFWorkLog01;
	private String idBmc;
	private String status;
	private String urlAttachment;
	
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public String getComunicationSource() {
		return comunicationSource;
	}
	public void setComunicationSource(String comunicationSource) {
		this.comunicationSource = comunicationSource;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	public Date getLogSubmit() {
		return logSubmit;
	}
	public void setLogSubmit(Date logSubmit) {
		this.logSubmit = logSubmit;
	}
	public byte[] getZ2AFWorkLog01() {
		return z2AFWorkLog01;
	}
	public void setZ2AFWorkLog01(byte[] z2afWorkLog01) {
		z2AFWorkLog01 = z2afWorkLog01;
	}
	public String getIdBmc() {
		return idBmc;
	}
	public void setIdBmc(String idBmc) {
		this.idBmc = idBmc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUrlAttachment() {
		return urlAttachment;
	}
	public void setUrlAttachment(String urlAttachment) {
		this.urlAttachment = urlAttachment;
	}
	
	
	
	
}
