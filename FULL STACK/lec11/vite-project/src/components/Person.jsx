function Person(props){
    // console.log(props, "props")

    return(
        <div>
            <h1>Name : {props.name}</h1>
            <h1>Age : {props.age}</h1>
            <h1>Color : {props.favColor} </h1>
        </div>
    )
}
export default Person