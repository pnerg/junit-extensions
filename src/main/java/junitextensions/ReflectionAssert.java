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

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Assert;

/**
 * Provides additional assert operations related to the reflective operations.
 * 
 * @author Peter Nerg
 * @since 1.1
 */
public interface ReflectionAssert extends NotNullAssert {

	/**
	 * Asserts that the provided class has a private default (non-argument) constructor. <br>
	 * This is a stupid workaround to please the coverage tools that otherwise whine about not covering private constructors.
	 * 
	 * @param <T>
	 *            The type created by the constructor
	 * @param clazz
	 *            The class to test the private constructor on
	 * @since 1.1
	 */
	default <T extends Object> void assertPrivateConstructor(Class<T> clazz) {
		assertObjectNotNull(clazz);
		Constructor<T> constructor = null;
		try {
			constructor = clazz.getDeclaredConstructor();
		} catch (ReflectiveOperationException ex) {
			throw new AssertionError("Class [" + clazz + "] has not a default constructor", ex);
		}

		try {
			Assert.assertTrue("Expected the constuctor to be private", Modifier.isPrivate(constructor.getModifiers()));
			constructor.setAccessible(true);
			constructor.newInstance();
		} catch (ReflectiveOperationException ex) {
			throw new AssertionError("Failed to create instance of [" + clazz + "]", ex);
		} finally {
			constructor.setAccessible(false);
		}

	}
}
