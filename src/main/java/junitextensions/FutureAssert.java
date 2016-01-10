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

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;

import javascalautils.Failure;
import javascalautils.Option;
import javascalautils.Success;
import javascalautils.Try;
import javascalautils.concurrent.Future;

/**
 * Provides additional assert operations related to the {@link Future} class.
 * @author Peter Nerg
 * @since 1.1
 */
public interface FutureAssert extends NotNullAssert, TryAssert {

	/**
     * Asserts that the provided {@link Future} is {@link Future#isCompleted() completed}.
     * @param <T> The type of the Future
     * @param future The Future instance to Assert
     * @since 1.1
	 */
	default <T> void assertComplete(Future<T> future) {
    	assertObjectNotNull(future);
		Option<Try<T>> option = future.value();
		
		//if we get None then the Future is not finished
		assertTrue("The Future is not completed.", option.isDefined());
	}
	
	/**
     * Asserts that the provided {@link Future} is completed within the provided duration.
     * @param <T> The type of the Future
     * @param future The Future instance to Assert
     * @param duration The duration to wait for the Future to complete
     * @since 1.1
	 */
	default <T> void assertComplete(Future<T> future, Duration duration) {
    	assertObjectNotNull(future);
		
    	//block and wait for the Future to complete...or time out
    	try {
			future.ready(duration);
		} catch (TimeoutException | InterruptedException e) {
			Assert.fail("Timeout waiting for Future to complete");
		}
	}	
    /**
     * Asserts that the provided {@link Future} is {@link Future#isCompleted() completed} as well as the result is a {@link Success}.
     * @param <T> The type of the Future
     * @param future The Future instance to Assert
     * @since 1.1
     */
	default <T> void assertSuccess(Future<T> future) {
		assertComplete(future);
		
		//now we assert the result (Try) of the Future
		assertSuccess(future.value().get());
	}

	/**
	 * Asserts that the provided {@link Future} is completed within the provided duration as well as the result is a {@link Success}.
     * @param <T> The type of the Future
     * @param future The Future instance to Assert
     * @param duration The duration to wait for the Future to complete
     * @since 1.1
	 */
	default <T> void assertSuccess(Future<T> future, Duration duration) {
    	assertComplete(future, duration);
    	
    	//now we know the future is complete, assert the result
    	assertSuccess(future);
	}

    /**
     * Asserts that the provided {@link Future} is {@link Future#isCompleted() completed} as well as the result is a {@link Failure}.
     * @param <T> The type of the Future
     * @param future The Future instance to Assert
     * @since 1.1
     */
	default <T> void assertFailure(Future<T> future) {
		assertComplete(future);
		
		//now we assert the result (Try) of the Future
		assertFailure(future.value().get());
	}
	

	/**
	 * Asserts that the provided {@link Future} is completed within the provided duration as well as the result is a {@link Failure}.
     * @param <T> The type of the Future
     * @param future The Future instance to Assert
     * @param duration The duration to wait for the Future to complete
     * @since 1.1
	 */
	default <T> void assertFailure(Future<T> future, Duration duration) {
    	assertComplete(future, duration);

    	//now we know the future is complete, assert the result
    	assertFailure(future);
	}
}

