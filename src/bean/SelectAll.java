package bean;

public class SelectAll {
	String[] columnName=null;//�������
	String[][] userMessage=null;//��Ų�ѯ��������
	int pageSize=2;//ÿҳ��ʾ�ļ�¼��
	int totalPages=1;//��ҳ�����ҳ��
	int currentPage=1;//��ǰ��ʾҳ
	public String[] getColumnName() {
		return columnName;
	}
	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}
	public String[][] getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String[][] userMessage) {
		this.userMessage = userMessage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
    
}
