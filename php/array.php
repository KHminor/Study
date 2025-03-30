<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Array</title>
</head>
<body>
  <?php
    $arr = ['egoing', 'leezche', 'duru', 'check'];
    for ($i=0; $i<count($arr); $i++) {
      echo $arr[$i].'<br/>';
    }
    ?>
  <br>
  <?php
  array_push($arr,'java');
  for ($i=0; $i<count($arr); $i++) {
    echo $arr[$i].'<br/>';
  }
  ?>
  <br>
  <?php
    unset($arr[1]);
    $arr = array_values($arr);    
    for ($i=0; $i<count($arr); $i++) {
      echo $arr[$i].'<br/>';
    }
    ?>

    <br>
    <?php
      // var_dump(array_slice(,2));
      $arr = scandir('./data',1);
      var_dump(array_slice($arr,0,count($arr)-2));
    ?>
</body>
</html>