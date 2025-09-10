import { useState } from "react"

function Counter(){
    let [count,setCount] = useState(0);

    function handleInc(){
        // setCount(count+1);
        // setCount(count+2);
        // setCount(count+3000);
        // setCount((lol)=>lol+1); //callback function holds the previous value
        // setCount((lol)=>lol+1);
        setCount((lol)=>lol+10); //10
        setCount(count+1)        //1
        setCount((lol)=>lol+2);  //3


    }

    function handleDec(){
        // setCount(count-1);
        // setCount(count-10);
        // setCount(count-463);
    }

    return(
        <div>
            <button onClick={handleDec}>DEC</button>
            <h1>Count : {count} </h1>
            <button onClick={handleInc}>INC</button>

        </div>
    )
}
export default Counter