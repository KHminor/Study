import os
import pandas as pd
from selenium import webdriver
from selenium.webdriver.common.by import By
from io import StringIO

browser = webdriver.Chrome()
browser.maximize_window() # 창 최대화

# 1. 페이지 이동
url = "https://finance.naver.com/sise/sise_market_sum.naver?sosok=0&page="
browser.get(url)

# 2. 조회 항목 초기화 (체크되어 있는 항목 체크 해제)
checkboxes = browser.find_elements(By.NAME, "fieldIds")
for checkbox in checkboxes:
    if checkbox.is_selected(): # 체크된 상태라면?
        checkbox.click() # 클릭하여 (체크 해제)

# 3. 조회 항목 설정 (원하는 항목 체크)
# items_to_select = {"영업이익", "자산총계", "매출액"}
items_to_select = {"시가", "고가", "저가"}
for checkbox in checkboxes: # 부모인 td 태그의 자식인 label의 innertext찾기
    parent = checkbox.find_element(By.XPATH, "..") # 부모 element 찾기 -> 즉 td 태그 지정
    label = parent.find_element(By.TAG_NAME, "label")
    if label.text in items_to_select:
        checkbox.click() # 선택항목 클릭

# 4. 적용하기 클릭
# //를 붙여주는건 전체 html에서 찾겠다는 의미이며 전체 a태그에서 @href 속성을 찾겠다는 것
btn_apply = browser.find_element(By.XPATH, "//a[@href='javascript:fieldSubmit()']") 
btn_apply.click()

idx = 1
while True:
    # 사전 작업: 페이지 이동
    browser.get(url+str(idx))


    # 5. 데이터 추출
    df = pd.read_html(StringIO(browser.page_source))[1] # data frame
    # axis=index는 행 기준으로 제거하겠다는 뜻. 그리고 how에 all이면 모두 NaN이면 지우기, any는 하나라도 있으면 지우기,
    # 그리고 inplace True를 하면 해당 요청을 그대로 df에 반영
    df.dropna(axis="index",how="all", inplace=True) 
    df.dropna(axis="columns",how="all", inplace=True) 
    # df.head(10) # 해당 프레임의 데이터를 10개만 가져오겠다라는 뜻.

    # 데이터 체크
    if len(df) == 0: break

    # 6. 파일 저장
    f_name = "sise.csv"
    if os.path.exists(f_name): # 파일이 존재한다면? 헤더 제외, mode의 a는 append
        df.to_csv(f_name, encoding="utf-8-sig", index=False, mode='a', header=False)
    else: # 파일이 없다면? 헤더를 포함, 기본 mode는 쓰기
        df.to_csv(f_name, encoding='utf-8-sig', index=False)

    print("%d 페이지 완료"%idx)
    idx += 1
print("모든 작업 완료")
browser.quit()