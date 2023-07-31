from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/crm")
    print("done")
    expected_string = driver.title
    print(expected_string)
    actual_string = "SuiteCRM"
    print("DONE2")
    assert expected_string == actual_string
    driver.quit()

if __name__ == "__main__":
    pytest.main()
