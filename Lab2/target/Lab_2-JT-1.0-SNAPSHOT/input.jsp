<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>File Upload</title>
</head>
<body>
<h2>Upload a Text File</h2>
<form action="upload" method="post" enctype="multipart/form-data">
  <input type="file" name="file" accept=".txt" required>
  <input type="submit" value="Upload">
</form>
</body>
</html>
