package TestNG_Listeners;

import org.testng.*;

public class Listeneres implements ITestListener, IExecutionListener, IInvokedMethodListener {
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success");
    }
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failure");
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped");
    }
    public void onExecutionStart() {
        System.out.println("Execution Starts");
    }
    public void onExecutionFinish() {
        System.out.println("Execution Finishes");
    }
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod()){
            System.out.println("Test Case starts");
        } else if (method.isConfigurationMethod()) {
            System.out.println("Config Method Starts");
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Test Case Finished");
    }
}
