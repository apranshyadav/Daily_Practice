const mongoose = require('mongoose');

const Product = require('./models/Product.js');

const products = [
    {
        name:"Samsung S24 Ultra",
        img:"https://images.samsung.com/in/smartphones/galaxy-s24-ultra/images/galaxy-s24-ultra-highlights-color-titanium-gray-back-mo.jpg?imbypass=true",
        price: 190000,
        desc: "Chal bey, Aukaat mey reh"
    },
    {
        name:"Nike Air Jordan 4",
        img:"https://static.nike.com/a/images/t_PDP_936_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/8282e3d5-1a86-4452-a4d5-55c5ba21be06/WMNS+AIR+JORDAN+4+NET.png",
        price: 16000,
        desc: "Tera ghar jayengaa ismee"
    },
    {
        name:"Boroplus",
        img:"https://www.fitbynet.com/wp-content/uploads/2020/05/BORO-PLUS-ANTISEPTIC-CREAM-1441972139-10021036.jpg",
        price: 50,
        desc: "lagaaa le man ho toh"
    },
    {
        name:"Porshe Gt3 RS Model",
        img:"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRORvzNODhkJ-OLYYpEFadGibKU4FYe5gvaDA&s",
        price:11000,
        desc:"Yahi lele, real aukaat mein nhi h tere"
    }
]

async function seedDB(){
    await Product.insertMany(products);
    console.log("data seeded successfully");
}

module.exports = seedDB;