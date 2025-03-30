<?php
  // is_file: 파일이 존재하는지
  // var_dump: 데이터 타입과 리턴 값 확인
  var_dump(is_file("data.txt")); 
  echo nl2br("\n"); // 개행

  // is_dir: 디렉토리 인지
  var_dump(is_dir("data.txt"));
  echo nl2br("\n");
  
  // 파일 저장
  file_put_contents("data.txt", rand(1, 100));
  
  // 파일의 내용 읽기
  var_dump(file_get_contents("data.txt"));
  echo nl2br("\n");

?>