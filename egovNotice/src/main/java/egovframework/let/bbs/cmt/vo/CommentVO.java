package egovframework.let.bbs.cmt.vo;

import java.io.Serializable;

public class CommentVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String commentId;
	private String nttId;
	private String commentCn;
	private String useAt;
	private String delAt;
	private String frstRegisterId;
	private String frstRegistPnttm;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getNttId() {
		return nttId;
	}

	public void setNttId(String nttId) {
		this.nttId = nttId;
	}

	public String getCommentCn() {
		return commentCn;
	}

	public void setCommentCn(String commentCn) {
		this.commentCn = commentCn;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public String getDelAt() {
		return delAt;
	}

	public void setDelAt(String delAt) {
		this.delAt = delAt;
	}

	public String getFrstRegisterId() {
		return frstRegisterId;
	}

	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	public String getFrstRegistPnttm() {
		return frstRegistPnttm;
	}

	public void setFrstRegistPnttm(String frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
