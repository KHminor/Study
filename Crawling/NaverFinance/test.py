import os
import pandas as pd
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from io import StringIO
import time

chrome_options = Options()
chrome_options.add_experimental_option("detach", True)

browser = webdriver.Chrome(options=chrome_options)
browser.maximize_window() # 창 최대화

# 1. 페이지 이동
url = "https://chat.openai.com/"
browser.get(url)

# 페이지가 로드될 때까지 잠시 대기
time.sleep(2)

# 로그인 링크를 찾아 클릭
login_link = browser.find_element(By.XPATH,'//*[@id="__next"]/div[1]/div[2]/div[1]/div/div/button[1]')
login_link.click()