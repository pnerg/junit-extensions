/**
 *  Copyright 2015 Peter Nerg
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package junitextensions;

import static javascalautils.OptionCompanion.Option;
import static javascalautils.TryCompanion.Try;

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
