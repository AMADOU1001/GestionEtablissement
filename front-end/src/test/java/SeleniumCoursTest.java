import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumCoursTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAjouterEtSupprimerCours() {
        driver.get("http://127.0.0.1:8080/cours.html");

        // Remplir le formulaire
        WebElement titreField = driver.findElement(By.id("titre"));
        WebElement descriptionField = driver.findElement(By.id("description"));
        WebElement nombreHeuresField = driver.findElement(By.id("nombreHeures"));
        WebElement submitButton = driver.findElement(By.cssSelector("form button[type='submit']"));
        
        titreField.sendKeys("Test Selenium");
        descriptionField.sendKeys("Description du test");
        nombreHeuresField.sendKeys("10");
        submitButton.click();
        
        // Attendre l'alerte et la fermer
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        // Vérifier que le cours a été ajouté dans le tableau
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='Test Selenium']")));

        // Supprimer le cours ajouté
        WebElement deleteButton = driver.findElement(By.xpath("//td[text()='Test Selenium']/following-sibling::td/button"));
        deleteButton.click();

        // Attendre la confirmation et l'accepter
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
