<html>
<body>
<form action="#" method="post">
    <p>Please enter your name</p>
    <label>
        <input type="text" name="FIRST_NAME">
    </label>
    <br/>
    <p>Please enter your last name</p>
    <label>
        <input type="text" name="LAST_NAME">
    </label>
    <br/>
    <p>Select gender </p>
    <input type="radio" id="contactChoice1"
           name="MEN" value="men">
    <label for="contactChoice1">MEN</label>

    <input type="radio" id="contactChoice2"
           name="WOMEN" value="women">
    <label for="contactChoice2">WOMEN</label>
    <br/>
    <p>Input your password </p>
    <label>
        <input type="password" name="USER_PASSWORD">
    </label>
    <br/>
    <p>Confirm information processing </p>
    <input type="checkbox" id="agree" name="agree" value="agree">
    <label for="agree">Agree</label>
    <br/>
    <button type="submit">Select</button>
</form>
</body>
</html>
