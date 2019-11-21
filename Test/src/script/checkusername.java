package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.fwutil;

import page.usernamepage;

public class checkusername extends BaseTest {

	@Test
	public void testcheckusername() throws InterruptedException {
		String un=fwutil.getxl(xlpath, "loginsheet", 0, 0);
		String pw=fwutil.getxl(xlpath, "loginsheet", 0, 1);
		usernamepage user=new usernamepage(driver);
		user.setusername(un);
		user.clicknext();
		Thread.sleep(3000);
		user.setpassword(pw);
		user.clicknext();
		
	}
}
