import React, { useEffect, useState } from "react";


// LEGALLY WAY
// const Timer = () => {
//   const [count, setCount] = useState(0);

//   useEffect(() => {
//     const interval = setInterval(() => {
//       setCount((prev) => prev + 1);
//     }, 1000);

//     // Cleanup function which executes between two re-renders
//     return () => clearInterval(interval);
//   }, []);

//   return (
//     <div>
//       <h1>Timer: {count} seconds</h1>
//     </div>
//   );
// };


//JUGAAD
const Timer = () => {
  const [count, setCount] = useState(0);

  useEffect(() => {
    setTimeout(() => {
      setCount(count+1);
    }, 1000);
  }, [count]);

  return (
    <div>
      <h1>Timer: {count} seconds</h1>
    </div>
  );
};

export default Timer;

