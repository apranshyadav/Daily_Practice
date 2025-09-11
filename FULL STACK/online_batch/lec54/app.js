const express = require('express');
const app = express();
const path = require('path');
const seedDB = require('./seed')
const productRoutes = require('./routes/product')
const ejsMate = require('ejs-mate')
const methodOverride = require('method-override')


// mongoose connection
const mongoose = require('mongoose');
mongoose.connect('mongodb://127.0.0.1:27017/shop-app')
.then(()=>{
    console.log("DB connected successfully"
)})
.catch((err)=>{
    console.log("DB error");
    console.log(err)
})
 

app.engine('ejs',ejsMate);
app.set('view engine','ejs');
//views folder
app.set('views',path.join(__dirname, 'views'));
// public folder
app.use(express.static(path.join(__dirname,'public')));
app.use(express.urlencoded({extended:true}));
app.use(methodOverride('_method'))
// Seeding database
// seedDB()




app.use(productRoutes);

app.listen(8080,()=>{
    console.log("Server connected at 8080")
})












