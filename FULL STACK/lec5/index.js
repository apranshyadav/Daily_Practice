const express = require('express');
const path = require('path');
const app = express();

// let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
const blogs = [
    {
        id: 1,
        author: "Sunny Yaduvanshi",
        comment: "kaise hai yeh TANN HIGH"
    },
    {
        id: 2,
        author: "Uzzwal Moti ",
        comment: "PAAAAAANI  PAAAAANI PAAAANI"
    },
    {
        id: 3,
        author: "DU",
        comment: "AAAZAAADI AAAZAADI"
    },
    {
        id: 4,
        author: "RAO JI",
        comment: "27 mein apni sarkaar"        
    }]


let password = 212212;
app.use((req,res,next)=>{
    if(password === 212212){
        next();
    }
    else{
        res.send("Chal be katt le yaha se");
    }
})

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));
app.use(express.static(path.join(__dirname, 'public')));
app.use(express.urlencoded({ extended: true }));

app.get('/', (req, res) => {
    res.send('Welcome to root Route!');
});

app.get('/blogs', (req, res) => {
    res.render('blogs/index', { blogs });
});

app.get('/blogs/new', (req, res) => {
    res.render('blogs/new');
});

app.post('/blogs', (req, res) => {
    let { author, comment } = req.body;
    blogs.push({ id: blogs.length + 1 ,author, comment });
    res.send("Blog created successfully!");
});




const PORT = 8080;
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});