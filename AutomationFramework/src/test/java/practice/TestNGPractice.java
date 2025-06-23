package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	/*@Test(priority=-1)
	public void create() {
		System.out.println("create");
	}
	@Test(priority=2)
	public void modify() {
		System.out.println("modify");
	}
	@Test
	public void delete() {
		System.out.println("delete");
	}*/
//order of execution will be create, delete, modify
	
	
	/*@Test(invocationCount=3)
	public void create() {
		System.out.println("create");
	}
	@Test(priority=-1)
	public void modify() {
		System.out.println("modify");
	}
	@Test(enabled = false)
	public void delete() {
		System.out.println("delete");
	}*/
	
	@Test()
	public void create() {
		Assert.fail();
		System.out.println("create");
	}
	@Test(dependsOnMethods = "create")
	public void modify() {
		System.out.println("modify");
	}
	@Test()
	public void delete() {
		System.out.println("delete");
	}
}


