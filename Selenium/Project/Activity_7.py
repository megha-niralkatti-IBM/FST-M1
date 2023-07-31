import time

from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.action_chains import ActionChains
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
    #leads = wait.until(expected_conditions.visibility_of_element_located(By.CSS_SELECTOR,"a[href*='index%26parentTab%3DSales'][id='moduleTab_9_Leads']"))
    #leads.click()
    #leads = wait.until(expected_conditions.visibility_of_element_located((By.XPATH,"//*[@id='moduleTab_9_Leads']")))
    #leads.click()
    #i = wait.until(expected_conditions.visibility_of_element_located(By.XPATH,"//*[@class='oddListRowS1'][1]/td[10]"))
    #i.click()
    wait = WebDriverWait(driver, 20)  # Set the timeout to 20 seconds

    # Wait for the element to be visible and then click on it
    leads_tab = wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, "a[href*='index%26parentTab%3DSales'][id='moduleTab_9_Leads']")))
    leads_tab.click()

    # Wait for the element to be visible and then click on it
    row_element = wait.until(EC.visibility_of_element_located((By.XPATH, "//*[@class='oddListRowS1'][1]/td[10]")))
    row_element.click()

    time.sleep(3)



    builder = ActionChains(driver)
    # Locate the popup
    #popupElement = driver.find_element_by_xpath("//span[@class='phone']")
    popupElement = driver.find_element(By.XPATH,"//span[@class='phone']")
    builder.move_to_element(popupElement).perform()

    # Retrieve the text or content of the popup
    tooltipMessage = popupElement.text
    print("Mobile:" + tooltipMessage)

    driver.quit()