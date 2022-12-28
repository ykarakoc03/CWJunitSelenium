package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTestReport {


    protected WebDriver driver;

    protected ExtentReports extentReports;//raporlama işlemini gerçekleştirir

    protected ExtentHtmlReporter extentHtmlReporter; //raporu HTML olarak düzenler

    protected ExtentTest extentTest;//testimizin pass veya fail oldugunu saklayan objemiz.
                                    //Ekran görüntüleri içinde kullanılır

    @Before
    public void setup() {
        //Driver obj oluşturduk, konfigure ettik
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Extent report objelerimizi de oluşturuyoruz
        extentReports = new ExtentReports();

        //kaydedeceğimiz dosya için uniq olacak sekilde strin oluşturduk
        String currentDate=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        String filePath= System.getProperty("user.dir")+"/test-output/reports/testReport_"+currentDate+".html";

        //Html raporu oluşturacak obj dosya yoluyla initialize edildi
        extentHtmlReporter = new ExtentHtmlReporter(filePath);

        //Raporlama yapan extentreport obj HTML reporte baglandı
        extentReports.attachReporter(extentHtmlReporter);

        //rapor ile alakalı bilgiler verildi
       extentReports.setSystemInfo("Environment","QA");
       extentReports.setSystemInfo("Browser","Chrome");

       //HTML raporlarında görüntülemek istediğimiz konfigurasyonlar yapıldı
       extentHtmlReporter.config().setDocumentTitle("CWReport");
       extentHtmlReporter.config().setReportName("Test run report");

    }

    @After
    public void tearDown() throws InterruptedException {
        // test sonrasinda driver kapatmak (varsa raporlari dosyalamak) icin kullanilir.
        Thread.sleep(3000);
        driver.quit();
        extentReports.flush();
    }
}
