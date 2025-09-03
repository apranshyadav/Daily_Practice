const NetaModel = require("C:\Users\Asus\Desktop\Practise Daily\FULL STACK\lec8\neta.model.js")

async function readNetas(req,res){
    try{
        const allNetas = await NetaModel.find();
        return res.status(200).json(allNetas)
    }
    catch(err){
        res.status(404).json({messag:"Error in the route"})
    }
}

module.exports = {readNetas}