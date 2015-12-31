[![Build Status](https://travis-ci.org/pnerg/junit-extensions.svg)](https://travis-ci.org/pnerg/junit-extensions) [![codecov.io](http://codecov.io/github/pnerg/junit-extensions/coverage.svg?branch=master)](http://codecov.io/github/pnerg/junit-extensions?branch=master)
# junit-extensions
Extensions to JUnit providing additional assertions.  
This project is inspired by the Scala Test libraries and how one can mix in [Traits](http://docs.scala-lang.org/tutorials/tour/traits.html) to get new behavior in the test code.  
Java 8 introduced [default methods](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html) in Interfaces providing much similar functionality as the [Trait](http://docs.scala-lang.org/tutorials/tour/traits.html) in Scala.  
With that in the toolbox this library introduces interfaces with additional assert operations. It allows you as a programmer to write test classes and mix-in additional interfaces to get richer assert operations.

## How To Use
```java
import static javascalautils.OptionCompanion.Option;
import static javascalautils.TryCompanion.Try;

import junitextensions.OptionAssert;
import junitextensions.TryAssert;

import org.junit.Test;

/**
 * Example test class illustrating how to use the assert interfaces from this library. 
 * The interfaces allows mixing in new behavior.
 * @author Peter Nerg
 */
public class ExampleTestClass implements OptionAssert, TryAssert {

	@Test
	public void assertingSome() {
		String expected = "Some is never None";
		//this method is inherited from OptionAssert
		assertSomeEquals(expected, Option(expected));
	}
	
	@Test
	public void getNoneExistingItemFromMap() {
		//this method is inherited from OptionAssert
		assertIsNone(Option(null));
	}
	
	@Test
	public void assertingSuccess(){
		//this method is inherited from TryAssert
		assertSuccessEquals(66, Try(() -> 33*2));
	}

	@Test
	public void assertingFailure(){		
		//this method is inherited from TryAssert
		assertIsFailure(Try(() -> 69/0)); //division by zero, will fail
	}
}
```
