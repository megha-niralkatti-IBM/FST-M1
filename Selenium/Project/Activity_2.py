from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/crm")

   # img = driver.find_element_by_xpath("//img[@alt='SuiteCRM']")
    img = driver.find_element(By.XPATH, "//img[@alt='SuiteCRM']")
    src = img.get_attribute("src")

    print("URL of the header image: " + src)

    driver.quit()