import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  MyApp({super.key});
  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  var a = 1;
  var name = ['메시', '날강두', '홀란'];
  var cnt = [0, 0, 0];

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(),
        body: ListView.builder(
            itemCount: 3,
            itemBuilder: (c,i){
              return ListTile(
                leading: Text(cnt[i].toString()),
                title: Text(name[i]),
                trailing: TextButton(
                  child: Text('좋아요'),
                  onPressed: (){
                    setState(() {
                      cnt[i]++;
                    });
                  },
                ),
              );
            }
        ),
      ),
    );
  }
}