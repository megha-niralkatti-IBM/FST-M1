import time

from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    wait = WebDriverWait(driver, 20)
    driver.get("http://alchemy.hguy.co/crm")
    driver.find_element(By.ID,"user_name").send_keys("admin")
    driver.find_element(By.ID,"username_password").send_keys("pa$$w0rd")
    driver.find_element(By.XPATH,"//input[@id=\"bigbutton\"]").click()
    driver.find_element(By.ID,"grouptab_0").click()

    wait = WebDriverWait(driver, 20)

    tab = wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, "a[href*='index%26parentTab%3DSales'][id='moduleTab_9_Accounts']")))
    tab.click()
    time.sleep(3)

    odd_rows = driver.find_elements(By.XPATH, "//*[@class='oddListRowS1']")
    print("Total odd data rows found in table:", len(odd_rows))

    for i in range(0, len(odd_rows), 1):
        row = odd_rows[i]
        name = row.find_element(By.XPATH, ".//td[3]").text  # Assuming the name is in the third column (td[3])
        print("Name:", name)

        # Stop after printing the names of the first 5 odd-numbered rows
        if i >= 4:
            break

