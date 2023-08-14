import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import './style.dart' as style;
import 'package:http/http.dart' as http;
import 'dart:convert';
// 이미지 볼러오기
import 'package:image_picker/image_picker.dart';
import 'dart:io';
// shared_preferences
import 'package:shared_preferences/shared_preferences.dart';
// Local notification
import 'notification.dart';


void main() {
  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (c)=>Store1()),
        ChangeNotifierProvider(create: (c)=>Store2())
      ],
      child: MaterialApp(
        theme: style.theme,
        initialRoute: '/',
        routes: {
          '/': (c) => MyApp(),
          '/mypage': (c) => Text('마이 페이지')
        },
        // home: MyApp()
      ),
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

  appendData(value){
    setState(() {
      homeData.add(value);
    });
  }

  insertData(value){
    setState(() {
      homeData.insert(0,value);
    });
  }

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
    initNotification(context);
    getData();
  }

  // 0: home, 1: shop
  var tab = 0;
  var userImage;

  changeTab(tabNumber){
    setState(() {
      tab = tabNumber;
    });
  }

  saveData() async{
    var map = {'name': 'ki'};
    var storage = await SharedPreferences.getInstance();
    storage.setString('이름', jsonEncode(map));
    var result = storage.getString('이름')??'데이터가 없다.';
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      floatingActionButton: FloatingActionButton(
        child: Text('+'),
        onPressed: (){
          showNotification();
        },
      ),
        appBar: AppBar(
          title: Text('Instagram'),
          actions: [
            IconButton(
              onPressed: () async{
                var picker = ImagePicker();
                var image = await picker.pickImage(source: ImageSource.gallery);
                if (image != null) {
                  setState(() {
                    userImage = File(image.path);
                  });
                }
                Navigator.push(context,
                  MaterialPageRoute(builder: (c) => Upload(userImage:userImage, insertData:insertData, homeData:homeData)
                  )
                );
              },
              icon: Icon(Icons.add_box_outlined)
            )
          ],
        ),
      body: [Home(homeData:homeData, appendData:appendData),Text('shop')][tab],
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

// Home
class Home extends StatefulWidget {
  Home({super.key, this.homeData, this.appendData});
  final homeData;
  final appendData;

  @override
  State<Home> createState() => _HomeState();
}
class _HomeState extends State<Home> {

  // ScrollController() 는 자료를 저장해주는 것으로, 클래스가 된다. 그래서 스크롤 정보를 저장해주는 것을 하는데 도움을 준다
  var scroll = ScrollController();
  var cnt = 0;
  getAddData() async{
    cnt ++;
    var data = await http.get(Uri.parse('https://codingapple1.github.io/app/more${cnt}.json'));
    if (data.statusCode == 200){
      widget.appendData(jsonDecode(data.body));
    } else {
      print('더 이상 없어');
    }
  }
  
  @override
  void initState() {
    super.initState();
    scroll.addListener(() {
      if (scroll.position.pixels == scroll.position.maxScrollExtent) {
        getAddData();
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    if (widget.homeData.isNotEmpty){
      return ListView.builder(
        controller: scroll,
        itemCount: widget.homeData.length,
        itemBuilder: (context, idx){
          return Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              widget.homeData[idx]['image'].runtimeType == String?Image.network(widget.homeData[idx]['image']):Image.file(widget.homeData[idx]['image']),
              Container(
                margin: EdgeInsets.fromLTRB(10, 20, 10, 20),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(
                      children: [
                        Text('좋아요 ${widget.homeData[idx]['likes'].toString()}', style: TextStyle(fontSize: 15, fontWeight: FontWeight.w700),),
                      ],
                    ),
                    GestureDetector(
                      child: Text(widget.homeData[idx]['user']),
                      onTap: (){
                        Navigator.push(context, 
                          PageRouteBuilder(
                            pageBuilder: (c, a1, a2) => Profile(),
                            transitionsBuilder: (c, a1, a2, child) =>
                              SlideTransition(
                                position: Tween(
                                  begin: Offset(-1.0, 0.0),
                                  end: Offset(0.0, 0.0)
                                ).animate(a1),
                                child: child,
                              )
                          )
                        );
                      },
                    ),
                    Text(widget.homeData[idx]['date'].toString()),
                    Text(widget.homeData[idx]['content'].toString()),
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

// Upload
class Upload extends StatefulWidget {
  Upload({Key? key, this.userImage, this.insertData, this.homeData}) : super(key: key);
  @override
  final userImage;
  final insertData;
  final homeData;

  @override
  State<Upload> createState() => _UploadState();
}
class _UploadState extends State<Upload> {
  var inputValue = '';

  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(),
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('선택한 이미지'),
            Image.file(widget.userImage),
            TextField(onChanged: (val){setState(() {
              inputValue = val;
            });}),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                IconButton(
                    onPressed: (){
                      Navigator.pop(context);
                    },
                    icon: Icon(Icons.close)
                ),
                IconButton(
                    onPressed: (){
                      var val = {'id': 3, 'image': widget.userImage, 'likes': 0, 'date': 'Aug 11', 'content': inputValue, 'liked': false, 'user': 'Hminor'};
                      widget.insertData(val);
                      Navigator.pop(context);
                    },
                    icon: Icon(Icons.add)
                ),
              ],
            )
          ],
        )
    );

  }
}

class Store1 extends ChangeNotifier {
  var follow = 0;
  var check = false;
  isClick() async{
    if (check == false) {
      follow++;
      check = true;
    } else {
      follow--;
      check = false;
    }
    notifyListeners();
  }
}

class Store2 extends ChangeNotifier{
  var getImage = [];
  getData() async{
    var result = await http.get(Uri.parse('https://codingapple1.github.io/app/profile.json'));
    getImage = await jsonDecode(result.body);
    print(getImage);
    notifyListeners();
  }
}

// Profile
class Profile extends StatelessWidget {
  const Profile({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Instagram'),
        ),
      body: CustomScrollView(
        slivers: [
          SliverToBoxAdapter(
            child: ProfileHeader(),
          ),
          SliverGrid(
            delegate: SliverChildBuilderDelegate(
              (c,i)=> Image.network(context.watch<Store2>().getImage[i]),
              childCount: context.watch<Store2>().getImage.length
            ),
            gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 1),
          )
        ],
      )
    );
  }
}

class ProfileHeader extends StatelessWidget {
  const ProfileHeader({super.key});

  @override
  Widget build(BuildContext context) {
    return Row (
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      children: [
        CircleAvatar(
          radius: 30,
          backgroundColor: Colors.grey,
        ),
        Text("팔로워 ${context.watch<Store1>().follow}"),
        ElevatedButton(onPressed: (){
          context.read<Store1>().isClick();
        }, child: Text(context.watch<Store1>().check == false?'팔로우':'팔로워')),
        ElevatedButton(onPressed: ()async{
          await context.read<Store2>().getData();
        }, child: Text('사진가져오기')),
      ],
    );
  }
}
