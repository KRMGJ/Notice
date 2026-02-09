package egovframework.let.bbs.cmm.fms.dao;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import egovframework.let.bbs.cmm.fms.vo.FileVO;

@Repository("fileMngDAO")
public class FileMngDAO extends EgovAbstractMapper {

	/**
	 * 파일그룹 등록
	 * 
	 * @param atchFileId - 첨부파일ID
	 */
	public int insertFileGroup(String atchFileId) {
		return insert("FileMngDAO.insertFileGroup", atchFileId);
	}

	/**
	 * 다음 파일일련번호 조회
	 * 
	 * @param atchFileId - 첨부파일ID
	 * @return 다음 파일일련번호
	 */
	public Integer selectNextFileSn(String atchFileId) {
		return selectOne("FileMngDAO.selectNextFileSn", atchFileId);
	}

	/**
	 * 파일상세 등록
	 * 
	 * @param vo - 파일정보가 담긴 VO
	 */
	public void insertFileDetail(FileVO vo) {
		insert("FileMngDAO.insertFileDetail", vo);
	}

	/**
	 * 파일목록 조회
	 * 
	 * @param atchFileId - 첨부파일ID
	 * @return 파일목록
	 */
	public List<FileVO> selectFileList(String atchFileId) {
		return selectList("FileMngDAO.selectFileList", atchFileId);
	}

	/**
	 * 파일상세 조회
	 * 
	 * @param param - 조회할 정보가 담긴 Map
	 * @return 파일상세정보
	 */
	public FileVO selectFileOne(Map<String, Object> param) {
		return selectOne("FileMngDAO.selectFileOne", param);
	}

	/**
	 * 파일사용여부 N으로 수정
	 * 
	 * @param param - 수정할 정보가 담긴 Map
	 * @return 수정건수
	 */
	public int updateFileUseAtN(Map<String, Object> param) {
		return update("FileMngDAO.updateFileUseAtN", param);
	}

	/**
	 * 파일그룹 사용여부 N으로 수정
	 * 
	 * @param atchFileId - 첨부파일ID
	 * @return 수정건수
	 */
	public int updateFileGroupUseAtN(String atchFileId) {
		return update("FileMngDAO.updateFileGroupUseAtN", atchFileId);
	}
}
