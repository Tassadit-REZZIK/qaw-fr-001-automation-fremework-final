package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragDropAndFrame {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0); // pour rentrer dans le frame mais il faut vérifier qu'il y'a un seul au niveau du ctrlF (code html)
        System.out.println("switch to frame success");

        Thread.sleep(3000);

        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).build().perform();

        Thread.sleep(3000);

        driver.switchTo().parentFrame();
        System.out.println("switch to parent frame success");
        driver.findElement(By.xpath("//a[normalize-space()='Demos']")).click(); //ici on a cliqué sur Demoen utilisant la page parent
        // si on avait utilisé la frame(driver.switchTo().frame(0);) ça ne va pas marcher

        Thread.sleep(3000);

        driver.close();

    }
}