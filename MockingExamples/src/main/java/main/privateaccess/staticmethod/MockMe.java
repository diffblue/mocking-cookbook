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

public class MockMe {

  public static int invokesPrivateStaticMethodReturn42() {
    return privateStaticMethodReturn42();
  }

  private static int privateStaticMethodReturn42() {
    return 42;
  }

  public static int invokesPrivateStaticFinalMethodReturn42() {
    return privateStaticFinalMethodReturn42();
  }

  private static final int privateStaticFinalMethodReturn42() {
    return 42;
  }

  public static int invokesPrivateStaticMethodWithArgsReturn42() {
    return privateStaticMethodWithArgsReturn42(1, "s");
  }

  private static int privateStaticMethodWithArgsReturn42(int i, String s) {
    return 42;
  }

  public static int invokesPrivateStaticFinalMethodWithArgsReturn42() {
    return privateStaticFinalMethodWithArgsReturn42(1, "s");
  }

  private static final int privateStaticFinalMethodWithArgsReturn42(int i, String s) {
    return 42;
  }

  public static void invokesPrivateStaticMethodThrowIllegalStateException() {
    privateStaticMethodThrowIllegalStateException();
  }

  private static void privateStaticMethodThrowIllegalStateException() {
    throw new IllegalStateException();
  }


  public static void invokePrivateStaticVoidMethodWithArgsThrowIllegalStateException() {
    privateStaticVoidMethodWithArgsThrowIllegalStateException(1, "s");
  }

  private static void privateStaticVoidMethodWithArgsThrowIllegalStateException(int i, String s) {
    throw new IllegalStateException();
  }
}
