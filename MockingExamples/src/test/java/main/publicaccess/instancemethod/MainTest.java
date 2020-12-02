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

package main.publicaccess.instancemethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "main.publicaccess.instancemethod.MockMe")
public class MainTest {

  /**
   * (Example 1) (Mockito) when(methodCall()).thenReturn(value)
   */
  @Test
  public void mockPublicInstanceMethod() {
    MockMe mockMe = PowerMockito.mock(MockMe.class);
    Mockito.when(mockMe.publicInstanceMethodReturn42()).thenReturn(12);
    assertEquals(12, Main.invokesPublicInstanceMethodReturn42(mockMe));
  }

  /**
   * (Mockito) when(methodCall(method_arguments)).thenReturn(value)
   */
  @Test
  public void mockPublicInstanceMethodWithArgs() {
    MockMe mockMe = Mockito.mock(MockMe.class);
    Mockito.when(mockMe.publicInstanceMethodWithArgsReturn42(1, "s")).thenReturn(12);
    assertEquals(12, Main.invokesPublicInstanceMethodWithArgsReturn42(mockMe));
  }

  /**
   * (Mockito) when(methodCall(argument_matchers)).thenReturn(value)
   */
  @Test
  public void mockPublicInstanceMethodWithArgMatchers() {
    MockMe mockMe = Mockito.mock(MockMe.class);
    Mockito.when(mockMe
        .publicInstanceMethodWithArgsReturn42(ArgumentMatchers.anyInt(),
            ArgumentMatchers.anyString()))
        .thenReturn(12);
    assertEquals(12, Main.invokesPublicInstanceMethodWithArgsReturn42(mockMe));
  }

  @Test
  public void mockPublicFinalInstanceMethod() {
    MockMe mockMe = PowerMockito.mock(MockMe.class);
    PowerMockito.when(mockMe.publicFinalInstanceMethodReturn42()).thenReturn(12);
    assertEquals(12, Main.invokesPublicFinalInstanceMethodReturn42(mockMe));
  }

  /**
   * (Mockito) when(methodCall()).thenThrow(exception)
   */
  @Test
  public void mockPublicInstanceMethodToThrow() {
    MockMe mockMe = Mockito.mock(MockMe.class);
    Mockito.when(mockMe.publicInstanceMethodReturn42()).thenThrow(new IllegalArgumentException());
    assertThrows(IllegalArgumentException.class,
        () -> Main.invokesPublicInstanceMethodReturn42(mockMe));
  }

  /**
   * (PowerMockito) doThrow(exception).when(instance_name).methodCall()
   */
  @Test
  public void mockPublicVoidInstanceMethodToThrow() {
    MockMe mockMe = PowerMockito.mock(MockMe.class);
    PowerMockito.doThrow(new IllegalArgumentException()).when(mockMe)
        .publicInstanceVoidMethodThrowIllegalStateException();
    assertThrows(IllegalArgumentException.class,
        () -> Main.invokesPublicInstanceVoidMethodThrowIllegalStateException(mockMe));
  }

  @Test
  public void mockPublicVoidInstanceMethodToDoNothing() {
    MockMe mockMe = PowerMockito.mock(MockMe.class);
    Assertions
        .assertDoesNotThrow(
            () -> Main.invokesPublicInstanceVoidMethodThrowIllegalStateException(mockMe));
  }
}
