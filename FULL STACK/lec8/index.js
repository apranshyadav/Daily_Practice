const express = require('express');
const app = express();
const mongoose = require('mongoose');
const path = require('path');

mongoose.connect('mongodb://127.0.0.1:27017/neta').then(() => {
    console.log('MongoDB connected');
})
.catch(err => {
    console.error('MongoDB connection error:', err);
});

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));
app.use(express.static(path.join(__dirname, 'public')));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));


// Routes
app.get('/', (req, res) => {
    res.send('Welcome to the Home Page');
});


const PORT = 8000;
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});