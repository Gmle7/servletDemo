package bean;

public class SelectAll {
	String[] columnName=null;//存放列名
	String[][] userMessage=null;//存放查询到的数据
	int pageSize=2;//每页显示的记录数
	int totalPages=1;//分页后的总页数
	int currentPage=1;//当前显示页
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
