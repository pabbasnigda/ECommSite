//import pack1.Privatedemo;

public class privatedemo 
{
	private int id;
	private String name;
	private double salary;
	public privatedemo(int id, String name, double salary) 
	{
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void Display()
	{
		System.out.println("ID is:"+id+" NAME is:"+name+" SALARY is:"+salary);
	}
}
class demo
{
	public static void main(String args[])
	{
		privatedemo p=new privatedemo(123,"snig",13455.90);
		p.Display();
		p.getId();
		p.getName();
		p.getSalary();
	}
}