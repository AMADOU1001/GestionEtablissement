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

public class SeleniumEtudiantTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAjouterEtSupprimerEtudiant() {
        driver.get("http://127.0.0.1:8080/etudiant.html");

        // Remplir le formulaire
        WebElement nomField = driver.findElement(By.id("nom"));
        WebElement prenomField = driver.findElement(By.id("prenom"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement matriculeField = driver.findElement(By.id("matricule"));
        WebElement submitButton = driver.findElement(By.cssSelector("form button[type='submit']"));
        
        nomField.sendKeys("Test");
        prenomField.sendKeys("Selenium");
        emailField.sendKeys("test@selenium.com");
        matriculeField.sendKeys("123456");
        submitButton.click();
        
        // Attendre l'alerte et la fermer
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        // Vérifier que l'étudiant a été ajouté dans le tableau
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='Test']")));

        // Supprimer l'étudiant ajouté
        WebElement deleteButton = driver.findElement(By.xpath("//td[text()='Test']/following-sibling::td/button"));
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
