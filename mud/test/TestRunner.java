import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(MudTestSuite.class);
      System.out.println("\nTests to be run");
      for (Class cls : MudTestSuite.class.getAnnotation(Suite.SuiteClasses.class).value()) {
            System.out.println("  " + cls.toString());
      }
            for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
     if(result.wasSuccessful())
         System.out.println("\nAll tests passed");
     else
        System.out.println("The tests failed\n");
   }
}
