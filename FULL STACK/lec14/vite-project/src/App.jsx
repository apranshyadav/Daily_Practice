import React from 'react';
import { Link, Routes, Route, useNavigate } from 'react-router-dom';
import Home from './components/Home';
import Dashboard from './components/Dashboard';
import About from './components/About';

function App() {
  const navigate = useNavigate();
  function handleBtn(){
    navigate('/')
  }
  return (
    <div>
      <Link to="/">Home</Link>
      <button onClick={handleBtn}>Home</button>
      <Link to="/dashboard">Dashboard</Link>
      <button onClick={handleBtn}>Home</button>
      <Link to="/about">About</Link>
      <button onClick={handleBtn}>Home</button>
        
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/about" element={<About />} />
      </Routes>
    </div>
  );
}

export default App;