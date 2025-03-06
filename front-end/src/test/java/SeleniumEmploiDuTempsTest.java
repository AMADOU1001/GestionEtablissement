import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumEmploiDuTempsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAjouterModifierEtSupprimerEmploiDuTemps() {
        driver.get("http://127.0.0.1:8080/emploidutemps.html");

        // Sélectionner un professeur
        WebElement professeurSelect = driver.findElement(By.id("professeur"));
        new Select(professeurSelect).selectByIndex(1);

        // Sélectionner un cours
        WebElement coursSelect = driver.findElement(By.id("cours"));
        new Select(coursSelect).selectByIndex(1);

        // Remplir les dates
        WebElement dateDebutField = driver.findElement(By.id("dateDebut"));
        WebElement dateFinField = driver.findElement(By.id("dateFin"));
        dateDebutField.sendKeys("2025-03-07T08:00");
        dateFinField.sendKeys("2025-03-07T10:00");

        // Cliquer sur Sauvegarder
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]"));
        submitButton.click();

        // Attendre l'alerte et la fermer
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        // Vérifier que l'emploi du temps a été ajouté
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(),'2025-03-07 08:00')]")));

        // Modifier l'emploi du temps
        WebElement editButton = driver.findElement(By.xpath("//td[contains(text(),'2025-03-07 08:00')]/following-sibling::td/button[contains(text(),'Modifier')]"));
        editButton.click();

        // Modifier la date de fin
        dateFinField = driver.findElement(By.id("dateFin"));
        dateFinField.clear();
        dateFinField.sendKeys("2025-03-07T12:00");
        submitButton.click();

        // Attendre l'alerte et la fermer
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        // Vérifier que la modification est bien prise en compte
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(),'2025-03-07 12:00')]")));

        // Supprimer l'emploi du temps
        WebElement deleteButton = driver.findElement(By.xpath("//td[contains(text(),'2025-03-07 08:00')]/following-sibling::td/button[contains(text(),'Supprimer')]"));
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
