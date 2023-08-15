import 'package:flutter/material.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:timezone/data/latest_all.dart' as tz;
import 'package:timezone/timezone.dart' as tz;

final notifications = FlutterLocalNotificationsPlugin();


//1. 앱로드시 실행할 기본설정
initNotification(context) async {

  //안드로이드용 아이콘파일 이름
  var androidSetting = AndroidInitializationSettings('alarm');

  //ios에서 앱 로드시 유저에게 권한요청하려면
  var iosSetting = DarwinInitializationSettings(
    requestAlertPermission: true,
    requestBadgePermission: true,
    requestSoundPermission: true,
  );

  var initializationSettings = InitializationSettings(
      android: androidSetting,
      iOS: iosSetting
  );
  await notifications.initialize(
      initializationSettings,
      // //알림 누를때 함수실행하고 싶으면
      // onSelectNotification: (payload){
      //   Navigator.push(
      //       context,
      //       MaterialPageRoute(builder: (context)=> Text('새로운 페이지'))
      //   );
      // }
  );
}

//2. 이 함수 원하는 곳에서 실행하면 알림 뜸
showNotification() async {

  var androidDetails = AndroidNotificationDetails(
    '유니크한 알림 채널 ID',
    '알림종류 설명',
    priority: Priority.high, // 우선순위
    importance: Importance.max, // 중요도
    color: Color.fromARGB(255, 255, 0, 0),
  );

  var iosDetails = DarwinNotificationDetails(
    presentAlert: true,
    presentBadge: true,
    presentSound: true,
  );

  // 알림 id, 제목, 내용 맘대로 채우기
  notifications.show(
      1, // 알림의 유니크한 ID
      '제목1',
      '내용1',
      NotificationDetails(android: androidDetails, iOS: iosDetails)
  );
}

showNotification2() async {
  // 시간 관련 함수를 사용하겠다는 함수를 실행
  tz.initializeTimeZones();

  // 아래 코드는 위의 showNotification 와 같다.
  var androidDetails = const AndroidNotificationDetails(
    '유니크한 알림 ID',
    '알림종류 설명',
    priority: Priority.high,
    importance: Importance.max,
    color: Color.fromARGB(255, 255, 0, 0),
  );
  var iosDetails = const DarwinNotificationDetails(
    presentAlert: true,
    presentBadge: true,
    presentSound: true,
  );

  // 여기가 좀 다름
  // tz.TZDateTime.now(tz.local) 는 현재 시간을 의미하고
  // .add(Duration()) 으로 얼마나 뒤에 알람을 보낼 것인지를 조절할 수 있다.
  notifications.zonedSchedule(
      2,
      '제목2',
      '내용2',
      // makeDate(15,07,50),
      tz.TZDateTime.now(tz.local).add(Duration(seconds: 3)),
      NotificationDetails(android: androidDetails, iOS: iosDetails),
      androidAllowWhileIdle: true,
      uiLocalNotificationDateInterpretation:
      UILocalNotificationDateInterpretation.absoluteTime,
      matchDateTimeComponents: DateTimeComponents.time
  );
}

makeDate(hour, min, sec){
  var now = tz.TZDateTime.now(tz.local);
  var when = tz.TZDateTime(tz.local, now.year, now.month, now.day, hour, min, sec);
  if (when.isBefore(now)) {
    return when.add(Duration(days: 1));
  } else {
    return when;
  }
}
