import 'package:flutter/material.dart';

var theme = ThemeData(
    appBarTheme: AppBarTheme(
        titleTextStyle: TextStyle(color: Colors.black, fontSize: 22),
        color: Colors.white,
        elevation: 1,
        actionsIconTheme:  IconThemeData(
            size: 30,
            color: Colors.black
        )
    ),
  bottomNavigationBarTheme: BottomNavigationBarThemeData(
    selectedItemColor: Colors.black,
    unselectedItemColor: Colors.black
  )
);