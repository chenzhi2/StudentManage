package entity;

//教师实体类
public class Teachers {

	private String tid;//工号
	private String tname;//姓名
	private String gender;//性别
	private int age;//年龄
	private String teaching;//所授科目
	
	public Teachers()
	{
		
	}
	
	
	
	public Teachers(String tid, String tname, String gender, int age, String teaching) {
		//super();
		this.tid = tid;
		this.tname = tname;
		this.gender = gender;
		this.age = age;
		this.teaching = teaching;
	}



	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTeaching() {
		return teaching;
	}
	public void setTeaching(String teaching) {
		this.teaching = teaching;
	}



	@Override
	public String toString() {
		return "Teachers [tid=" + tid + ", tname=" + tname + ", gender=" + gender + ", age=" + age + ", teaching="
				+ teaching + "]";
	}
	
	
}
