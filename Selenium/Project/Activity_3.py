from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/crm")
    footertext = driver.find_element(By.XPATH,"//a[@id=\"admin_options\"]")
    print("footer_text ", footertext.text)
    driver.close()
