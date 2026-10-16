package TestNG_Listeners;

import org.testng.*;

public class ListeneresReport implements ITestListener, IExecutionListener, IInvokedMethodListener {

    public void onExecutionStart() {
        excecuteCommand(deleteJson);
    }
    public void onExecutionFinish() {
        excecuteCommand(generateReport);
    }
    String deleteJson = "cmd /c cd target/allure-results && del *.json";
    String generateReport = "cmd /c allure generate target/allure-results -o reports/ --clean --single-file";
    public static void excecuteCommand(String CMD){
        try{
            Process process = Runtime.getRuntime().exec(CMD);
            int res = process.waitFor();
            if(res == 0){
                System.out.println("Command line success");
            }
            else {
                System.out.println("command line faild");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
