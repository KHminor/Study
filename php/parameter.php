<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Parameter</title>
  <?php
    $address = $_GET['address'];
    $name = $_GET['name'];
  ?>
</head>
<body>
  안녕하세요. <br> 
  <?php echo $address ?>에 사시는 
  <?php echo $name ?>님
</body>
</html>