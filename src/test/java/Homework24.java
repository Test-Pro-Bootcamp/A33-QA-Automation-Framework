String gridURL = " http://192.168.0.248:4444";

public WebDriver pickBrowser(String browser, Map<String, String> variantCapabilities) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities(); // Create a new DesiredCapabilities object
        String gridURL = "http://192.168.0.248:4444"; // Set the URL for the Selenium Grid

        if (variantCapabilities != null) {
        caps.merge(new DesiredCapabilities(variantCapabilities)); // Merge any variant capabilities into the DesiredCapabilities object
        }

        switch (browser) {
        case "firefox":
        WebDriverManager.firefoxdriver().setup(); // Set up the FirefoxDriver executable using WebDriverManager
        FirefoxOptions firefoxOptions = new FirefoxOptions(); // Create a new FirefoxOptions object
        firefoxOptions.addPreference("dom.webnotifications.enabled", false); // Disable web notifications
        return new FirefoxDriver(firefoxOptions.merge(caps)); // Launch Firefox with the specified options and capabilities

        case "MicrosoftEdge":
        WebDriverManager.edgedriver().setup(); // Set up the EdgeDriver executable using WebDriverManager
        EdgeOptions edgeOptions = new EdgeOptions(); // Create a new EdgeOptions object
        edgeOptions.addArguments("--remote-allow-origins=*"); // Allow remote origins
        return new EdgeDriver(edgeOptions.merge(caps)); // Launch Edge with the specified options and capabilities

        case "grid-edge":
        caps.setCapability("browserName", "MicrosoftEdge"); // Set the browser capability to Microsoft Edge
        return new RemoteWebDriver(URI.create(gridURL).toURL(), caps); // Launch a remote WebDriver instance with the specified capabilities

        case "grid-firefox":
        caps.setCapability("browserName", "firefox"); // Set the browser capability to Firefox
        return new RemoteWebDriver(URI.create(gridURL).toURL(), caps); // Launch a remote WebDriver instance with the specified capabilities

        case "grid-chrome":
        caps.setCapability("browserName", "chrome"); // Set the browser capability to Chrome
        return new RemoteWebDriver(URI.create(gridURL).toURL(), caps); // Launch a remote WebDriver instance with the specified capabilities

default:
        WebDriverManager.chromedriver().setup(); // Set up the ChromeDriver executable using WebDriverManager
        ChromeOptions options = new ChromeOptions(); // Create a new ChromeOptions object
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized"); // Disable notifications, allow remote origins, launch in incognito mode, and start maximized
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Exclude the enable-automation switch
        return new ChromeDriver(options.merge(caps)); // Launch Chrome with the specified options and capabilities
        }
        }
