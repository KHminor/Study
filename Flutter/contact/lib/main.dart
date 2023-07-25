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
      //보통 Widget은 파스칼 케이스를 사용
      //그래서 글자를 넣고 싶다면 Text('글 내용')을 작성하면 된다.
      //그래서 이미지를 넣고 싶다면 Image.asset('경로')를 작성하면 된다. <-- 프로젝트 폴더 안에 위치해야 하고, pubspec.yaml에 등록을 해줘야 함.
      //그래서 아이콘를 넣고 싶다면 Icon(Icons.아이콘이름)을 작성하면 된다.
      //그래서 박스를 넣고 싶다면 Container(스타일 속성 추가하기) or SizedBox()를 작성하면 된다.
      // Flutter의 사이즈 단위는 LP라고 해서 현실에서 쓰는 cm, inch 단위랑 유사.
      // 1cm = 38LP
      // 50LP == 1.2cm

      // home: Text('안녕'),
      // home: Icon(Icons.shop),
      // home: Image.asset('JJangu.jpg'),

      //Center()는 내 하위 위젯의 기준점을 중앙으로 설정해주는 메서드
      home: Center(
        child: Container(width: 50, height: 50, color: Colors.blue),
      ),
    );
  }
}
