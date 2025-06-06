<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>Dragon Ball Characters</title>
</head>
<body>
<div class="container mt-4">
    <h1>Dragon Ball Characters</h1>

    <table id="characterTable" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Ki</th>
            <th>Race</th>
            <th>Description</th>
            <th>Image</th>
            <th>Max Ki</th>
            <th>Gender</th>
            <th>Affiliation</th>
        </tr>
        </thead>
        <tbody>
        <!-- Dragon Ball characters will be dynamically added using JavaScript -->
        </tbody>
    </table>

    <div class="form-group mt-4">
        <label for="kiRange">Filter by Ki Range:</label>
        <input type="text" id="kiRange" class="form-control" placeholder="E.g., 5000000-10000000">
    </div>

    <div class="form-group">
        <label for="raceFilter">Filter by Race:</label>
        <select id="raceFilter" class="form-control">
            <!-- Race options will be dynamically added using JavaScript -->
        </select>
    </div>

    <button id="filterButton" class="btn btn-primary">Filter</button>
    <button id="resetButton" class="btn btn-secondary">Reset Filters</button>
</div>

<script src="/js/app.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
</body>
</html>