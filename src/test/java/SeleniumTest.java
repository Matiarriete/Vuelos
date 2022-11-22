import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    static String mail = "matias.arriete@solera.com";
    static String pass = "Prueba123";
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Matias.Arriete\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver.manage().window().maximize();
        //Primer ejercicio
//        driver.get("https://accounts.lambdatest.com");
//        signInLambda();
        //Segundo ejercicio
//        driver.get("https://google.com");
//        busquedaGoogle();
        //Ejercicio vuelos
        driver.get("https://www.flightsfinder.com/");
//        String[] salidas = new String[];
    }
    static void espera(int t){
        try {Thread.sleep(t);
        } catch (Exception e){
        }
    }

    static void registerLambdaTest(){
        WebElement btnSignUp = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/div/div[3]/p/span/span[2]/a"));
        btnSignUp.click();
        espera(4000);
        WebElement inputSignUpName = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/form/div[1]/input"));
        inputSignUpName.sendKeys("Matias Arriete Cabaneros");
        WebElement inputSignUpUser = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/form/div[2]/input"));
        inputSignUpUser.sendKeys(mail);
        WebElement inputSignUpPass = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/form/div[3]/div/input"));
        inputSignUpPass.sendKeys(pass);
        WebElement inputSignUpPhone = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/form/div[4]/div[1]/input"));
        inputSignUpPhone.sendKeys("611228127");
        WebElement inputCheckBox = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/form/div[5]/label/samp"));
        inputCheckBox.click();
        WebElement btnSignUpSection = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/form/div[6]/button"));
        btnSignUpSection.click();
    }

    static void signInLambda(){
        WebElement inputUser = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/div/form/div[1]/input"));
        inputUser.sendKeys(mail);
        WebElement inputPass = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/div/form/div[2]/div/input"));
        inputPass.sendKeys(pass);
        WebElement btnLogIn = driver.findElement(By.id("login-button"));
        btnLogIn.click();

        try {
            modifyLambda();
        } catch (Exception e){
            registerLambdaTest();
        }
    }

    static void modifyLambda(){
        espera(4000);
        WebElement btnUser = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div[4]/div[5]/a"));
        btnUser.click();
        WebElement btnProfile = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div[4]/div[5]/div/a[2]"));
        btnProfile.click();
        espera(4000);
        WebElement modifyName = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/div/div[2]/div/div/div[2]/div[1]/div/form/div[2]/input"));
        modifyName.clear();
        modifyName.sendKeys("PruebaSeleniumMati");
        WebElement btnModify = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/div/div[2]/div/div/div[2]/div[1]/div/form/div[4]/button"));
        btnModify.click();
    }

    static void busquedaGoogle(){
        WebElement acceptCookies = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]"));
        acceptCookies.click();
        WebElement busqueda = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        busqueda.sendKeys("most viewed science fiction movie trailer ever");
        busqueda.sendKeys(Keys.ENTER);
        WebElement videosTab = driver.findElement(By.xpath("/html/body/div[7]/div/div[4]/div/div[1]/div/div[1]/div/div[2]/a"));
        videosTab.click();
        WebElement selectVideo = driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div/div[2]/div[2]/div/div/div[2]" +
                "/div/video-voyager/div/div[1]/div[2]/div/div[1]/a"));
        selectVideo.click();
        WebElement acceptCookiesYoutube = driver.findElement(By.xpath("/html/body/ytd-app/ytd-consent-bump-v2-lightbox/tp-yt-paper-dialog" +
                "/div[4]/div[2]/div[6]/div[1]/ytd-button-renderer[2]/yt-button-shape/button"));
        acceptCookiesYoutube.click();
        espera(7000);
        WebElement skipAds = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[1]" +
                "/div[2]/div/div/ytd-player/div/div/div[4]/div/div[3]/div/div[2]/span/button"));
        skipAds.click();

    }

    static String buscarPrecioVuelo(String destino, String salida){
        WebElement desplegable = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div[1]/div[1]/p"));
        desplegable.click();
        WebElement seleccion = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div[1]/div[1]/div/label[2]"));
        seleccion.click();
        WebElement origenInput = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div[2]/div[1]/div/input"));
        origenInput.sendKeys(salida);
        WebElement destinoInput = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div[2]/div[2]/div/input"));
        destinoInput.click();
        destinoInput.sendKeys(destino);
        WebElement fecha = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div[2]/div[3]/div/input[1]"));
        fecha.click();
        for (int i = 0; i < 2; i++) {
            WebElement flechaDerecha = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div[2]/div[3]/div/div/div/div/div/div/div[1]/div[4]"));
            flechaDerecha.click();
        }
        WebElement seleccionFecha = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div[2]/div[3]/div/div/div/div/div/div/table/tbody/tr[4]/td[1]/div"));
        seleccionFecha.click();
        WebElement chkBox = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div[5]/div/label/span"));
        chkBox.click();
        WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/form/div[5]/div/button"));
        btnBuscar.click();
        espera(15000);
        WebElement frame = driver.findElement(By.id("fzone52"));
        driver.switchTo().frame(frame);
        WebElement precio = driver.findElement(By.cssSelector(".price-text"));
        return precio.getText();
    }
}