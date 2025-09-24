import React, { memo, useState } from 'react';

const Chotu = memo(function ({ naam }) {
        return <h1>Chai leke aaya malik: {naam}</h1>;
});

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

export default Person;