package BaseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private static final int maxTry = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess() && count < maxTry) {
            count++;
            return true;
        }
        return false;
    }
}