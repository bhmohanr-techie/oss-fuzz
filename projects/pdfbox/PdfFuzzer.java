// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////

import java.io.IOException;
import java.util.logging.LogManager;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.MemoryUsageSetting;

public class PdfFuzzer {
  // Limit memory usage to 100 MB.
  static final long MEMORY_LIMIT_BYTES = 100_000_000;

  public static void fuzzerInitialize() {
    // Disable logging.
    LogManager.getLogManager().reset();
  }

  public static void fuzzerTestOneInput(byte[] input) {
    try {
      Loader.loadPDF(input,
              null,
              null,
              null,
              MemoryUsageSetting.setupMainMemoryOnly(MEMORY_LIMIT_BYTES));
    } catch (IOException ignored) { }
  }
}