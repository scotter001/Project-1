package TestLKH;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Testcase1.class})
public class AllTests {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Testcase1.class);
        for (Failure fa : result.getFailures()) {
            System.out.println(fa.toString());
        }
        System.out.println("Kết quả=="+result.wasSuccessful());
    }
}
