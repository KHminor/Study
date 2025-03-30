<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Variable</title>
</head>
<body>
  <h1>Variable</h1>
  <?php
    $name = "Hminor";
    $var = "Lorem ipsum dolor egoing sit amet 
    consectetur adipisicing egoing elit. 
    Iusto minus labore voluptates egoing maiores 
    assumenda, egoing laudantium, officiis atque quae molestiae quam, 
    ipsum et omnis quis egoing deserunt recusandae enim! 
    Delectus, egoing porro magnam.";
    echo str_replace('egoing', $name, $var);
  ?>
</body>
</html>