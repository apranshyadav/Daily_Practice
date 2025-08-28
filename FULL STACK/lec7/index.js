const express = require('express');
const app = express();
const mongoose = require('mongoose');

// Use only one connection string. Uncomment the one you want to use:


// For MongoDB Atlas (replace <password> and <dbname>):
//const mongoURI = 'mongodb+srv://apranshyadav:uIqoLCFcU1LGJSF5@cluster0.lhmq9xu.mongodb.net/';

const mongoURI = 'mongodb://127.0.0.1:27017/begum'; // Change this if you want to use Atlas

mongoose.connect(mongoURI, { useNewUrlParser: true, useUnifiedTopology: true });

const db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
    console.log("Connected successfully");
});

app.get('/', (req, res) => {
    res.send('Welcome to Express with MongoDB!');
});

const Port = 8000;
app.listen(Port, () => {
    console.log(`Server is running on http://localhost:${Port}`);
});