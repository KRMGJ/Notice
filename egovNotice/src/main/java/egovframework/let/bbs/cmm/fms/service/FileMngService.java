package egovframework.let.bbs.cmm.fms.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import egovframework.let.bbs.cmm.fms.vo.FileVO;

public interface FileMngService {

	/**
	 * 파일그룹 생성 및 파일등록
	 * 
	 * @param files - 등록할 파일들
	 * @return 생성된 파일그룹ID
	 * @throws Exception
	 */
	String saveFilesNewGroup(MultipartFile[] files) throws Exception;

	/**
	 * 파일그룹에 파일추가 등록
	 * 
	 * @param atchFileId - 첨부파일ID
	 * @param files      - 등록할 파일들
	 * @return 첨부파일ID @ throws Exception
	 */
	String saveFilesAppend(String atchFileId, MultipartFile[] files) throws Exception;

	/**
	 * 파일목록 조회
	 * 
	 * @param atchFileId - 첨부파일ID
	 * @return 파일목록
	 * @throws Exception
	 */
	List<FileVO> selectFileList(String atchFileId) throws Exception;

	/**
	 * 파일상세 조회
	 * 
	 * @param atchFileId - 첨부파일ID
	 * @param fileSn     - 파일일련번호
	 * @return 파일상세정보
	 * @throws Exception
	 */
	FileVO selectFileOne(String atchFileId, int fileSn) throws Exception;

	/**
	 * 파일삭제
	 * 
	 * @param atchFileId - 첨부파일ID
	 * @param fileSn     - 파일일련번호
	 * @throws Exception
	 */
	void deleteFile(String atchFileId, int fileSn) throws Exception;

	/**
	 * 파일그룹삭제
	 * 
	 * @param atchFileId - 첨부파일ID
	 * @throws Exception
	 */
	void deleteFileGroup(String atchFileId) throws Exception;
}
