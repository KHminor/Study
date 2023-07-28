import 'package:flutter/material.dart';

void main() {
  //runApp 안에 있는 MyApp을 실행해달라는 코드
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          // title은 왼쪽 제목, leading은 왼쪽에 넣을 아이콘을 의미
          // actions는 우측에 넣을 아이콘들
          backgroundColor: Colors.white,
          title: Text('금호동3가', style: TextStyle(color: Colors.black, fontWeight: FontWeight.w900)),
          actions: [
            Row(
              children: [Icon(Icons.search), SizedBox(width: 20), Icon(Icons.menu), SizedBox(width: 20), Icon(Icons.notifications_none_sharp)],
            )
          ],
          actionsIconTheme: IconThemeData(color: Colors.black, size: 40),
          leading: Icon(Icons.access_time),
        ),
        body: Container(
          child: Row(
            children: [
              Expanded(
                flex: 3,
                child: Container(
                  height: 300,
                  alignment: Alignment.topCenter,
                  child: Image.asset('JJangu.jpg'),
                  margin: EdgeInsets.fromLTRB(15, 30, 15, 0),
                ),
              ),
              Expanded(
                flex: 7,
                child: Container(
                  height: 300,
                  margin: EdgeInsets.fromLTRB(15, 30, 15, 0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('캐논 DSLR 100D (단렌즈, 충전기 16기가SD 포함)', style: TextStyle(fontSize: 30, fontWeight: FontWeight.w700)),
                      Text('성동구 행당동 끌올 10분 전', style: TextStyle(fontSize: 12, color: Colors.grey, fontWeight: FontWeight.w700)),
                      Text('210.000원', style: TextStyle(fontSize: 16, fontWeight: FontWeight.w700)),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.end,
                        children: [
                          Icon(Icons.favorite_border, color: Colors.grey),
                          Text('4', style: TextStyle(fontSize: 20, color: Colors.grey, fontWeight: FontWeight.w300),)
                        ],
                      )
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
