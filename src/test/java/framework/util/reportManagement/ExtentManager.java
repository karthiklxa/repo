package framework.util.reportManagement;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Created by karthik.m on 6/4/2018.
 */
public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance(String className) {
        if (extent == null) {
            extent = createInstance(className);
        }
        return extent;
    }

    public static ExtentReports createInstance(String fileName) {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(false);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);

        extent = new ExtentReports();
        extent.setAnalysisStrategy(AnalysisStrategy.TEST);
        extent.attachReporter(htmlReporter);

        return extent;
    }

    public static void quitExtent() {
        extent.flush();
        extent = null;
    }
}
