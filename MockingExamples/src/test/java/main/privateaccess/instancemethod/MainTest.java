/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package main.privateaccess.instancemethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "main.privateaccess.instancemethod.MockMe")
public class MainTest {

  /**
   * (Example 2) (PowerMockito) .when(instance, method_name).thenReturn(value)
   */
  @Test
  public void mockPrivateInstanceMethod() throws Exception {
    MockMe mockMe = PowerMockito.spy(new MockMe());
    PowerMockito.when(mockMe, "privateInstanceMethodReturn42").thenReturn(12);
    assertEquals(12, Main.invokesPrivateInstanceMethodReturn42(mockMe));
  }

  /**
   * (PowerMockito) when(instance, method_name, args_or_matchers...).thenReturn(value)
   */
  @Test
  public void mockPrivateInstanceMethodWithArgs() throws Exception {
    MockMe mockMe = PowerMockito.spy(new MockMe());
    PowerMockito.when(mockMe, "privateInstanceMethodWithArgsReturn42", 1, "s").thenReturn(12);
    assertEquals(12, Main.invokesPrivateInstanceMethodWithArgsReturn42(mockMe));
  }

  /**
   * (PowerMockito) when(instance, method_name, args_or_matchers...).thenReturn(value)
   */
  @Test
  public void mockPrivateInstanceMethodWithArgMatchers() throws Exception {
    MockMe mockMe = PowerMockito.spy(new MockMe());
    PowerMockito.when(mockMe, "privateInstanceMethodWithArgsReturn42", ArgumentMatchers.anyInt(),
        ArgumentMatchers.anyString()).thenReturn(12);
    assertEquals(12, Main.invokesPrivateInstanceMethodWithArgsReturn42(mockMe));
  }

  /**
   * (PowerMockito) doThrow(exception).when(instance, method_name, args_or_matchers...)
   */
  @Test
  public void mockPrivateVoidInstanceMethodWithArgMatchers() throws Exception {
    MockMe mockMe = PowerMockito.spy(new MockMe());
    PowerMockito.doThrow(new IllegalArgumentException())
        .when(mockMe, "privateInstanceMethodWithArgsThrowIllegalStateException",
            ArgumentMatchers.anyInt(),
            ArgumentMatchers.anyString());
    assertThrows(IllegalArgumentException.class,
        () -> Main.invokesPrivateVoidInstanceMethodWithArgsThrowIllegalStateException(mockMe));
  }
}
