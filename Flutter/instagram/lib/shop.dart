import 'package:flutter/material.dart';

// firestore 사용
import 'package:cloud_firestore/cloud_firestore.dart';

// firebase의 firestore를 사용시 유용한 함수가 담겨 있음
final firestore = FirebaseFirestore.instance;

class Shop extends StatefulWidget {
  const Shop({super.key});
  @override
  State<Shop> createState() => _ShopState();
}

class _ShopState extends State<Shop> {

  getData() async{
    // await firestore.collection('컬렉션ID').doc('도큐먼트ID').get();
    try {
      var result = await firestore.collection('product').where('price', isEqualTo: 3000).get();
      for (var doc in result.docs) {
        print(doc['name']);
        print(doc['price']);
      }
    } catch (e) {
      print('실패닷!');
    }
  }

  // addData() async{
  //   try {
  //     await firestore.collection('product').add({'name': '상의', 'price': 3000});
  //   } catch (e) {
  //     print('저장실패!');
  //   }
  // }

  @override
  void initState() {
    super.initState();
    getData();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Text('샵페이지!'),
    );
  }
}
