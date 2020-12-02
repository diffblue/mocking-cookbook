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

package main.publicaccess.staticmethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "main.publicaccess.staticmethod.MockMe")
public class MainTest {

  /**
   * (PowerMockito) when(methodCall()).thenReturn(value)
   */
  @Test
  public void mockPublicStaticMethod() {
    PowerMockito.mockStatic(MockMe.class);
    PowerMockito.when(MockMe.return42PublicStatic()).thenReturn(12);
    assertEquals(12, Main.invokesPublicStaticMethodReturn42());
  }

  /**
   * (PowerMockito) when(methodCall()).thenReturn(value)
   */
  @Test
  public void mockPublicStaticFinalMethod() {
    PowerMockito.mockStatic(MockMe.class);
    PowerMockito.when(MockMe.publicStaticFinalMethodReturn42()).thenReturn(12);
    assertEquals(12, Main.invokesPublicStaticFinalMethodReturn42());
  }

  /**
   * (PowerMockito) doThrow(exception).when(class); methodCall();
   */
  @Test
  public void mockPublicStaticVoidMethod() {
    PowerMockito.mockStatic(MockMe.class);
    PowerMockito.doThrow(new IllegalArgumentException()).when(MockMe.class);
    MockMe.publicStaticVoidThrowIllegalStateException();
    assertThrows(IllegalArgumentException.class,
        () -> Main.invokesPublicStaticVoidMethodThrowIllegalStateException());
  }

  /**
   * (PowerMockito) doThrow(exception).when(class); methodCall(args_or_matchers);
   */
  @Test
  public void mockPublicStaticVoidMethodWithArgs() {
    PowerMockito.mockStatic(MockMe.class);
    PowerMockito.doThrow(new IllegalArgumentException()).when(MockMe.class);
    MockMe.publicStaticVoidMethodWithArgsThrowIllegalStateException(ArgumentMatchers.anyInt(),
        ArgumentMatchers.anyString());
    assertThrows(IllegalArgumentException.class,
        () -> Main.invokesPublicStaticVoidMethodWithArgsThrowIllegalStateException());
  }
}
