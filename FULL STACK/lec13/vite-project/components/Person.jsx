import React, { memo, useMemo, useState } from 'react';



const UseCallback = () => {
    const [count, setCount] = React.useState(0);
    let a = function() {console.log("Chai launga")};
    return (
        <div>
            <Chotu chai={a} />
            <button onClick={() => setCount(count + 1)}>Counter: {count}</button>
        </div>
    );
}

const Chotu = memo(function ({ naam }) {
    console.log("Chotu rendered");
    return <h1>Chai leke aaya malik: {naam}</h1>;
});

// const Chotu = memo(({ chai }) => {
    
//     return (
//         <h1>mai launga chai:{chai}</h1>
//     );
// });



function UseMemo(){
    const [inp, setInp] = useState(0);
    const [count, setCount] = useState(0);
    let ans = 0;
    let out = useMemo(()=>{
        for(let item=1; item<=Number(inp); item++){ 
            console.log('loop chala');
            ans+=item;
        }
        return ans
    },[inp]);

    console.log("Ans is: ", out);

    
    function handleInput(e){
        setInp(e.target.value);
    }

     return (
        <div>
            <input onChange={handleInput} type="text" value={inp} />
            <h1>Ans: {ans}</h1>
            <button onClick={() => setCount(count + 1)}>Counter: {count}</button>
        </div>
    );

}

const Person = () => {
    const [dog, setDog] = useState("Simba");

    // Function to change dog
    function changeDog() {
        setDog(Math.floor(Math.random() * 10)); 
    }

    let [inp, setInp] = useState('');
    function handleInput(e){
        setInp(e.target.value)
    }


    // Child component
    // function Chotu({ naam }) {
    //     return <h1>Chai leke aaya malik: {naam}</h1>;
    // }
    

    return (
        <div>
            <input onChange={handleInput} type='text' value={inp} />
            <Chotu naam={dog} />
            <button onClick={changeDog}>Change Dog</button>
            <Chotu naam="Chotu" />
            <Chotu naam="Simba" />
            <Chotu naam="Nepali" />
            <Chotu naam="Dodo" />
        </div>
    );
};

// export default Person;
// export default UseMemo;
export default UseCallback;