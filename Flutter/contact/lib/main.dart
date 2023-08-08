import 'package:flutter/material.dart';
import 'package:permission_handler/permission_handler.dart';
import 'package:contacts_service/contacts_service.dart';

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

  getPermission() async{
    var status = await Permission.contacts.status; // 연락처 권한을 주었는지 대한 여부
    if (status.isGranted) {
      print('허락됨');
      var contacts = await ContactsService.getContacts();
      setState(() {
        person = contacts;
      });
    } else if (status.isDenied) {
      print('거절됨');
      Permission.contacts.request(); // 허락해달라고 팝업띄우는 코드
    }
  }

  @override
  void initState() { // 위젯이 로드될 때 한번 실행
    super.initState();
    getPermission();
    // getPermission();
    // openAppSettings();
  }

  var a = 1;
  var total = 3;
  var person = [];
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
              child: Modal(state: title, changeNumber: changeNumber, changeState:changeState, getPermission:getPermission)
            );
          });
        },
      ),
      appBar: AppBar(title: Text(person.length.toString()),actions: [
        IconButton(onPressed: (){
          getPermission();
        }, icon: Icon(Icons.contacts))
      ],),
      body: ListView.builder(
          itemCount: person.length,
          itemBuilder: (c,i){
            return ListTile(
              leading: Icon(Icons.person),
              title: Text(person[i].givenName??'무명')
            );
          }
      ),
    );
  }
}

class Modal extends StatelessWidget {
  Modal({super.key, this.state, this.changeNumber, this.changeState, this.getPermission});
  final state;
  final changeNumber;
  final getPermission;
  var changeState;
  var inputData = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 400,
      margin: EdgeInsets.fromLTRB(5, 0, 5, 0),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            margin: EdgeInsets.all(5),
            child: Text(state, style: TextStyle(fontSize: 30, fontWeight: FontWeight.w900)),
          ),
          Container(
            margin: EdgeInsets.all(5),
              controller: inputData,
              style: TextStyle(fontSize: 30),
              decoration: InputDecoration(
                enabledBorder: UnderlineInputBorder(),
                icon:Icon(Icons.ac_unit_sharp),
                  hintText: "첫 째",
                  helperText: "둘 째",
                  labelText: '셋 째',
                  counterText: '넷 째'
              ),
            ),
          ),
          Container(
            margin: EdgeInsets.all(5),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: [
                Container(
                  margin: EdgeInsets.fromLTRB(5, 0, 5, 0),
                  child: TextButton(onPressed: (){
                    Navigator.pop(context);
                  }, child: Text('Cencel', style: TextStyle(fontSize: 25, fontWeight: FontWeight.bold),)),
                ),
                Container(
                  margin: EdgeInsets.fromLTRB(5, 0, 5, 0),
                  child: TextButton(onPressed: () async{
                    if (inputData.text != ''){
                      var newPerson = Contact();
                      newPerson.givenName = inputData.text.toString();
                      await ContactsService.addContact(newPerson);
                      await getPermission();
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
