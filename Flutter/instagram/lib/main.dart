import 'dart:js_interop';

import 'package:flutter/material.dart';
import './style.dart' as style;
import 'package:http/http.dart' as http;
import 'dart:convert';


void main() {
  runApp(
    MaterialApp(
      theme: style.theme,
      home: MyApp()
    )
  );
}



class MyApp extends StatefulWidget {
  MyApp({super.key});
  
  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  var homeData = [];

  getData() async{
    var result = await http.get(Uri.parse('https://codingapple1.github.io/app/data.json'));
    if (result.statusCode == 200) {
      setState(() {
        homeData = jsonDecode(result.body);
      });
    } else {
      print('실패');
    }
  }

  @override
  void initState() {
    super.initState();
    getData();
  }

  // 0: home, 1: shop
  var tab = 0;

  changeTab(tabNumber){
    setState(() {
      tab = tabNumber;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Instagram'),
          actions: [
            IconButton(
              onPressed: (){},
              icon: Icon(Icons.add_box_outlined)
            )
          ],
        ),
      body: [Home(homeData:homeData),Text('shop')][tab],
      bottomNavigationBar: BottomNavigationBar(
        onTap: (i){
          changeTab(i);
        },
        items: [
          BottomNavigationBarItem(
            icon: Icon(Icons.home_outlined),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.shopping_bag_outlined),
            label: 'Shopping',
          ),
        ],
        showSelectedLabels: false, // 선택된 아이템의 레이블 숨김
        showUnselectedLabels: false, // 선택되지 않은 아이템의 레이블 숨김
      ),
    );
  }
}

class Home extends StatelessWidget {
  Home({super.key, this.homeData});
  final homeData;
  @override
  Widget build(BuildContext context) {
    if (homeData.isNotEmpty){
      return ListView.builder(
        itemCount: homeData.length,
        itemBuilder: (context, idx){
          return Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Image.network(homeData[idx]['image']),
              Container(
                margin: EdgeInsets.fromLTRB(10, 20, 10, 20),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(
                      children: [
                        Text('좋아요', style: TextStyle(fontSize: 15, fontWeight: FontWeight.w700),),
                        Text(homeData[idx]['likes'].toString(), style: TextStyle(fontSize: 15, fontWeight: FontWeight.w700)),
                      ],
                    ),
                    Text(homeData[idx]['date'].toString()),
                    Text(homeData[idx]['content'].toString()),
                  ],
                ),
              )
            ],
          );
        },
      );
    } else {
      return Text('빈');
    }
  }
}