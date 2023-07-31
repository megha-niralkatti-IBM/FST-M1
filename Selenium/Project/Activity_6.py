from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/crm")
    driver.find_element(By.ID,"user_name").send_keys("admin")
    driver.find_element(By.ID,"username_password").send_keys("pa$$w0rd")
    driver.find_element(By.XPATH,"//input[@id=\"bigbutton\"]").click()
    Activities = driver.find_element(By.XPATH,"//a[text() =\"Activities\"]")
    print("expected menu item is", Activities.text)
    driver.close()
