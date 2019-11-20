<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div class="container container-post">
        <div class="row">
            <div class="col">
                <h2>Add post</h2>
                <form action="http://localhost:8080/add" method="post" enctype="multipart/form-data">
                    <input name="photo" type="file" accept="image/jpeg,image/png"class="form-control-file post-photo-upload">
                    <div class="form-group">
                        <label for="desc">Information</label>
                        <textarea class="form-control" id="text" name="text_inform" placeholder="text" rows="5"
                                  cols="20"></textarea>
                    </div>
                    <input type="submit" value="publish" class="btn btn-warning"/>
                </form>
            </div>
        </div>
    </div>
</body>
</html>