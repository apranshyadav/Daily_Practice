// import fs from 'fs' //esmodule
const fs = require('fs')

// let data = "Happy birthday to youuuu"
// fs.writeFile('ap.txt', data, {
//     encoding: "utf-8",
//     flag: 'w'
// }, (err)=>{
//     if(err){
//         throw err;
//     }
//     console.log('File is created')
// })

// fs.readFile('ap.txt', {
//     encoding: 'utf-8',
//     flag: 'r'
// }, (err,data)=>{
//     if(err){throw err}
//     console.log(data)
// })

// let d = '\nArjit ka birthdaay hai 15th September ko'
// fs.appendFile('ap.txt', d, {
//     encoding: 'utf-8',
// }, (err)=>{
//     if(err){throw err}
//     console.log('Ho gya update saale')
// })

fs.unlink('ap.txt',(err)=>{
    if(err){throw error}
    console.log("Khatam.... Tata... Bye bye")
})

