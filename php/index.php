<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Index</title>
  <?php
    $id = isset($_GET['id'])?$_GET['id']:null;
  ?>
</head>
<body>
  <h1>WEB</h1>

  <ol>
    <?php
      $list = scandir('./data'); // data 폴더 파일 목록
      for ($i=2; $i<count($list); $i++) {
        echo "<li><a href='index.php?id={$list[$i]}'>{$list[$i]}</a></li>";
      }
    ?>
  </ol>
  
  <?php
    if (isset($id)) {
      echo file_get_contents('./data/'.$id);
    }
  ?>
</body>
</html>