package dev.jorgefilho.validator.user;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UsernameValidatorTest {
	private String arg;
	
	private static UsernameValidator usernameValidator;
    
	private boolean expectedValidation;

	public UsernameValidatorTest(final String str, final boolean expectedValidation){
		this.arg = str;
		this.expectedValidation = expectedValidation;

	}

	@BeforeClass
	public static void initialize() {
		usernameValidator = new UsernameValidator();
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
											{ "ascaefghfdghdfhdfghdfghdfhdfghdfghdfghdfghdfghdfghdfghdfghdfghdfghvavasv",false },
											{ "gregory.mar_james-law",true }, 
											{ "n!k1",false } ,
									 	    { "f",false    } 
										 };
		return asList(data);
	}

	@Test
	public void test() {
		assertEquals("Result", this.expectedValidation, usernameValidator.validate(this.arg));
	}
}
