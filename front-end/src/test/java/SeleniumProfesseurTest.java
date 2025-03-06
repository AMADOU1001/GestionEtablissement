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

public class SeleniumProfesseurTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAjouterModifierEtSupprimerProfesseur() {
        driver.get("http://127.0.0.1:8080/professeurs.html");

        // Remplir le formulaire d'ajout
        WebElement nomField = driver.findElement(By.id("nom"));
        WebElement prenomField = driver.findElement(By.id("prenom"));
        WebElement specialiteField = driver.findElement(By.id("specialite"));
        WebElement submitButton = driver.findElement(By.cssSelector("form button[type='submit']"));
        
        nomField.sendKeys("Test");
        prenomField.sendKeys("Prof");
        specialiteField.sendKeys("Mathématiques");
        submitButton.click();
        
        // Attendre l'alerte et la fermer
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        // Vérifier que le professeur a été ajouté dans le tableau
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='Test']")));

        // Modifier le professeur
        WebElement editButton = driver.findElement(By.xpath("//td[text()='Test']/following-sibling::td/button[contains(text(),'Modifier')]"));
        editButton.click();

        // Modifier la spécialité
        specialiteField = driver.findElement(By.id("specialite"));
        specialiteField.clear();
        specialiteField.sendKeys("Physique");
        submitButton.click();

        // Attendre l'alerte et la fermer
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        // Vérifier que la modification a bien été prise en compte
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='Physique']")));

        // Supprimer le professeur
        WebElement deleteButton = driver.findElement(By.xpath("//td[text()='Test']/following-sibling::td/button[contains(text(),'Supprimer')]"));
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
