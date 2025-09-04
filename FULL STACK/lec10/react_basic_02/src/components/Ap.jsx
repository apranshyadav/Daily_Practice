export function Ap() {
    let a = 10;
    let b = "Apransh";
    let c = true;
    let d = false;
    let e = null;
    let f = undefined;
    function budbak(){
        console.log("I am budbak function");
    }
    function autaat(){
        console.log("I am autaat function");
    }

    function budbak(){
        console.log("Chal bey Budbak");
    }


    function autaat(a,b,c){
        console.log("Autaat mein rahiyo laadle", a+b+c);
    }

    return (
        <div>
            <h1>Welcome Sam</h1>
            <h1>{a}</h1>
            <h1>{b}</h1>
            <h1>{JSON.stringify(c)}</h1>
            <h1>{JSON.stringify(d)}</h1>
            <h1>{JSON.stringify(e)}</h1>
            <h1>{JSON.stringify(f)}</h1>
            <button onClick={budbak}>Dabao NAA</button>
            <button onClick={()=>{autaat(10,20,30)}}>Dabaiye naa</button>
        </div>
    )
}


// export function Ap(){
//     // UPAR VAAALI DUNIYAAAA
//     let a = 10;
//     let b = 'yadav';
//     let c = true;
//     let d = [1,2,3,4,5];
//     let e = {name: 'Rao Sahab', age: 24, isMarried: false};
//     let f = undefined;


//     // Neeche vaaali duniyaaa
//     return (
//         <div>
//             <h1>a : {a}</h1>
//             <h1>{b}</h1>
//             <h1>{c}</h1>
//             <h1>{d}</h1>
//             <h1>{e.name}</h1>
//             <h1>{f}</h1>
//         </div>
//     );
// }
