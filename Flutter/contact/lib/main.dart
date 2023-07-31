import 'package:flutter/material.dart';

void main() {
  runApp(
      MaterialApp(
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

  var a = 1;
  var total = 3;
  var person = [['메시', 0, '010-1234-5678'], ['날강두', 0, '010-1234-5678'], ['홀란', 0, '010-1234-5678']];
  // var cnt = [0, 0, 0];
  var title = 'Contact';

  changeNumber(){
    setState(() {
      total++;
    });
  }

  changeState(value){
    setState(() {
      person.add(value);
    });
  }

  deleteState(idx){
    setState(() {
      person.removeAt(idx);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      floatingActionButton: FloatingActionButton(
        onPressed: (){
          showDialog(context: context, builder: (context){
            return Dialog(
              child: Modal(state: title, changeNumber: changeNumber, changeState:changeState)
            );
          });
        },
      ),
      appBar: AppBar(title: Text(total.toString()),),
      body: ListView.builder(
          itemCount: person.length,
          itemBuilder: (c,i){
            return ListTile(
              leading: Text(person[i][1].toString()),
              title: Row(
                crossAxisAlignment: CrossAxisAlignment.end,
                children: [
                  Text(person[i][0].toString()),
                  Text('     '),
                  Text(person[i][2].toString()),
                  Text(' '),
                  TextButton(onPressed: (){
                    deleteState(i);
                  }, child: Text('삭제'))
                ],
              ),
              trailing: TextButton(
                child: Text('좋아요'),
                onPressed: (){
                  setState(() {
                    person[i][1] = (person[i][1] as int) +1;
                  });
                },
              ),
            );
          }
      ),
    );
  }
}

class Modal extends StatelessWidget {
  Modal({super.key, this.state, this.changeNumber, this.changeState});
  final state;
  final changeNumber;
  var changeState;
  var inputData = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 400,
      margin: EdgeInsets.fromLTRB(30, 0, 30, 0),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            margin: EdgeInsets.all(30),
            child: Text(state, style: TextStyle(fontSize: 40, fontWeight: FontWeight.w900)),
          ),
          Container(
            margin: EdgeInsets.all(30),
            child: TextField( controller: inputData, style: TextStyle(fontSize: 30),),
          ),
          Container(
            margin: EdgeInsets.all(30),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: [
                Container(
                  margin: EdgeInsets.fromLTRB(20, 0, 20, 0),
                  child: TextButton(onPressed: (){
                    Navigator.pop(context);
                  }, child: Text('Cencel', style: TextStyle(fontSize: 25, fontWeight: FontWeight.bold),)),
                ),
                Container(
                  margin: EdgeInsets.fromLTRB(20, 0, 20, 0),
                  child: TextButton(onPressed: (){
                    if (inputData.text != ''){
                      changeState([inputData.text.toString(), 0, '010-1234-5678']);
                      Navigator.pop(context);
                    }
                  }, child: Text('OK', style: TextStyle(fontSize: 25, fontWeight: FontWeight.bold),)),
                ),
              ],
            ),
          )
        ],
      ),
    );
  }
}
