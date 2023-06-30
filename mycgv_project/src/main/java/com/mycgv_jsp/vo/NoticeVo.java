package com.mycgv_jsp.vo;

import java.util.ArrayList;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class NoticeVo {
	int rno, nhits;
	String nid, ntitle, ncontent, ndate, nfile1, nsfile1, nfile2, nsfile2;
	CommonsMultipartFile[] files;
	ArrayList<String> nfiles = new ArrayList<String>();
	ArrayList<String> nsfiles = new ArrayList<String>();	
	
	
	public String getNfile1() {
		return nfile1;
	}
	public void setNfile1(String nfile1) {
		this.nfile1 = nfile1;
	}
	public String getNsfile1() {
		return nsfile1;
	}
	public void setNsfile1(String nsfile1) {
		this.nsfile1 = nsfile1;
	}
	public String getNfile2() {
		return nfile2;
	}
	public void setNfile2(String nfile2) {
		this.nfile2 = nfile2;
	}
	public String getNsfile2() {
		return nsfile2;
	}
	public void setNsfile2(String nsfile2) {
		this.nsfile2 = nsfile2;
	}
	public CommonsMultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(CommonsMultipartFile[] files) {
		this.files = files;
	}
	public ArrayList<String> getNfiles() {
		return nfiles;
	}
	public void setNfiles(ArrayList<String> nfiles) {
		this.nfiles = nfiles;
	}
	public ArrayList<String> getNsfiles() {
		return nsfiles;
	}
	public void setNsfiles(ArrayList<String> nsfiles) {
		this.nsfiles = nsfiles;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getNhits() {
		return nhits;
	}
	public void setNhits(int nhits) {
		this.nhits = nhits;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	
	
}
