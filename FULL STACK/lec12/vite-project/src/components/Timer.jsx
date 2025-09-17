import React, { useEffect, useState } from "react";

const Timer = () => {
  const [count, setCount] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setCount((prev) => prev + 1);
    }, 1000);

    // Cleanup function which executes between two re-renders
    return () => clearInterval(interval);
  }, []);

  return (
    <div>
      <h1>Timer: {count} seconds</h1>
    </div>
  );
};

export default Timer;

