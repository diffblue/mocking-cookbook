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

public class Main {

  public static int invokesPublicInstanceMethodReturn42(MockMe mockMe) {
    return mockMe.publicInstanceMethodReturn42();
  }

  public static int invokesPublicInstanceMethodWithArgsReturn42(MockMe mockMe) {
    return mockMe.publicInstanceMethodWithArgsReturn42(1, "s");
  }

  public static void invokesPublicInstanceVoidMethodThrowIllegalStateException(MockMe mockMe) {
    mockMe.publicInstanceVoidMethodThrowIllegalStateException();
  }

  public static int invokesPublicFinalInstanceMethodReturn42(MockMe mockMe) {
    return mockMe.publicFinalInstanceMethodReturn42();
  }
}
