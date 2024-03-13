from urllib.request import urlopen
from bs4 import BeautifulSoup


html = urlopen("https://news.naver.com/")
bsObject = BeautifulSoup(html, "html.parser")

# 위 네이버 뉴스 링크 경로에서 img 태그를 모두 찾은 다음 
# 해당 link에 있는 scr 경로를 조회하는 코드
for link in bsObject.find_all("img"):
    print(link.text.strip(), link.get("src"))

