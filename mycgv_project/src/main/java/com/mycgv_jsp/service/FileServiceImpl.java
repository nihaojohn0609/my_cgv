package com.mycgv_jsp.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mycgv_jsp.vo.BoardVo;
import com.mycgv_jsp.vo.NoticeVo;

@Service("fileService")
public class FileServiceImpl {	
	/**
	 * multiFileSave - 멀티파일 저장 기능
	 */
	public void multiFileSave(NoticeVo noticeVo, HttpServletRequest request) 
															throws Exception {		
		//파일의 저장위치
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
//System.out.println(root_path+attach_path);		
		int count = 0;
		for(CommonsMultipartFile file : noticeVo.getFiles()) {
			//파일이 존재하면 서버에 저장
			if(file.getOriginalFilename() != null
					&& !file.getOriginalFilename().equals("")) {
				File saveFile = 
					new File(root_path + attach_path+ noticeVo.getNsfiles().get(count));
				file.transferTo(saveFile);
			}//if
			count++;
		}//for		
		
	}
	
	
	/**
	 * multiFileCheck - 멀티파일 체크 기능
	 */
	public NoticeVo multiFileCheck(NoticeVo noticeVo) {
		for(CommonsMultipartFile file  : noticeVo.getFiles()) {
			if(!file.getOriginalFilename().equals("")) {
				//파일 있음
				UUID uuid = UUID.randomUUID();
				noticeVo.getNfiles().add(file.getOriginalFilename());
				noticeVo.getNsfiles().add(uuid+"_"+file.getOriginalFilename());
			}else {
				//파일 없음
				noticeVo.getNfiles().add("");
				noticeVo.getNsfiles().add("");
			}			
		}//for
		
		noticeVo.setNfile1(noticeVo.getNfiles().get(0));
		noticeVo.setNsfile1(noticeVo.getNsfiles().get(0));
		noticeVo.setNfile2(noticeVo.getNfiles().get(1));
		noticeVo.setNsfile2(noticeVo.getNsfiles().get(1));
				
		return noticeVo;
	}
	
	
	
	/**
	 * fileDelete 기능 - 파일 삭제 
	 */
	public void fileDelete(HttpServletRequest request, String oldFileName) 
														throws Exception{
		//파일의 삭제위치
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//파일이 존재하면 서버에 저장
		if(oldFileName != null &&  !oldFileName.equals("")) { //새로운 파일 선택
			File deleteFile = new File(root_path + attach_path+ oldFileName);
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	
	/**
	 * fileDelete 기능 - 파일 삭제 
	 */
	public void fileDelete(BoardVo boardVo, HttpServletRequest request, String oldFileName) 
														throws Exception{
		//파일의 삭제위치
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//파일이 존재하면 서버에 저장
		if(!boardVo.getFile1().getOriginalFilename().equals("")) { //새로운 파일 선택
			File deleteFile = new File(root_path + attach_path+ oldFileName);

			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	
	/**
	 * fileSave 기능 - 파일이 존재하면 서버에 저장하는 메소드
	 */
	public void fileSave(BoardVo boardVo, HttpServletRequest request) 
														throws Exception{
		//파일의 저장위치
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//파일이 존재하면 서버에 저장
		if(boardVo.getFile1().getOriginalFilename() != null
				&& !boardVo.getFile1().getOriginalFilename().equals("")) {
			File saveFile = new File(root_path + attach_path+ boardVo.getBsfile());
			boardVo.getFile1().transferTo(saveFile);
		}
	}
	
	
	/**
	 * fileCheck 기능 - 파일이 존재하면  boardVo에 bfile, bsfile set!, 없으면 boardVo 리턴!
	 */
	public Object fileCheck(BoardVo boardVo) {
		if(boardVo.getFile1().getOriginalFilename() != null
				&& !boardVo.getFile1().getOriginalFilename().equals("")) {  //파일이 존재하면
			
			//BSFILE 파일 중복 처리
			UUID uuid = UUID.randomUUID();
			String bfile = boardVo.getFile1().getOriginalFilename();
			String bsfile = uuid + "_" + bfile;
			boardVo.setBfile(bfile);
			boardVo.setBsfile(bsfile);
		}else {
			System.out.println("파일 없음");
			//boardVo.setBfile("");
			//boardVo.setBsfile("");
		}	
		
		return boardVo;
	}
	
	
}
