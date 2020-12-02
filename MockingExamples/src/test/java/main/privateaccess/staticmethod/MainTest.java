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

package main.privateaccess.staticmethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "main.privateaccess.staticmethod.MockMe")
public class MainTest {

  /**
   * (PowerMockito) when(class_object, methodName).thenReturn(value)
   */
  @Test
  public void mockPrivateStaticMethod() throws Exception {
    PowerMockito.spy(MockMe.class);
    PowerMockito.when(MockMe.class, "privateStaticMethodReturn42").thenReturn(12);
    assertEquals(12, Main.invokesPrivateStaticMethodReturn42());
  }

  /**
   * (PowerMockito) when(class_object, methodName, args_or_matchers).thenReturn(value)
   */
  @Test
  public void mockPrivateStaticMethodWithArgs() throws Exception {
    PowerMockito.spy(MockMe.class);
    PowerMockito.when(MockMe.class, "privateStaticMethodWithArgsReturn42", 1, "s").thenReturn(12);
    assertEquals(12, Main.invokesPrivateStaticMethodWithArgsReturn42());
  }

  /**
   * (PowerMockito) when(class_object, methodName, args_or_matchers).thenReturn(value)
   */
  @Test
  public void mockPrivateStaticMethodWithArgMatchers() throws Exception {
    PowerMockito.spy(MockMe.class);
    PowerMockito
        .when(MockMe.class, "privateStaticMethodWithArgsReturn42", ArgumentMatchers.anyInt(),
            ArgumentMatchers.anyString()).thenReturn(12);
    assertEquals(12, Main.invokesPrivateStaticMethodWithArgsReturn42());
  }

  /**
   * final methods are stubbed just like non-final ones
   */
  @Test
  public void mockPrivateStaticFinalMethod() throws Exception {
    PowerMockito.spy(MockMe.class);
    PowerMockito.when(MockMe.class, "privateStaticFinalMethodReturn42").thenReturn(12);
    assertEquals(12, Main.invokesPrivateStaticFinalMethodReturn42());
  }

  /**
   * final methods are stubbed just like non-final ones
   */
  @Test
  public void mockPrivateStaticFinalMethodWithArgs() throws Exception {
    PowerMockito.spy(MockMe.class);
    PowerMockito.when(MockMe.class, "privateStaticFinalMethodWithArgsReturn42", 1, "s")
        .thenReturn(12);
    assertEquals(12, Main.invokesPrivateStaticFinalMethodWithArgsReturn42());
  }

  /**
   * final methods are stubbed just like non-final ones
   */
  @Test
  public void mockPrivateStaticFinalMethodWithArgMatchers() throws Exception {
    PowerMockito.spy(MockMe.class);
    PowerMockito
        .when(MockMe.class, "privateStaticFinalMethodWithArgsReturn42", ArgumentMatchers.anyInt(),
            ArgumentMatchers.anyString()).thenReturn(12);
    assertEquals(12, Main.invokesPrivateStaticFinalMethodWithArgsReturn42());
  }

  /**
   * (PowerMockito) doThrow(exception).when(class_object, "method_name", args_or_matchers)
   */
  @Test
  public void mockPrivateStaticVoidMethod() throws Exception {
    PowerMockito.spy(MockMe.class);
    PowerMockito.doThrow(new IllegalArgumentException())
        .when(MockMe.class, "privateStaticMethodThrowIllegalStateException");
    assertThrows(IllegalArgumentException.class,
        () -> Main.invokesPrivateStaticMethodThrowIllegalStateException());
  }

  /**
   * (PowerMockito) doThrow(exception).when(class_object, "method_name", args_or_matchers)
   */
  @Test
  public void mockPrivateStaticVoidMethodWithArgMatchers() throws Exception {
    PowerMockito.spy(MockMe.class);
    PowerMockito.doThrow(new IllegalArgumentException())
        .when(MockMe.class, "privateStaticVoidMethodWithArgsThrowIllegalStateException",
            ArgumentMatchers.anyInt(),
            ArgumentMatchers.anyString());
    assertThrows(IllegalArgumentException.class,
        () -> Main.invokesPrivateStaticMethodWithArgsThrowIllegalStateException());
  }
}
