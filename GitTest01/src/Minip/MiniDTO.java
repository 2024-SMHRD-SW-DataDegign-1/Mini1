package Minip;

public class MiniDTO {

	// DTO (Data Transfer Object)
	// : 데이터를 이동할 수 있게 하는 나만의 자료형
	// : Table 마다 한개씩
	// : Table 의 컬럼을 필드로 가진다.
	
	// 1. 필드
	private String id;
	private String pw;
	private String name;
    
    // 2. 메소드
	public MiniDTO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
