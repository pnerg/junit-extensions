/**
 *  Copyright 2016 Peter Nerg
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

import java.time.Duration;

import org.junit.Test;

import javascalautils.concurrent.Future;
import javascalautils.concurrent.Promise;
/**
 * Test the class {@link FutureAssert}
 * @author Peter Nerg
 *
 */
public class TestFutureAssert extends BaseAssert implements FutureAssert {

	private static final Duration duration = Duration.ofMillis(5);

	@Test
	public void assertSuccess_isSuccess() {
		assertSuccess(Future.successful("Oh yeah!"));
	}
	
	@Test(expected = AssertionError.class)
	public void assertSuccess_isFailure() {
		assertSuccess(Future.failed(new Exception("Error, terror!!")));
	}

	@Test(expected = AssertionError.class)
	public void assertSuccess_notCompleted() {
		assertSuccess(Promise.apply().future());
	}
	
	@Test
	public void assertSuccess_withDuration_isSuccess() {
		assertSuccess(Future.successful("Oh yeah!"), duration);
	}

	@Test(expected = AssertionError.class)
	public void assertSuccess_withDuration_isFailure() {
		assertSuccess(Future.failed(new Exception("Error, terror!!")), duration);
	}

	@Test(expected = AssertionError.class)
	public void assertSuccess_neverCompletes() {
		assertSuccess(Promise.apply().future(), duration);
	}
	
	@Test(expected = AssertionError.class)
	public void assertFailure_isSuccess() {
		assertFailure(Future.successful("Oh yeah!"));
	}
	
	@Test
	public void assertFailure_isFailure() {
		assertFailure(Future.failed(new Exception("Error, terror!!")));
	}

	@Test(expected = AssertionError.class)
	public void assertFailure_notCompleted() {
		assertFailure(Promise.apply().future());
	}
	
	@Test(expected = AssertionError.class)
	public void assertFailure_withDuration_isSuccess() {
		assertFailure(Future.successful("Oh yeah!"), duration);
	}

	@Test
	public void assertFailure_withDuration_isFailure() {
		assertFailure(Future.failed(new Exception("Error, terror!!")), duration);
	}

	@Test(expected = AssertionError.class)
	public void assertFailure_neverCompletes() {
		assertFailure(Promise.apply().future(), duration);
	}
	
	@Test
	public void assertCompleted_withDuration_completes() {
		assertCompleted(Future.successful("Oh yeah!"), duration);
	}

	@Test(expected = AssertionError.class)
	public void assertCompleted_withDuration_neverCompletes() {
		assertCompleted(Promise.apply().future(), duration);
	}
}
