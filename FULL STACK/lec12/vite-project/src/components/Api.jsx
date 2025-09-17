


// BY FETCH
// import React, { useEffect, useState } from 'react';

// const Api = () => {
//     const [data, setData] = useState([]);
//     const API = "https://jsonplaceholder.typicode.com/todos";
//     useEffect(() => {
//         async function apicalling() {
//             let response = await fetch(API);
//             let json = await response.json();
//             setData(json);
//         }
//         apicalling();
//     }, []);
//     return (
//         <div>
//             <h1>API</h1>
//             {
//                 data.map((item, index) => {
//                     return (
//                         <div>
//                             <h1>Title: {item.title}</h1>
//                         </div>
//                     )
//                 })
//             }
//         </div>
//     );
// }

// export default Api;

// BY AXIOS

// import React, { useEffect, useState } from 'react';
// import axios from 'axios';

// const Api = () => {
//     const [data, setData] = useState([]);
//     const API = "https://jsonplaceholder.typicode.com/todos";
//     useEffect(() => {
//         async function apicalling(){
//             let data = await axios.get(API);
//             setData(data.data)
//         }
//         apicalling()
//         // axios.get(API)
//         //     .then((resp) => {
//         //         setData(resp.data);
//         //     })
//         //     .catch((err) => console.log(err));
//     }, []);
//     return (
//         <div>
//             <h1>API</h1>
//             {
//                 data.map((item, index) => {
//                     return (
//                         <div key={item.id}>
//                             <h1>Title: {item.title}</h1>
//                         </div>
//                     )
//                 })
//             }
//         </div>
//     );
// }

// export default Api;