package is.toxic.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public enum BrowserDriver {
    CHROME {
        public WebDriver create(){
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
            return new ChromeDriver();
        }
    },
    IE {
        public WebDriver create(){
            System.setProperty("webdriver.ie.driver", "src\\main\\resources\\drivers\\IEDriverServer.exe");
            return new InternetExplorerDriver();
        }
    },
    FIREFOX {
        public WebDriver create() {
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\drivers\\geckodriver.exe");
            return new FirefoxDriver();
        }
    },
    OPERA{
        public WebDriver create() {
            System.setProperty("webdriver.opera.driver", "src\\main\\resources\\drivers\\operadriver.exe");
            return new OperaDriver();
        }
    };

    public WebDriver create(){
        return null;
    }
}
