
  package org.agoncal.application.api_tests;

  import com.intuit.karate.Results;
  import com.intuit.karate.Runner;
  // import com.intuit.karate.http.HttpServer;
  // import com.intuit.karate.http.ServerConfig;
  import org.junit.jupiter.api.Test;

  import static org.junit.jupiter.api.Assertions.assertEquals;

  class ResourcePoolManagement2Test {

      @Test
      void testAll() {
          
          Results results = Runner.path("src/test/java/org/agoncal/application/api_tests/ResourcePoolManagement2")
                  
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
