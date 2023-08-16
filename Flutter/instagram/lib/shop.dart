import 'package:flutter/material.dart';
// firestore 사용
import 'package:cloud_firestore/cloud_firestore.dart';
// firebase_auth (인증)
import 'package:firebase_auth/firebase_auth.dart';
final auth = FirebaseAuth.instance;

// firebase의 firestore를 사용시 유용한 함수가 담겨 있음
final firestore = FirebaseFirestore.instance;

class Shop extends StatefulWidget {
  const Shop({super.key});
  @override
  State<Shop> createState() => _ShopState();
}

class _ShopState extends State<Shop> {

  signUp() async{
    try {
      var result = await auth.createUserWithEmailAndPassword(
          email: 'test2@naver.com',
          password: '123123'
      );
    } catch (e) {
      print(e);
    }
  }

  login() async{
    try {
      await auth.signInWithEmailAndPassword(
          email: 'test2@naver.com',
          password: '123123'
      );
    } catch (e) {
      print(e);
    }

    if (auth.currentUser?.uid == null) {
      print('로그인 하슈!!!');
    } else {
      print('로그인 했네!');
    }
  }

  logout() async{
    await auth.signOut();
  }

  // getData() async{
  //   // await firestore.collection('컬렉션ID').doc('도큐먼트ID').get();
  //   // await firestore.collection('product').get();
  //   try {
  //     var result = await firestore.collection('product').get();
  //     for (var doc in result.docs) {
  //       print(doc['name']);
  //       print(doc['price']);
  //     }
  //   } catch (e) {
  //     print('실패닷!');
  //   }
  // }

  uidCheck()async{
    print(auth.currentUser?.uid);
  }
  
  addData() async{
    try {
      print(auth.currentUser?.uid);
      await firestore.collection('product').add({'name': '상의', 'price': 5000, 'uid': auth.currentUser?.uid});
    } catch (e) {
      print('저장실패!');
    }
  }

  @override
  void initState() {
    super.initState();
    // getData();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        children: [
          Text('샵페이지!'),
          ElevatedButton(onPressed: (){
            login();
          }, child: Text('로그인하기')),
          ElevatedButton(onPressed: (){
            uidCheck();
          }, child: Text('uid체크')),
          ElevatedButton(onPressed: (){
            logout();
          }, child: Text('로그아웃')),
          ElevatedButton(onPressed: (){
            addData();
          }, child: Text('데이터 추가'))
        ],
      ),
    );
  }
}
