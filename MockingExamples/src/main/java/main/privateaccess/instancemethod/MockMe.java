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

public class MockMe {

  public int invokesPrivateInstanceMethodReturn42() {
    return privateInstanceMethodReturn42();
  }

  private int privateInstanceMethodReturn42() {
    return 42;
  }

  public int invokesPrivateInstanceMethodWithArgsReturn42() {
    return privateInstanceMethodWithArgsReturn42(1, "s");
  }

  private int privateInstanceMethodWithArgsReturn42(int i, String s) {
    return 42;
  }

  public void invokesPrivateVoidInstanceMethodWithArgsThrowIllegalStateException() {
    privateInstanceMethodWithArgsThrowIllegalStateException(1, "s");
  }

  private void privateInstanceMethodWithArgsThrowIllegalStateException(int i, String s) {
    throw new IllegalStateException();
  }
}
