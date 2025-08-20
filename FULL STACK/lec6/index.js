const express = require('express');
const path = require('path');
const app = express();

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));
app.use(express.static(path.join(__dirname, 'public')));
app.use(express.urlencoded({ extended: true }));

app.get('/', (req, res) => {
    res.send('Welcome to root Route!');
});
    
app.get('/human', (req, res) => {
    res.send('Welcome to Human Route!');
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

// Particular Blog

app.get('/blogs/:idd', (req, res) => {
    let { idd } = req.params;
    let foundblog = blogs.find((blog) => blog.id == idd);
    res.render('blogs/show', { foundblog });
});


// CRUD
// Create, Read, Update, Delete

const blogs = [
    {
        id: 1,
        author: 'Ujjwal',
        comment: "Aaj kamaenga to kl bathke khaenge",
    },
    {
        id: 2,
        author: 'Arpit',
        comment: "Aaj khaenge to kl kamaenge",
    },
    {
        id: 3,
        author: 'Anshul',
        comment: "Aaj khaenge to kl khaenge",
    },
    {
        id: 4,
        author: 'Aryan',
        comment: "Papa woh cycle ki toh....",
    }
]

const PORT = 8080;
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});

//middleware are function that are used to process the request and response objects
// that executes oncec the request is intiatwd and you are about to reach the response
