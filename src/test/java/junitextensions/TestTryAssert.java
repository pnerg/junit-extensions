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

import org.junit.Test;
import static javascalautils.TryCompanion.Failure;
import static javascalautils.TryCompanion.Success;;
/**
 * Test the class {@link TryAssert}.
 * @author Peter Nerg
 */
public class TestTryAssert extends BaseAssert implements TryAssert {

	@Test
	public void assertIsFailure_withFailure() {
		assertIsFailure(Failure(new Exception("Error, terror!")));
	}
	
	@Test(expected = AssertionError.class)
	public void assertIsFailure_withSuccess() {
		assertIsFailure(Success("Failure is not an Option"));
	}

	@Test(expected = AssertionError.class)
	public void assertIsSuccess_withFailure() {
		assertIsSuccess(Failure(new Exception("Error, terror!")));
	}
	
	@Test
	public void assertIsSuccess_withSuccess() {
		assertIsSuccess(Success("Failure is not an Option"));
	}
}
