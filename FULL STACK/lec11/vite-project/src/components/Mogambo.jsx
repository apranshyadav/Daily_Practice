import { useState } from "react"

function Mogambo({naam}){
    let [name, setName] = useState(naam);
    function handleNaam(){
        console.log(name, "before");
        setName('Anonymous');
        console.log(name, "After");
    }


    return(
        <div>
            <button onClick={handleNaam}>Naam Badal do = {name}</button>
        </div>
    )
}

export default Mogambo;
















// function Mogambo({naam}){
//     let myName = (naam);
//     function handleNaam(){
//         console.log(myName, "before");
//         myName = "Anonymous";
//         console.log(myName, "After");

//     }


//     return(
//         <div>
//             <button onClick={handleNaam}>Naam Badal do = {myName}</button>
//         </div>
//     )
// }

// export default Mogambo