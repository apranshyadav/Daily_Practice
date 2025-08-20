const express = require('express');
const app = express();
const path = require('path');

const blog = [
    {
        id: 1,
        title: "Arjit",
        content: "Aaj dekhenge Wednesday"
    },
    {
        id: 2,
        title: "Home",
        content: "Chalo ghar chale"
    },
    {
        id: 3,
        title: "Placement",
        content: "Level sabke niklenge"
    }
];

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));
app.use(express.static(path.join(__dirname, 'public')));
//Body parsing middleware (body by defalut is undefined)
app.use(express.urlencoded({ extended: true })); // Parse form data

//Middleware
// let password = 1800;
// app.use('/blogs', (req, res, next) => {
//     if (password==800){
//         next();
//     }else{
//         res.send("Bhai Passwrod galat h, you are not allowed");
//     }
// })





// Root Route
app.get("/", (req, res) => {
    res.send("Hello From root Route!");
});

// CRUD Operations

// CREATE Form - Display form to create a new blog
app.get('/blogs/new', (req, res) => {
    res.render("blogs/new");
});


//Read a particular blog
app.get('/blogs/:id', (req, res) => {
    console.log(req.params.id);
    let foundBlog = blog.find((blog) => blog.id == req.params.id);
    res.render('blogs/show', { blog: foundBlog });    
});


// CREATE - Create a new blog
app.post('/blogs', (req, res) => {
    const { title, author, content } = req.body;
    const newBlogPost = {
        id: Date.now(),
        title,
        author,
        content
    };
    blog.push(newBlogPost);
    res.redirect('/blogs');
});


// READ - Get all blogs
app.get('/blogs', (req, res) => {
    res.render('blogs/index', { blog });
});

const PORT = 8080;
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});

//middleware are function that are used to process the request and response objects
// that executes oncec the request is intiatwd and you are about to reach the response
