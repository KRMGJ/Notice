package egovframework.let.bbs.cmm.fms.vo;

import java.io.Serializable;

public class FileGroupVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String atchFileId; // ATCH_FILE_ID
	private String useAt; // USE_AT

	public String getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}
}
