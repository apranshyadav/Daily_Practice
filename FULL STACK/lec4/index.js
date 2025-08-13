const express = require('express');
const path = require('path');
const app = express();

let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

app.get('/', (req, res) => {
    res.send('Welcome to root Route!');
});

app.get('/ujjwal', (req, res) => {
    res.render('index', {arr});
});

app.get(/.*/, (req, res) => {
    res.send('Page Not Found');
});

const PORT = 8080;
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});